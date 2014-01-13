package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Tag;
import org.komea.product.database.model.TagCriteria;

public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int countByExample(TagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int deleteByExample(TagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    List<Tag> selectByExample(TagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    Tag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Mon Jan 13 10:31:46 CET 2014
     */
    int updateByPrimaryKey(Tag record);
}