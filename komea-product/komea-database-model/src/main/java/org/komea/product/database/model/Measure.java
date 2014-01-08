package org.komea.product.database.model;

import java.util.Date;

public class Measure {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.idMeasure
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idMeasure;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.idMetric
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idMetric;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.date
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.idPersonGroup
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idPersonGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.idPerson
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.idProject
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idProject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_msr.value
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Double value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.idMeasure
     *
     * @return the value of kom_msr.idMeasure
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdMeasure() {
        return idMeasure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.idMeasure
     *
     * @param idMeasure the value for kom_msr.idMeasure
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdMeasure(Integer idMeasure) {
        this.idMeasure = idMeasure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.idMetric
     *
     * @return the value of kom_msr.idMetric
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdMetric() {
        return idMetric;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.idMetric
     *
     * @param idMetric the value for kom_msr.idMetric
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdMetric(Integer idMetric) {
        this.idMetric = idMetric;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.date
     *
     * @return the value of kom_msr.date
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.date
     *
     * @param date the value for kom_msr.date
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.idPersonGroup
     *
     * @return the value of kom_msr.idPersonGroup
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdPersonGroup() {
        return idPersonGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.idPersonGroup
     *
     * @param idPersonGroup the value for kom_msr.idPersonGroup
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdPersonGroup(Integer idPersonGroup) {
        this.idPersonGroup = idPersonGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.idPerson
     *
     * @return the value of kom_msr.idPerson
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdPerson() {
        return idPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.idPerson
     *
     * @param idPerson the value for kom_msr.idPerson
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.idProject
     *
     * @return the value of kom_msr.idProject
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdProject() {
        return idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.idProject
     *
     * @param idProject the value for kom_msr.idProject
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_msr.value
     *
     * @return the value of kom_msr.value
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Double getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_msr.value
     *
     * @param value the value for kom_msr.value
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setValue(Double value) {
        this.value = value;
    }
}