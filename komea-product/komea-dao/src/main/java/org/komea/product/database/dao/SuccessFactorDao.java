package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.komea.product.database.model.SuccessFactor;
import org.komea.product.database.model.SuccessFactorCriteria;

public interface SuccessFactorDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int countByCriteria(SuccessFactorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int deleteByCriteria(SuccessFactorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int insert(SuccessFactor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int insertSelective(SuccessFactor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    List<SuccessFactor> selectByCriteriaWithRowbounds(SuccessFactorCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    List<SuccessFactor> selectByCriteria(SuccessFactorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    SuccessFactor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") SuccessFactor record, @Param("example") SuccessFactorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int updateByCriteria(@Param("record") SuccessFactor record, @Param("example") SuccessFactorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int updateByPrimaryKeySelective(SuccessFactor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_sfac
     *
     * @mbggenerated Thu Mar 06 10:32:30 CET 2014
     */
    int updateByPrimaryKey(SuccessFactor record);
}