package org.komea.product.database.model;

import java.io.Serializable;

public class Setting implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.id
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.settingKey
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    private String settingKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.value
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public Setting(Integer id, String settingKey, String value) {
        this.id = id;
        this.settingKey = settingKey;
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public Setting() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_setting.id
     *
     * @return the value of kom_setting.id
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_setting.id
     *
     * @param id the value for kom_setting.id
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_setting.settingKey
     *
     * @return the value of kom_setting.settingKey
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public String getSettingKey() {
        return settingKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_setting.settingKey
     *
     * @param settingKey the value for kom_setting.settingKey
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_setting.value
     *
     * @return the value of kom_setting.value
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_setting.value
     *
     * @param value the value for kom_setting.value
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    public void setValue(String value) {
        this.value = value;
    }
}