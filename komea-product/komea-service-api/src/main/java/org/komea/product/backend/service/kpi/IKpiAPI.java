/**
 * 
 */

package org.komea.product.backend.service.kpi;



import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.komea.product.database.dto.BaseEntityDto;
import org.komea.product.database.dto.KpiMeasureFilter;
import org.komea.product.database.dto.KpiResult;
import org.komea.product.database.dto.MeasureDto;
import org.komea.product.database.dto.SearchMeasuresDto;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.Measure;



/**
 * This interface defines the KPI api provided by Komea. It is recommended to perform a precise analysis of the functionalities of this
 * interface before to add other methods. Single purpose methods are FORBIDDEN!
 * 
 * @author sleroy
 */
public interface IKpiAPI
{
    
    
    /**
     * Compute the average of kpi measures
     * 
     * @param _kpiMeasures
     *            the kpi measures
     * @return a value representing the average.
     */
    double computeAverageFromMeasures(List<Measure> _kpiMeasures);
    
    
    /**
     * Computes the sum from a list of measures
     * 
     * @param _kpiMeasures
     *            the kpi measures
     * @return a value representing the sum
     */
    double computeSumFromMeasures(List<Measure> _kpiMeasures);
    
    
    /**
     * Returns the list of kpis associated to an entity type.
     * 
     * @param _entityType
     *            the type of entity requested
     * @return the list of kpi.
     */
    List<Kpi> getAllKpisOfEntityType(EntityType _entityType);
    
    
    /**
     * @param _groupKpiKeys
     * @return
     * @deprecated TO BE REFACTORED
     */
    @Deprecated
    List<Kpi> getBaseKpisOfGroupKpiKeys(List<String> _groupKpiKeys);
    
    
    /**
     * Returns the given kpi as a list of measures dto
     * 
     * @param _kpi
     *            the kpi name.
     * @param _kpiMeasureFilter
     *            the filter to obtain the measures
     * @return the list of measures dto
     */
    Collection<? extends MeasureDto> getKpiAsMeasures(
            String _kpi,
            KpiMeasureFilter _kpiMeasureFilter);
    
    
    /**
     * Returns the list of kpis for groups.
     * 
     * @param _kpis
     *            the list of kpis
     * @deprecated TO BE REFACTORED
     */
    @Deprecated
    List<Kpi> getKpisForGroups(List<Kpi> _kpis);
    
    
    /**
     * @param _groupKpiKeys
     * @param _baseKpis
     * @return
     * @deprecated TO BE REFACTORED
     */
    @Deprecated
    Collection<? extends Kpi> getKpisOfGroupKpiKeys(List<String> _groupKpiKeys, List<Kpi> _baseKpis);
    
    
    /**
     * Returns the kpi values computed at the immediate instant. The results are returned as an object called KpiRESULT. Basically it is a
     * map referencing an entity key to its value.
     * 
     * @param _kpiKey
     *            the kpi key.
     * @return the kpi result
     */
    KpiResult getKpiValues(String _kpiName);
    
    
    /**
     * Returns the kpi values averaged since the begin period given in parameter. The results are returned as an object called KpiRESULT.
     * Basically it is a
     * map referencing an entity key to its value.
     * 
     * @param _kpiName
     *            the kpi name
     * @param _previousTime
     *            the previous time.
     * @return the kpi result
     */
    KpiResult getKpiValuesAverageOnPeriod(String _kpiName, DateTime _previousTime);
    
    
    /**
     * @param _baseKpis
     * @param _allSubEntitiesDto
     * @param _searchMeasuresDto
     * @deprecated TO BE REFACTORED
     */
    @Deprecated
    List<MeasureDto> getMeasures(
            List<Kpi> _baseKpis,
            List<BaseEntityDto> _allSubEntitiesDto,
            SearchMeasuresDto _searchMeasuresDto);
    
    
    /**
     * @param _baseKpis
     * @param _subEntitiesDto
     * @return
     * @deprecated TO BE REFACTORED
     */
    @Deprecated
    List<MeasureDto> getRealTimeMeasuresFromEntities(
            List<Kpi> _baseKpis,
            List<BaseEntityDto> _subEntitiesDto);
    
    
    /**
     * Returns a selection of kpis filtered by their entity type and a list of kpi keys.
     * 
     * @param _kpiType
     *            the kpi type
     * @param _kpiKeys
     *            the kpi keys
     * @return the list of kpi
     */
    Collection<? extends Kpi> getSelectionOfKpis(EntityType _kpiType, List<String> _kpiKeys);
    
    
    /**
     * Returns the list of KPI
     * 
     * @return the list of KPI.
     */
    List<Kpi> selectAll();
    
    
}