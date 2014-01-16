package org.komea.product.database.model;

import java.io.Serializable;

public class HasProjectPersonKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_has_proj_pe.idProject
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    private Integer idProject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_has_proj_pe.idPerson
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    private Integer idPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public HasProjectPersonKey(Integer idProject, Integer idPerson) {
        this.idProject = idProject;
        this.idPerson = idPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public HasProjectPersonKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_has_proj_pe.idProject
     *
     * @return the value of kom_has_proj_pe.idProject
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public Integer getIdProject() {
        return idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_has_proj_pe.idProject
     *
     * @param idProject the value for kom_has_proj_pe.idProject
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_has_proj_pe.idPerson
     *
     * @return the value of kom_has_proj_pe.idPerson
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public Integer getIdPerson() {
        return idPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_has_proj_pe.idPerson
     *
     * @param idPerson the value for kom_has_proj_pe.idPerson
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
}