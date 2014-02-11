package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.komea.product.database.model.HasProjectPersonCriteria;
import org.komea.product.database.model.HasProjectPersonKey;

public interface HasProjectPersonDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int countByCriteria(HasProjectPersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int deleteByCriteria(HasProjectPersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int deleteByPrimaryKey(HasProjectPersonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int insert(HasProjectPersonKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int insertSelective(HasProjectPersonKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    List<HasProjectPersonKey> selectByCriteriaWithRowbounds(HasProjectPersonCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    List<HasProjectPersonKey> selectByCriteria(HasProjectPersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int updateByCriteriaSelective(@Param("record") HasProjectPersonKey record, @Param("example") HasProjectPersonCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_pe
     *
     * @mbggenerated Tue Feb 11 10:22:30 CET 2014
     */
    int updateByCriteria(@Param("record") HasProjectPersonKey record, @Param("example") HasProjectPersonCriteria example);
}