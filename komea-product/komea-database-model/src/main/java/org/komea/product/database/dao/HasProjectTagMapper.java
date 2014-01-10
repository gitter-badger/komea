package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.HasProjectTagCriteria;
import org.komea.product.database.model.HasProjectTagKey;

public interface HasProjectTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int countByExample(HasProjectTagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int deleteByExample(HasProjectTagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int deleteByPrimaryKey(HasProjectTagKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int insert(HasProjectTagKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int insertSelective(HasProjectTagKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    List<HasProjectTagKey> selectByExample(HasProjectTagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int updateByExampleSelective(@Param("record") HasProjectTagKey record, @Param("example") HasProjectTagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_has_proj_tag
     *
     * @mbggenerated Fri Jan 10 15:10:49 CET 2014
     */
    int updateByExample(@Param("record") HasProjectTagKey record, @Param("example") HasProjectTagCriteria example);
}