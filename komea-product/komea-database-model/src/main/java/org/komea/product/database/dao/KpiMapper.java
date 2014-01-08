package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.KpiExample;
import org.komea.product.database.model.KpiWithBLOBs;

public interface KpiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int countByExample(KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByExample(KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByPrimaryKey(Integer idKpi);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insert(KpiWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insertSelective(KpiWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<KpiWithBLOBs> selectByExampleWithBLOBs(KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<Kpi> selectByExample(KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    KpiWithBLOBs selectByPrimaryKey(Integer idKpi);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleSelective(@Param("record") KpiWithBLOBs record, @Param("example") KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleWithBLOBs(@Param("record") KpiWithBLOBs record, @Param("example") KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExample(@Param("record") Kpi record, @Param("example") KpiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByPrimaryKeySelective(KpiWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByPrimaryKeyWithBLOBs(KpiWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByPrimaryKey(Kpi record);
}