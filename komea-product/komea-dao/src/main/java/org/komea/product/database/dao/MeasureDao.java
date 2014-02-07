package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Measure;
import org.komea.product.database.model.MeasureCriteria;

public interface MeasureDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int countByCriteria(MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int deleteByCriteria(MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int insert(Measure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int insertSelective(Measure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    List<Measure> selectByCriteria(MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    Measure selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") Measure record, @Param("example") MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int updateByCriteria(@Param("record") Measure record, @Param("example") MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int updateByPrimaryKeySelective(Measure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int updateByPrimaryKey(Measure record);
}