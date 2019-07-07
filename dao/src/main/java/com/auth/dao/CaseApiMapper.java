package com.auth.dao;

import com.auth.entity.CaseApi;
import com.auth.entity.CaseApiExample;
import java.util.List;

public interface CaseApiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    int insert(CaseApi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    int insertSelective(CaseApi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    List<CaseApi> selectByExample(CaseApiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    CaseApi selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CaseApi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_caseApi
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CaseApi record);
}