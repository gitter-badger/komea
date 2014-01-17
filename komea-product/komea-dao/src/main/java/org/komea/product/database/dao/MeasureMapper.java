package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Measure;
import org.komea.product.database.model.MeasureCriteria;

public interface MeasureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int countByExample(MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int deleteByExample(MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int insert(Measure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int insertSelective(Measure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    List<Measure> selectByExample(MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    Measure selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int updateByExampleSelective(@Param("record") Measure record, @Param("example") MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int updateByExample(@Param("record") Measure record, @Param("example") MeasureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int updateByPrimaryKeySelective(Measure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    int updateByPrimaryKey(Measure record);
}