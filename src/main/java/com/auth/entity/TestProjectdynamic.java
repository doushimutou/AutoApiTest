package com.auth.entity;

import java.util.Date;

public class TestProjectdynamic {
    /**
     *  id
     */
    private Integer id;

    /**
     *  time
     */
    private Date time;

    /**
     *  type
     */
    private String type;

    /**
     *  operationObject
     */
    private String operationobject;

    /**
     *  description
     */
    private String description;

    /**
     *  user_id
     */
    private Integer userId;

    /**
     *  project_id
     */
    private Integer projectId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.id
     *
     * @return the value of test_projectdynamic.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.id
     *
     * @param id the value for test_projectdynamic.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.time
     *
     * @return the value of test_projectdynamic.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.time
     *
     * @param time the value for test_projectdynamic.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.type
     *
     * @return the value of test_projectdynamic.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.type
     *
     * @param type the value for test_projectdynamic.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.operationObject
     *
     * @return the value of test_projectdynamic.operationObject
     *
     * @mbg.generated
     */
    public String getOperationobject() {
        return operationobject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.operationObject
     *
     * @param operationobject the value for test_projectdynamic.operationObject
     *
     * @mbg.generated
     */
    public void setOperationobject(String operationobject) {
        this.operationobject = operationobject == null ? null : operationobject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.description
     *
     * @return the value of test_projectdynamic.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.description
     *
     * @param description the value for test_projectdynamic.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.user_id
     *
     * @return the value of test_projectdynamic.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.user_id
     *
     * @param userId the value for test_projectdynamic.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_projectdynamic.project_id
     *
     * @return the value of test_projectdynamic.project_id
     *
     * @mbg.generated
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_projectdynamic.project_id
     *
     * @param projectId the value for test_projectdynamic.project_id
     *
     * @mbg.generated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}