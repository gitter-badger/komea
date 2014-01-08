package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.HasPersonKpiAlertTypeExample;
import org.komea.product.database.model.HasPersonKpiAlertTypeKey;

public interface HasPersonKpiAlertTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int countByExample(HasPersonKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByExample(HasPersonKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByPrimaryKey(HasPersonKpiAlertTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insert(HasPersonKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insertSelective(HasPersonKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<HasPersonKpiAlertTypeKey> selectByExample(HasPersonKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleSelective(@Param("record") HasPersonKpiAlertTypeKey record, @Param("example") HasPersonKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExample(@Param("record") HasPersonKpiAlertTypeKey record, @Param("example") HasPersonKpiAlertTypeExample example);
}