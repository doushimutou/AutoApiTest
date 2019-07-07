package com.auth.model.dto;

/**
 * Description
 * Author ayt  on
 */

public class StartTestDTO {

    /**
     * 项目ID
     */
    Integer project_id ;
    /**
     * case ID
     */
    Integer case_id;
    /**
     * HOST id
     */
    Integer host_id;
    /**
     * caseApi  id
     */
    Integer id;

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public Integer getHost_id() {
        return host_id;
    }

    public void setHost_id(Integer host_id) {
        this.host_id = host_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
