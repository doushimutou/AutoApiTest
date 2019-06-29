package com.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TestCase {
    /**
     * id
     */
    private Integer id;

    /**
     * 用例名称 caseName
     */
    private String casename;

    /**
     * 描述 description
     */
    private String description;

    /**
     * 更新时间 updateTime
     */
    private Date updatetime;

    /**
     * 用例组别ID autoGroupFirst_id
     */
    private Integer autogroupfirstId;

    /**
     * 项目ID project_id
     */
    private Integer projectId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_autocase.id
     *
     * @return the value of test_autocase.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_autocase.id
     *
     * @param id the value for test_autocase.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_autocase.caseName
     *
     * @return the value of test_autocase.caseName
     * @mbg.generated
     */
    public String getCasename() {
        return casename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_autocase.caseName
     *
     * @param casename the value for test_autocase.caseName
     * @mbg.generated
     */
    public void setCasename(String casename) {
        this.casename = casename == null ? null : casename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_autocase.description
     *
     * @return the value of test_autocase.description
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_autocase.description
     *
     * @param description the value for test_autocase.description
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_autocase.updateTime
     *
     * @return the value of test_autocase.updateTime
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_autocase.updateTime
     *
     * @param updatetime the value for test_autocase.updateTime
     * @mbg.generated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_autocase.autoGroupFirst_id
     *
     * @return the value of test_autocase.autoGroupFirst_id
     * @mbg.generated
     */
    public Integer getAutogroupfirstId() {
        return autogroupfirstId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_autocase.autoGroupFirst_id
     *
     * @param autogroupfirstId the value for test_autocase.autoGroupFirst_id
     * @mbg.generated
     */
    public void setAutogroupfirstId(Integer autogroupfirstId) {
        this.autogroupfirstId = autogroupfirstId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_autocase.project_id
     *
     * @return the value of test_autocase.project_id
     * @mbg.generated
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_autocase.project_id
     *
     * @param projectId the value for test_autocase.project_id
     * @mbg.generated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}