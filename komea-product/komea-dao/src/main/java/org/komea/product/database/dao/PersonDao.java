package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Person;
import org.komea.product.database.model.PersonCriteria;

public interface PersonDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int countByCriteria(PersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int deleteByCriteria(PersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int insert(Person record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int insertSelective(Person record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    List<Person> selectByCriteria(PersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    Person selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") Person record, @Param("example") PersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int updateByCriteria(@Param("record") Person record, @Param("example") PersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int updateByPrimaryKeySelective(Person record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pe
     *
     * @mbggenerated Wed Feb 05 10:10:36 CET 2014
     */
    int updateByPrimaryKey(Person record);
}