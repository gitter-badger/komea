package org.komea.product.database.model;

import java.io.Serializable;

public class HasProjectPersonGroupKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_has_proj_pegr.idProject
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    private Integer idProject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_has_proj_pegr.idPersonGroup
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    private Integer idPersonGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public HasProjectPersonGroupKey(Integer idProject, Integer idPersonGroup) {
        this.idProject = idProject;
        this.idPersonGroup = idPersonGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public HasProjectPersonGroupKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_has_proj_pegr.idProject
     *
     * @return the value of kom_has_proj_pegr.idProject
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public Integer getIdProject() {
        return idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_has_proj_pegr.idProject
     *
     * @param idProject the value for kom_has_proj_pegr.idProject
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_has_proj_pegr.idPersonGroup
     *
     * @return the value of kom_has_proj_pegr.idPersonGroup
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public Integer getIdPersonGroup() {
        return idPersonGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_has_proj_pegr.idPersonGroup
     *
     * @param idPersonGroup the value for kom_has_proj_pegr.idPersonGroup
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void setIdPersonGroup(Integer idPersonGroup) {
        this.idPersonGroup = idPersonGroup;
    }
}