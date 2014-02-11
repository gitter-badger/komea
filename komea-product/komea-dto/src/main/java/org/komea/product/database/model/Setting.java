package org.komea.product.database.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Setting implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.id
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.settingKey
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String settingKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.value
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.type
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_setting.description
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @Size(min = 0, max = 2048)
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_setting
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public Setting(Integer id, String settingKey, String value, String type, String description) {
        this.id = id;
        this.settingKey = settingKey;
        this.value = value;
        this.type = type;
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
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
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
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
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
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
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
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
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
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
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
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
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_setting.type
     *
     * @return the value of kom_setting.type
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_setting.type
     *
     * @param type the value for kom_setting.type
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_setting.description
     *
     * @return the value of kom_setting.description
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_setting.description
     *
     * @param description the value for kom_setting.description
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_setting
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", settingKey=").append(settingKey);
        sb.append(", value=").append(value);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}