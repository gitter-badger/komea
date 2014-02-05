package org.komea.product.database.model;

import java.io.Serializable;

public class HasPersonKpiAlertTypeKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_has_kpia_pe.idKpiAlertType
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    private Integer idKpiAlertType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_has_kpia_pe.idPerson
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    private Integer idPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    public HasPersonKpiAlertTypeKey(Integer idKpiAlertType, Integer idPerson) {
        this.idKpiAlertType = idKpiAlertType;
        this.idPerson = idPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_kpia_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    public HasPersonKpiAlertTypeKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_has_kpia_pe.idKpiAlertType
     *
     * @return the value of kom_has_kpia_pe.idKpiAlertType
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    public Integer getIdKpiAlertType() {
        return idKpiAlertType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_has_kpia_pe.idKpiAlertType
     *
     * @param idKpiAlertType the value for kom_has_kpia_pe.idKpiAlertType
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    public void setIdKpiAlertType(Integer idKpiAlertType) {
        this.idKpiAlertType = idKpiAlertType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_has_kpia_pe.idPerson
     *
     * @return the value of kom_has_kpia_pe.idPerson
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    public Integer getIdPerson() {
        return idPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_has_kpia_pe.idPerson
     *
     * @param idPerson the value for kom_has_kpia_pe.idPerson
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
}