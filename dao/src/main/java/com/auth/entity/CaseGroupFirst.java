package com.auth.entity;

public class CaseGroupFirst {
    /**
     *  id
     */
    private Integer id;

    /**
     * 名称 name
     */
    private String name;

    /**
     * 项目ID project_id
     */
    private Integer projectId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_caseGroupFirst.id
     *
     * @return the value of test_caseGroupFirst.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_caseGroupFirst.id
     *
     * @param id the value for test_caseGroupFirst.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_caseGroupFirst.name
     *
     * @return the value of test_caseGroupFirst.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_caseGroupFirst.name
     *
     * @param name the value for test_caseGroupFirst.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_caseGroupFirst.project_id
     *
     * @return the value of test_caseGroupFirst.project_id
     *
     * @mbg.generated
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_caseGroupFirst.project_id
     *
     * @param projectId the value for test_caseGroupFirst.project_id
     *
     * @mbg.generated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}