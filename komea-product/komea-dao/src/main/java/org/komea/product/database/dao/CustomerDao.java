package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.komea.product.database.model.Customer;
import org.komea.product.database.model.CustomerCriteria;

public interface CustomerDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int countByCriteria(CustomerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int deleteByCriteria(CustomerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    List<Customer> selectByCriteriaWithRowbounds(CustomerCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    List<Customer> selectByCriteria(CustomerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") Customer record, @Param("example") CustomerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int updateByCriteria(@Param("record") Customer record, @Param("example") CustomerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_customer
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int updateByPrimaryKey(Customer record);
}