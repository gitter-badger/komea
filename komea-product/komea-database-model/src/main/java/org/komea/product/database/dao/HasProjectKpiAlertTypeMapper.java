package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.HasProjectKpiAlertTypeExample;
import org.komea.product.database.model.HasProjectKpiAlertTypeKey;

public interface HasProjectKpiAlertTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int countByExample(HasProjectKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByExample(HasProjectKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int deleteByPrimaryKey(HasProjectKpiAlertTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insert(HasProjectKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int insertSelective(HasProjectKpiAlertTypeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    List<HasProjectKpiAlertTypeKey> selectByExample(HasProjectKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExampleSelective(@Param("record") HasProjectKpiAlertTypeKey record, @Param("example") HasProjectKpiAlertTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_kpia
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    int updateByExample(@Param("record") HasProjectKpiAlertTypeKey record, @Param("example") HasProjectKpiAlertTypeExample example);
}