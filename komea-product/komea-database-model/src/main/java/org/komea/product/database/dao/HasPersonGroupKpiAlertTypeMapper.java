package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.HasPersonGroupKpiAlertTypeExample;
import org.komea.product.database.model.HasPersonGroupKpiAlertTypeKey;

public interface HasPersonGroupKpiAlertTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int countByExample(HasPersonGroupKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByExample(HasPersonGroupKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByPrimaryKey(HasPersonGroupKpiAlertTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insert(HasPersonGroupKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insertSelective(HasPersonGroupKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<HasPersonGroupKpiAlertTypeKey> selectByExample(HasPersonGroupKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleSelective(@Param("record") HasPersonGroupKpiAlertTypeKey record, @Param("example") HasPersonGroupKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pegr
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExample(@Param("record") HasPersonGroupKpiAlertTypeKey record, @Param("example") HasPersonGroupKpiAlertTypeExample example);
}