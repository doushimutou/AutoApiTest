package com.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ApiOperationhistory {
    /**
     *  id
     */
    private Integer id;

    /**
     *  user
     */
    private String user;

    /**
     *  time
     */
    private Date time;

    /**
     *  description
     */
    private String description;

    /**
     *  apiInfo_id
     */
    private Integer apiinfoId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_apioperationhistory.id
     *
     * @return the value of test_apioperationhistory.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_apioperationhistory.id
     *
     * @param id the value for test_apioperationhistory.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_apioperationhistory.user
     *
     * @return the value of test_apioperationhistory.user
     *
     * @mbg.generated
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_apioperationhistory.user
     *
     * @param user the value for test_apioperationhistory.user
     *
     * @mbg.generated
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_apioperationhistory.time
     *
     * @return the value of test_apioperationhistory.time
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_apioperationhistory.time
     *
     * @param time the value for test_apioperationhistory.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_apioperationhistory.description
     *
     * @return the value of test_apioperationhistory.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_apioperationhistory.description
     *
     * @param description the value for test_apioperationhistory.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_apioperationhistory.apiInfo_id
     *
     * @return the value of test_apioperationhistory.apiInfo_id
     *
     * @mbg.generated
     */
    public Integer getApiinfoId() {
        return apiinfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_apioperationhistory.apiInfo_id
     *
     * @param apiinfoId the value for test_apioperationhistory.apiInfo_id
     *
     * @mbg.generated
     */
    public void setApiinfoId(Integer apiinfoId) {
        this.apiinfoId = apiinfoId;
    }
}