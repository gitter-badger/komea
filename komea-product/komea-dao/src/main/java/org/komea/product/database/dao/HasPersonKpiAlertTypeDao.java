package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.HasPersonKpiAlertTypeCriteria;
import org.komea.product.database.model.HasPersonKpiAlertTypeKey;

public interface HasPersonKpiAlertTypeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int countByCriteria(HasPersonKpiAlertTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int deleteByCriteria(HasPersonKpiAlertTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int deleteByPrimaryKey(HasPersonKpiAlertTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int insert(HasPersonKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int insertSelective(HasPersonKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    List<HasPersonKpiAlertTypeKey> selectByCriteria(HasPersonKpiAlertTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") HasPersonKpiAlertTypeKey record, @Param("example") HasPersonKpiAlertTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 15:26:17 CET 2014
     */
    int updateByCriteria(@Param("record") HasPersonKpiAlertTypeKey record, @Param("example") HasPersonKpiAlertTypeCriteria example);
}