package com.auth.model.dto;

import com.auth.entity.TestApi;

import java.util.List;

/**
 * Description
 * Author ayt  on
 */
public class ApiDTO extends TestApi {
    /**
     * 请求头list
     * requestHead
     */
    List<Object> headDict;
    /**
     *请求参数list
     * requestparameter
     */
    List<Object> requestList;
    /**
     * 返回参数list
     * response
     */
    List<Object> responseList;



    public List<Object> getHeadDict() {
        return headDict;
    }

    public void setHeadDict(List<Object> headDict) {
        this.headDict = headDict;
    }

    public List<Object> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Object> requestList) {
        this.requestList = requestList;
    }

    public List<Object> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Object> responseList) {
        this.responseList = responseList;
    }
}
