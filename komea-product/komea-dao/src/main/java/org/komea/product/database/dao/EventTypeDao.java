package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.komea.product.database.model.EventType;
import org.komea.product.database.model.EventTypeCriteria;

public interface EventTypeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int countByCriteria(EventTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int deleteByCriteria(EventTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int insert(EventType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int insertSelective(EventType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    List<EventType> selectByCriteriaWithRowbounds(EventTypeCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    List<EventType> selectByCriteria(EventTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    EventType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") EventType record, @Param("example") EventTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int updateByCriteria(@Param("record") EventType record, @Param("example") EventTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int updateByPrimaryKeySelective(EventType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_evt
     *
     * @mbggenerated Fri Feb 14 12:56:55 CET 2014
     */
    int updateByPrimaryKey(EventType record);
}