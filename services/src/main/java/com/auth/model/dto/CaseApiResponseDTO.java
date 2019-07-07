package com.auth.model.dto;

import java.util.List;

/**
 * Description 用于关联时的接口返回
 * Author ayt  on
 */
public class CaseApiResponseDTO {
    Integer id;
    String name;
    Object response;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
