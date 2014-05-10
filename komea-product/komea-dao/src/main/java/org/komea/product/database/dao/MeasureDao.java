
package org.komea.product.database.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.komea.product.database.dao.timeserie.PeriodTimeSerieOptions;
import org.komea.product.database.dao.timeserie.TimeCoordinate;
import org.komea.product.database.dao.timeserie.TimeSerieOptions;
import org.komea.product.database.model.Measure;
import org.komea.product.database.model.MeasureCriteria;
import org.komea.product.database.model.MeasureKey;
import org.komea.product.service.dto.EntityKey;



public interface MeasureDao
{
    
    
    /**
     * This method builds a time serie from the history given a list of options. Basically the purpose of a time serie is to build charts.
     * A time serie is either global to the type of entities of a kpi or for a given entity (1 or all). TODO:: handle a list of entities .
     * 
     * @return a time serie object
     * @param _timeSerieOptions
     *            the time serie options.
     * @return the coordinates of the time serie
     */
    List<TimeCoordinate> buildGlobalPeriodTimeSeries(PeriodTimeSerieOptions _timeSerieOptions);
    
    
    /**
     * Builsd period time and series
     * 
     * @param _timeSerieOptions
     *            the time serie options.
     * @return the coordinates
     */
    List<TimeCoordinate> buildPeriodTimeSeries(
            PeriodTimeSerieOptions _timeSerieOptions,
            EntityKey _entityKey);
    
    
    /**
     * Builds period time and series
     * 
     * @param _timeSerieOptions
     *            the time serie options.
     * @return the coordinates
     */
    List<TimeCoordinate> buildTimeSeries(TimeSerieOptions _timeSerieOptions, EntityKey _entityKey);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int countByCriteria(MeasureCriteria example);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int deleteByCriteria(MeasureCriteria example);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int deleteByPrimaryKey(MeasureKey key);
    
    
    /**
     * @param _options
     * @param _entityKey
     * @return
     */
    Double getKpiValue(TimeSerieOptions _options, EntityKey _entityKey);
    
    
    /**
     * @param _options
     * @param _entityKey
     * @return
     */
    Double getKpiValueOnPeriod(PeriodTimeSerieOptions _options, EntityKey _entityKey);
    
    
    /**
     * Returns the kp ivalues according the time serie options.
     * 
     * @param _options
     * @return
     */
    Map<EntityKey, Number> getKpiValues(TimeSerieOptions _options);
    
    
    /**
     * @param _options
     * @return
     */
    Map<EntityKey, Number> getKpiValuesOnPeriod(PeriodTimeSerieOptions _options);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int insert(Measure record);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int insertSelective(Measure record);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    List<Measure> selectByCriteria(MeasureCriteria example);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    List<Measure> selectByCriteriaWithRowbounds(MeasureCriteria example, RowBounds rowBounds);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    Measure selectByPrimaryKey(MeasureKey key);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int updateByCriteria(@Param("record")
    Measure record, @Param("example")
    MeasureCriteria example);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int updateByCriteriaSelective(@Param("record")
    Measure record, @Param("example")
    MeasureCriteria example);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int updateByPrimaryKey(Measure record);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     * 
     * @mbggenerated Thu May 08 17:54:52 CEST 2014
     */
    int updateByPrimaryKeySelective(Measure record);
}
