package com.ljj.ssm.mapper;

import com.ljj.ssm.po.Orderdetail;

public interface OrderdetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int insert(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int insertSelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    Orderdetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int updateByPrimaryKeySelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated Thu Aug 02 17:56:47 CST 2018
     */
    int updateByPrimaryKey(Orderdetail record);
}