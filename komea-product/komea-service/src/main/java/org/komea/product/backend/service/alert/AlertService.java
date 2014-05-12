
package org.komea.product.backend.service.alert;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.komea.product.backend.api.IKPIService;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.database.dto.BaseEntityDto;
import org.komea.product.database.dto.KpiAlertDto;
import org.komea.product.database.dto.MeasureDto;
import org.komea.product.database.dto.SearchKpiAlertsDto;
import org.komea.product.database.dto.SearchMeasuresDto;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.ExtendedEntityType;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.KpiAlertType;
import org.komea.product.database.model.Measure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;



/**
 * @author sleroy
 */
@Service
@Transactional
public class AlertService implements IAlertService
{
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AlertService.class);
    
    @Autowired
    private IAlertTypeService   alertTypeService;
    
    @Autowired
    private IEntityService      entityService;
    
    @Autowired
    private IKPIService         kpiService;
    
    
    
    /**
     * @param _alertCriteria
     * @param _mapKpis
     * @return
     */
    public KpiAlertDto findAlert(final AlertCriteria _alertCriteria, final IdKpiMap _mapKpis) {
    
    
        final Measure measure = findMeasure(_alertCriteria);
        if (measure == null) {
            return null;
        }
        
        final KpiAlertDto kpiAlert = new KpiAlertDto();
        kpiAlert.setKpiAlertType(_alertCriteria.getAlertType());
        final Kpi kpi = _mapKpis.get(_alertCriteria.getAlertType().getIdKpi());
        kpiAlert.setKpi(kpi);
        kpiAlert.setDate(new Date());
        kpiAlert.setEntityName(_alertCriteria.getEntity().getDisplayName());
        kpiAlert.setValue(measure.getValue());
        kpiAlert.setActivated(isAlertActivated(_alertCriteria.getAlertType(), measure.getValue()));
        
        return kpiAlert;
    }
    
    
    @Override
    public List<KpiAlertDto> findAlerts(final SearchKpiAlertsDto _searchAlert) {
    
    
        final ExtendedEntityType extendedEntityType = _searchAlert.getExtendedEntityType();
        final EntityType entityType = extendedEntityType.getEntityType();
        final List<KpiAlertType> alertTypesOfKpiAndSeverity =
                alertTypeService.getAlertTypes(extendedEntityType,
                        _searchAlert.getKpiAlertTypeKeys(), _searchAlert.getSeverityMin());
        final List<BaseEntityDto> parentEntities =
                entityService.getBaseEntityDTOS(entityType, _searchAlert.getEntityKeys());
        final List<BaseEntityDto> entities =
                entityService.getSubEntities(extendedEntityType, parentEntities);
        
        final IdKpiMap idKpiMap = new IdKpiMap();
        final Set<String> kpiKeys = idKpiMap.fillIdKpi(alertTypesOfKpiAndSeverity, kpiService);
        final SearchMeasuresDto searchMeasuresDto =
                createMeasureFilterOnKpiKeys(_searchAlert, extendedEntityType, kpiKeys);
        // FIXME::measureService.getMeasures(idKpiMap.values(), entities, searchMeasuresDto);
        final List<MeasureDto> measuresOfKpi = Lists.newArrayList();
        final List<KpiAlertDto> filteredActivatedAlerts = Lists.newArrayList();
        for (final KpiAlertType alertType : alertTypesOfKpiAndSeverity) {
            for (final BaseEntityDto entity : entities) {
                final KpiAlertDto kpiAlert =
                        findAlert(new AlertCriteria(alertType, entity, entityType, measuresOfKpi),
                                idKpiMap);
                final boolean alertFiltered = isAlertFiltered(_searchAlert, kpiAlert);
                if (alertFiltered) {
                    filteredActivatedAlerts.add(kpiAlert);
                }
            }
        }
        return filteredActivatedAlerts;
    }
    
    
    /**
     * @param _criteria
     * @return
     */
    public Measure findMeasure(final AlertCriteria _criteria) {
    
    
        for (final Measure measure : _criteria.getMeasures()) {
            if (isAlertIdAssociatedToKpi(_criteria, measure)
                    && isAlertAssociatedToMeasureEntity(_criteria, measure)) {
                return measure;
            }
        }
        
        return null;
    }
    
    
    /**
     * Cette méthode : est ce que le seuil est franchi ?
     * 
     * @param alertType
     * @param value
     * @return
     */
    public boolean isAlertActivated(final KpiAlertType alertType, final Number value) {
    
    
        if (value == null) {
            return false;
        }
        if (!alertType.getEnabled()) {
            return false;
        }
        final int compareTo = Double.compare(value.doubleValue(), alertType.getValue());
        switch (alertType.getOperator()) {
            case DISTINCT:
                return compareTo != 0;
            case GREATER:
                return compareTo > 0;
            case GREATER_OR_EQUAL:
                return compareTo >= 0;
            case LESSER:
                return compareTo < 0;
            case LESSER_OR_EQUAL:
                return compareTo <= 0;
            default:
                return compareTo == 0;
        }
    }
    
    
    /**
     * @param _filter
     * @param kpiAlert
     * @return
     */
    public boolean isAlertFiltered(final SearchKpiAlertsDto _filter, final KpiAlertDto kpiAlert) {
    
    
        return kpiAlert != null && (!_filter.isActivatedOnly() || kpiAlert.isActivated());
    }
    
    
    private SearchMeasuresDto createMeasureFilterOnKpiKeys(
            final SearchKpiAlertsDto _searchAlert,
            final ExtendedEntityType entityType,
            final Set<String> kpiKeys) {
    
    
        final SearchMeasuresDto searchMeasuresDto =
                new SearchMeasuresDto(entityType, new ArrayList<String>(kpiKeys),
                        _searchAlert.getEntityKeys(), 1);
        return searchMeasuresDto;
    }
    
    
    private boolean isAlertAssociatedToMeasureEntity(
            final AlertCriteria _criteria,
            final Measure measure) {
    
    
        final Integer entityId = measure.getEntityID();
        return entityId != null && _criteria.getEntity().getId().equals(entityId);
    }
    
    
    private boolean isAlertIdAssociatedToKpi(final AlertCriteria _criteria, final Measure measure) {
    
    
        return measure.getIdKpi().equals(_criteria.getAlertType().getIdKpi());
    }
}
