package com.ljj.ssm.mapper;

import com.ljj.ssm.po.Items;

public interface ItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int insert(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int insertSelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    Items selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int updateByPrimaryKeySelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int updateByPrimaryKey(Items record);
}