package org.komea.product.database.model;

public class Project {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_proj.idProject
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idProject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_proj.key
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private String key;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_proj.name
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_proj.idCustomer
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private Integer idCustomer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_proj.description
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_proj.idProject
     *
     * @return the value of kom_proj.idProject
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdProject() {
        return idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_proj.idProject
     *
     * @param idProject the value for kom_proj.idProject
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_proj.key
     *
     * @return the value of kom_proj.key
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public String getKey() {
        return key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_proj.key
     *
     * @param key the value for kom_proj.key
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_proj.name
     *
     * @return the value of kom_proj.name
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_proj.name
     *
     * @param name the value for kom_proj.name
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_proj.idCustomer
     *
     * @return the value of kom_proj.idCustomer
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public Integer getIdCustomer() {
        return idCustomer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_proj.idCustomer
     *
     * @param idCustomer the value for kom_proj.idCustomer
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_proj.description
     *
     * @return the value of kom_proj.description
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_proj.description
     *
     * @param description the value for kom_proj.description
     *
     * @mbggenerated Wed Jan 08 17:24:48 CET 2014
     */
    public void setDescription(String description) {
        this.description = description;
    }
}