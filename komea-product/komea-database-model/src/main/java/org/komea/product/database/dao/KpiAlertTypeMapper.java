package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.KpiAlertType;
import org.komea.product.database.model.KpiAlertTypeExample;

public interface KpiAlertTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int countByExample(KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByExample(KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByPrimaryKey(Integer idKpiAlertType);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insert(KpiAlertType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insertSelective(KpiAlertType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<KpiAlertType> selectByExampleWithBLOBs(KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<KpiAlertType> selectByExample(KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    KpiAlertType selectByPrimaryKey(Integer idKpiAlertType);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleSelective(@Param("record") KpiAlertType record, @Param("example") KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleWithBLOBs(@Param("record") KpiAlertType record, @Param("example") KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExample(@Param("record") KpiAlertType record, @Param("example") KpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByPrimaryKeySelective(KpiAlertType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByPrimaryKeyWithBLOBs(KpiAlertType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByPrimaryKey(KpiAlertType record);
}