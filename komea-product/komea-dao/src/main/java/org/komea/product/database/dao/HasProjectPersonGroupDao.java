package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.komea.product.database.model.HasProjectPersonGroupCriteria;
import org.komea.product.database.model.HasProjectPersonGroupKey;

public interface HasProjectPersonGroupDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int countByCriteria(HasProjectPersonGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int deleteByCriteria(HasProjectPersonGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int deleteByPrimaryKey(HasProjectPersonGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int insert(HasProjectPersonGroupKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int insertSelective(HasProjectPersonGroupKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    List<HasProjectPersonGroupKey> selectByCriteriaWithRowbounds(HasProjectPersonGroupCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    List<HasProjectPersonGroupKey> selectByCriteria(HasProjectPersonGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") HasProjectPersonGroupKey record, @Param("example") HasProjectPersonGroupCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pegr
     *
     * @mbggenerated Tue Feb 11 15:56:49 CET 2014
     */
    int updateByCriteria(@Param("record") HasProjectPersonGroupKey record, @Param("example") HasProjectPersonGroupCriteria example);
}