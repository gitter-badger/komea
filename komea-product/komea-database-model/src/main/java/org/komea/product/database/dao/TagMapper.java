package org.komea.product.database.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.komea.product.database.model.Tag;
import org.komea.product.database.model.TagExample;

public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int countByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int deleteByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int deleteByPrimaryKey(Integer idTag);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    Tag selectByPrimaryKey(Integer idTag);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_tag
     *
     * @mbggenerated Wed Jan 08 18:58:18 CET 2014
     */
    int updateByPrimaryKey(Tag record);
}