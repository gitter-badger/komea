package org.komea.product.database.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.komea.product.database.api.IEntity;
import org.komea.product.database.enums.EntityType;

public class Person implements IEntity, Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.id
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.idPersonGroup
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    private Integer idPersonGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.firstName
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String firstName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.lastName
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String lastName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.email
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.login
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String login;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.idPersonRole
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    private Integer idPersonRole;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_pe.password
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_pe
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public Person(Integer id, Integer idPersonGroup, String firstName, String lastName, String email, String login, Integer idPersonRole, String password) {
        this.id = id;
        this.idPersonGroup = idPersonGroup;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.idPersonRole = idPersonRole;
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public Person() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.id
     *
     * @return the value of kom_pe.id
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.id
     *
     * @param id the value for kom_pe.id
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.idPersonGroup
     *
     * @return the value of kom_pe.idPersonGroup
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public Integer getIdPersonGroup() {
        return idPersonGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.idPersonGroup
     *
     * @param idPersonGroup the value for kom_pe.idPersonGroup
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setIdPersonGroup(Integer idPersonGroup) {
        this.idPersonGroup = idPersonGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.firstName
     *
     * @return the value of kom_pe.firstName
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.firstName
     *
     * @param firstName the value for kom_pe.firstName
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.lastName
     *
     * @return the value of kom_pe.lastName
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.lastName
     *
     * @param lastName the value for kom_pe.lastName
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.email
     *
     * @return the value of kom_pe.email
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.email
     *
     * @param email the value for kom_pe.email
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.login
     *
     * @return the value of kom_pe.login
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getLogin() {
        return login;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.login
     *
     * @param login the value for kom_pe.login
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.idPersonRole
     *
     * @return the value of kom_pe.idPersonRole
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public Integer getIdPersonRole() {
        return idPersonRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.idPersonRole
     *
     * @param idPersonRole the value for kom_pe.idPersonRole
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setIdPersonRole(Integer idPersonRole) {
        this.idPersonRole = idPersonRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_pe.password
     *
     * @return the value of kom_pe.password
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_pe.password
     *
     * @param password the value for kom_pe.password
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
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
        sb.append(", idPersonGroup=").append(idPersonGroup);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", login=").append(login);
        sb.append(", idPersonRole=").append(idPersonRole);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public EntityType entityType() {
        return EntityType.PERSON;
    }
}