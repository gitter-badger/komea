package org.komea.product.database.model;

import java.io.Serializable;

public class Customer implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_customer.id
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_customer.name
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_customer
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public Customer() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_customer.id
     *
     * @return the value of kom_customer.id
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_customer.id
     *
     * @param id the value for kom_customer.id
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_customer.name
     *
     * @return the value of kom_customer.name
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_customer.name
     *
     * @param name the value for kom_customer.name
     *
     * @mbggenerated Thu Jan 16 12:45:33 CET 2014
     */
    public void setName(String name) {
        this.name = name;
    }
}