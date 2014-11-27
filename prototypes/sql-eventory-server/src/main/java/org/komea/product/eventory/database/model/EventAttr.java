package org.komea.product.eventory.database.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventAttr implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_evt_storage_attr.id
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_evt_storage_attr.attrName
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 60)
    private String attrName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_evt_storage_attr.attrValue
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String attrValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_evt_storage_attr
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt_storage_attr
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public EventAttr(Integer id, String attrName, String attrValue) {
        this.id = id;
        this.attrName = attrName;
        this.attrValue = attrValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt_storage_attr
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public EventAttr() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_evt_storage_attr.id
     *
     * @return the value of kom_evt_storage_attr.id
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_evt_storage_attr.id
     *
     * @param id the value for kom_evt_storage_attr.id
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_evt_storage_attr.attrName
     *
     * @return the value of kom_evt_storage_attr.attrName
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_evt_storage_attr.attrName
     *
     * @param attrName the value for kom_evt_storage_attr.attrName
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_evt_storage_attr.attrValue
     *
     * @return the value of kom_evt_storage_attr.attrValue
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_evt_storage_attr.attrValue
     *
     * @param attrValue the value for kom_evt_storage_attr.attrValue
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt_storage_attr
     *
     * @mbggenerated Sun Nov 16 11:22:00 CET 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrName=").append(attrName);
        sb.append(", attrValue=").append(attrValue);
        sb.append("]");
        return sb.toString();
    }
}