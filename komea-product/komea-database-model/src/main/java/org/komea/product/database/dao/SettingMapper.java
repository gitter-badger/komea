package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Setting;
import org.komea.product.database.model.SettingCriteria;

public interface SettingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int countByExample(SettingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int deleteByExample(SettingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int insert(Setting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int insertSelective(Setting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    List<Setting> selectByExample(SettingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    Setting selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByExampleSelective(@Param("record") Setting record, @Param("example") SettingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByExample(@Param("record") Setting record, @Param("example") SettingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByPrimaryKeySelective(Setting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByPrimaryKey(Setting record);
}