
package org.komea.product.backend.service.kpi;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.joda.time.DateTime;
import org.komea.product.backend.api.IEventEngineService;
import org.komea.product.backend.api.IHistoryPurgeAction;
import org.komea.product.backend.api.IKPIService;
import org.komea.product.backend.api.IKpiValueService;
import org.komea.product.backend.api.IMeasureHistoryService;
import org.komea.product.backend.criterias.MeasureDateComparator;
import org.komea.product.backend.genericservice.AbstractService;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.backend.service.history.HistoryKey;
import org.komea.product.database.api.IEntity;
import org.komea.product.database.dao.IGenericDAO;
import org.komea.product.database.dao.KpiDao;
import org.komea.product.database.dao.MeasureDao;
import org.komea.product.database.dto.MeasureDto;
import org.komea.product.database.dto.SearchMeasuresDto;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.Measure;
import org.komea.product.database.model.MeasureCriteria;
import org.komea.product.database.model.MeasureCriteria.Criteria;
import org.komea.product.service.dto.EntityKey;
import org.komea.product.service.dto.EntityStringKey;
import org.komea.product.service.dto.HistoricalValue;
import org.komea.product.service.dto.HistoryStringKey;
import org.komea.product.service.dto.HistoryStringKeyList;
import org.komea.product.service.dto.KpiKey;
import org.komea.product.service.dto.LimitCriteria;
import org.komea.product.service.dto.MeasureResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

/**
 * This interface provides the functions needed to manipulate the history
 *
 * @author sleroy
 * @version $Revision: 1.0 $
 */
@Service
@Transactional
public final class MeasureHistoryService extends AbstractService<Measure, Integer, MeasureCriteria> implements IMeasureHistoryService {
    
    @Autowired
    private IEntityService      entityService;
    
    @Autowired
    private IKPIService         kpiService;
    
    @Autowired
    private IKpiValueService    kpiValueService;
    
    /**
     *
     */
    private static final String DATE_ORDER_DESC = "date DESC";
    
    private static final String DATE_ORDER      = "date";
    private static final Logger LOGGER          = LoggerFactory.getLogger(MeasureHistoryService.class);
    
    /**
     * Build measure criteria from search filter.
     *
     * @param searchMeasuresDto
     *            the search filter
     * @param _historyK
     *            the history key
     * @return the history key
     */
    public static MeasureCriteria buildMeasureCriteriaFromSearchFilter(final SearchMeasuresDto searchMeasuresDto, final HistoryKey _historyK) {
    
        final MeasureCriteria measureCriteria = new MeasureCriteria();
        measureCriteria.setOrderByClause(DATE_ORDER_DESC);
        Criteria criteria = measureCriteria.createCriteria();
        initMeasureCriteria(_historyK, criteria);
        // Add ored criterias
        if (searchMeasuresDto.hasFromDate()) {
            criteria.andDateGreaterThanOrEqualTo(searchMeasuresDto.getFromDate());
        }
        if (searchMeasuresDto.hasToDate()) {
            criteria.andDateLessThanOrEqualTo(searchMeasuresDto.getToDate());
        }
        
        return measureCriteria;
    }
    private static void createEntityCriteriaForMeasure(final EntityKey _entityKey, final MeasureCriteria.Criteria criteria) {
    
        switch (_entityKey.getEntityType()) {
            case PERSON:
                criteria.andIdPersonEqualTo(_entityKey.getId());
                break;
            case PROJECT:
                criteria.andIdProjectEqualTo(_entityKey.getId());
                break;
            case TEAM:
            case DEPARTMENT:
                criteria.andIdPersonGroupEqualTo(_entityKey.getId());
                break;
            default:
                break;
        }
    }
    
    /**
     * Method initMeasureCriteria.
     *
     * @param _kpiKey
     *            HistoryKey
     * @param measureCriteria
     *            MeasureCriteria
     * @return
     */
    private static void initMeasureCriteria(final HistoryKey _kpiKey, final Criteria measureCriteria) {
    
        measureCriteria.andIdKpiEqualTo(_kpiKey.getKpiID());
        if (_kpiKey.hasEntityReference()) {
            createEntityCriteriaForMeasure(_kpiKey.getEntityKey(), measureCriteria);
        }
        
    }
    
    @Autowired
    private IEventEngineService esperEngine;
    
    @Autowired
    private MeasureDao          requiredDAO;
    
    @Autowired
    private KpiDao              kpiDao;
    
    /**
     * Builds the history purge action.
     *
     * @param _kpi
     *            the kpi
     * @return the history purge action. * @see
     *         org.komea.product.cep.tester.IMeasureHistoryService
     *         #buildHistoryPurgeAction(Kpi)
     */
    @Override
    public IHistoryPurgeAction buildHistoryPurgeAction(final Kpi _kpi) {
    
        switch (_kpi.getEvictionType()) {
            case DAYS:
                return new HistoryPurgePerDaysAction(requiredDAO, _kpi);
            case MONTHS:
                return new HistoryPurgePerMonthsAction(requiredDAO, _kpi);
            case VALUES:
                return new HistoryPurgePerValuesAction(requiredDAO, _kpi);
                
        }
        return null;
        
    }
    
    private RowBounds buildRowBounds(final Integer limit) {
    
        return new RowBounds(0, limit == null ? Integer.MAX_VALUE : limit);
    }
    
    @Override
    protected MeasureCriteria createKeyCriteria(final String key) {
    
        throw new UnsupportedOperationException("Not supported.");
    }
    
    /**
     * Method getEsperEngine.
     *
     * @return IEventEngineService
     */
    public final IEventEngineService getEsperEngine() {
    
        return esperEngine;
    }
    
    @Override
    public List<Measure> getFilteredHistory(final HistoryKey _kpiKey, final int _nbRow, final MeasureCriteria _measureCriteria) {
    
        return getFilteredHistory(_kpiKey, _nbRow, _measureCriteria, _measureCriteria.createCriteria());
    }
    
    /**
     * (non-Javadoc)
     *
     * @see org.komea.product.backend.api.IHistoryService#getFilteredHistory(org.komea.product.backend.service.history.HistoryKey, int,
     *      org.komea.product.database.model.MeasureCriteria, org.komea.product.database.model.MeasureCriteria.Criteria)
     */
    @Override
    public List<Measure> getFilteredHistory(final HistoryKey _kpiKey, final int _nbRow, final MeasureCriteria _measureCriteria,
            final Criteria criteria) {
    
        final RowBounds rowBounds = new RowBounds(0, _nbRow);
        _measureCriteria.setOrderByClause(DATE_ORDER_DESC);
        _measureCriteria.getOredCriteria();
        initMeasureCriteria(_kpiKey, criteria);
        
        return getListOfMeasures(rowBounds, _measureCriteria);
    }
    
    /**
     * (non-Javadoc)
     *
     * @see org.komea.product.backend.api.IHistoryService#getFilteredHistory(org.komea.product.backend.service.history.HistoryKey,
     *      org.komea.product.database.model.MeasureCriteria)
     */
    @Override
    public List<Measure> getFilteredHistory(final HistoryKey _historyKey, final MeasureCriteria _measureCriteria) {
    
        return getFilteredHistory(_historyKey, _measureCriteria, _measureCriteria.createCriteria());
        
    }
    /**
     * (non-Javadoc)
     *
     * @see org.komea.product.backend.api.IHistoryService#getFilteredHistory(org.komea.product.backend.service.history.HistoryKey,
     *      org.komea.product.database.model.MeasureCriteria, org.komea.product.database.model.MeasureCriteria.Criteria)
     */
    @Override
    public List<Measure> getFilteredHistory(final HistoryKey _historyKey, final MeasureCriteria _measureCriteria, final Criteria criteria) {
    
        initMeasureCriteria(_historyKey, criteria);
        
        return requiredDAO.selectByCriteria(_measureCriteria);
    }
    
    /**
     * (non-Javadoc)
     *
     * @see org.komea.product.backend.api.IHistoryService#getHistory(org.komea.product.backend.service.history.HistoryKey)
     */
    @Override
    public List<Measure> getHistory(final HistoryKey _kpiKey) {
    
        final MeasureCriteria measureCriteria = new MeasureCriteria();
        return getFilteredHistory(_kpiKey, measureCriteria);
    }
    
    /**
     * This method convert an HistoryStringKey to an HistoryKey
     * 
     * @param _historyStringKey
     * @return return the historyKey
     */
    private HistoryKey convertToHistoryKey(final HistoryStringKey _historyStringKey) {
    
        EntityStringKey entityKey = EntityStringKey.of(_historyStringKey.getEntityType().getEntityType(), _historyStringKey.getEntityKey());
        IEntity entity = entityService.findEntityByEntityStringKey(entityKey);
        if (entity == null) {
            return null;
        }
        KpiKey kpiKey = KpiKey.ofKpiNameAndEntity(_historyStringKey.getKpiKey(), entity);
        Kpi kpi = kpiService.findKPI(kpiKey);
        if (kpi == null) {
            return null;
        }
        
        HistoryKey historyKey = HistoryKey.of(kpi, entity);
        return historyKey;
    }
    
    /**
     * This method convert a HistoryStingKey to KpiKey
     * 
     * @param _historyKey
     * @return the KpiKey
     */
    private KpiKey convertTKpiKey(final HistoryStringKey _historyKey) {
    
        EntityStringKey entityKey = EntityStringKey.of(_historyKey.getEntityType().getEntityType(), _historyKey.getEntityKey());
        IEntity entity = entityService.findEntityByEntityStringKey(entityKey);
        if (entity == null) {
            return null;
        }
        return KpiKey.ofKpiNameAndEntity(_historyKey.getKpiKey(), entity);
        
    }
    
    public KpiDao getKpiDao() {
    
        return kpiDao;
    }
    
    private List<Measure> getListOfMeasures(final RowBounds rowBounds, final MeasureCriteria measureCriteria) {
    
        final List<Measure> list = requiredDAO.selectByCriteriaWithRowbounds(measureCriteria, rowBounds);
        LOGGER.trace("Get list of measures {} {} returns {}", rowBounds, measureCriteria, list);
        return list;
    }
    
    @Override
    public MeasureResult getHistoricalMeasure(final HistoryStringKey _historyKey, final LimitCriteria _limit) {
    
        Validate.notNull(_historyKey, "history string key can't be null");
        Validate.notNull(_historyKey.getKpiKey(), "kpi key can't be null");
        Validate.notNull(_historyKey.getEntityKey(), "entity key can't be null");
        Validate.notNull(_historyKey.getEntityType(), "entity type can't be null");
        Validate.notNull(_limit, "limit criteria can't be null");
        
        MeasureResult measureResult = new MeasureResult();
        
        HistoryKey historyKey = convertToHistoryKey(_historyKey);
        if (historyKey == null) {
            return measureResult;
        }
        
        MeasureCriteria measureCriteria = new MeasureCriteria();
        Criteria criteria = measureCriteria.createCriteria();
        criteria.andDateBetween(_limit.getStartDate(), _limit.getEndDate());
        List<Measure> measures = getFilteredHistory(historyKey, _limit.getLimitNumber(), measureCriteria, criteria);
        
        for (Measure measure : measures) {
            measureResult.addHistoricalValue(new HistoricalValue(measure.getValue(), measure.getDate()));
        }
        measures.add(kpiValueService.getRealTimeMeasure(convertTKpiKey(_historyKey)));
        return measureResult;
    }
    /**
     * Method getMeasureDAO.
     *
     * @return MeasureDao
     */
    public final MeasureDao getMeasureDAO() {
    
        return requiredDAO;
    }
    
    /**
     * Method getMeasures : obtain a list of measures for a subset of KPI and a
     * subset of entities and filters provided by a DTO.
     *
     * @param kpis
     *            List<Kpi>
     * @param entities
     *            List<BaseEntityDto>
     * @param searchMeasuresDto
     *            SearchMeasuresDto
     * @return List<Measure>
     * @see
     *      org.komea.product.backend.service.measure.IMeasureService#getMeasures
     *      (List<Kpi>, List<BaseEntityDto>, SearchMeasuresDto)
     * @deprecated use
     */
    @Deprecated
    @Override
    @SuppressWarnings("unchecked")
    public List<MeasureDto> getHistocialMeasures(final Collection<Kpi> _kpis, final Collection<? extends IEntity> _entities,
            final SearchMeasuresDto _searchMeasuresDto) {
    
        if (_kpis.isEmpty() || _entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        final Integer limit = _searchMeasuresDto.getNbMeasures();
        final RowBounds rowBounds = buildRowBounds(limit);
        final List<MeasureDto> measures = new ArrayList<MeasureDto>(1000);
        for (final IEntity entity : _entities) {
            for (final Kpi kpi : _kpis) {
                final MeasureCriteria measureCriteria = buildMeasureCriteriaFromSearchFilter(_searchMeasuresDto,
                        HistoryKey.of(kpi.getId(), entity.getEntityKey()));
                final List<MeasureDto> listOfMeasures = MeasureDto.convert(getListOfMeasures(rowBounds, measureCriteria), kpi.getKpiKey());
                measures.addAll(listOfMeasures);
            }
        }
        Collections.sort(measures, new MeasureDateComparator());
        return measures;
    }
    
    @Override
    public List<MeasureResult> getHistoricalMeasures(final HistoryStringKeyList _historyKeys, final LimitCriteria _limit) {
    
        Validate.notNull(_historyKeys, "history string key list can't be null");
        
        List<MeasureResult> measuresList = Lists.newArrayList();
        HistoryStringKey historyKey;
        for (String kpiKey : _historyKeys.getKpiKeys()) {
            for (String entityKey : _historyKeys.getEntityKeys()) {
                historyKey = new HistoryStringKey(kpiKey, entityKey, _historyKeys.getEntityType());
                measuresList.add(getHistoricalMeasure(historyKey, _limit));
            }
        }
        return measuresList;
    }
    
    /*
     * (non-Javadoc)
     * @see
     * org.komea.product.backend.genericservice.AbstractService#getRequiredDAO()
     */
    @Override
    public IGenericDAO<Measure, Integer, MeasureCriteria> getRequiredDAO() {
    
        return requiredDAO;
    }
    
    /**
     * Method setEsperEngine.
     *
     * @param _esperEngine
     *            IEventEngineService
     */
    public void setEsperEngine(final IEventEngineService _esperEngine) {
    
        esperEngine = _esperEngine;
    }
    
    public void setKpiDao(final KpiDao kpiDao) {
    
        this.kpiDao = kpiDao;
    }
    
    /**
     * Method setMeasureDAO.
     *
     * @param _measureDAO
     *            MeasureDao
     */
    public void setMeasureDAO(final MeasureDao _measureDAO) {
    
        requiredDAO = _measureDAO;
    }
    
    public void setRequiredDAO(final MeasureDao _requiredDAO) {
    
        requiredDAO = _requiredDAO;
    }
    
    /*
     * (non-Javadoc)
     * @see
     * org.komea.product.backend.api.IMeasureHistoryService#storeMeasure(org
     * .komea.product.service.dto.KpiKey, double,
     * org.komea.product.service.dto.EntityKey, org.joda.time.DateTime)
     */
    @SuppressWarnings("boxing")
    @Override
    public void storeMeasure(final HistoryKey _ofKpi, final Double _value, final DateTime _analysisDate) {
    
        final Measure measure = Measure.initializeMeasure(_ofKpi.getKpiID(), _ofKpi.getEntityKey());
        measure.setValue(_value);
        measure.setDate(_analysisDate.toDate());
        saveOrUpdate(measure);
        
    }
    
    /**
     * Method storeMeasure.
     *
     * @param _measure
     *            Measure
     * @see org.komea.product.backend.api.IHistoryService#storeMeasure(Measure)
     */
    @Override
    public void storeMeasure(final Measure _measure) {
    
        LOGGER.debug("Storing new measure : {}", _measure);
        
        requiredDAO.insert(_measure);
        
    }
    
}
