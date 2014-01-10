package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Link;
import org.komea.product.database.model.LinkCriteria;

public interface LinkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int countByExample(LinkCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int deleteByExample(LinkCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int insert(Link record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int insertSelective(Link record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    List<Link> selectByExample(LinkCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    Link selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int updateByExampleSelective(@Param("record") Link record, @Param("example") LinkCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int updateByExample(@Param("record") Link record, @Param("example") LinkCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int updateByPrimaryKeySelective(Link record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_link
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int updateByPrimaryKey(Link record);
}