package com.auth.model.dto;

import com.auth.entity.CaseApi;

import java.util.List;

/**
 * Description
 * Author ayt  on
 */
public class CaseApiDTO extends CaseApi {
    /**
     * 请求头
     */
    List<Object>  headDict;
    /**
     * 请求参数列表
     */
    List<Object> requestList;
    /**
     * 请求是否用formatRaw；
     */
    Boolean formatRaw;
    /**
     * 正则匹配参数
     */
    String RegularParam;

    /**
     * 批量添加已存在的接口
     */
    List<Integer> ids;
    /**
     * 用例实际请求的url
     */
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

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

    public Boolean getFormatRaw() {
        return formatRaw;
    }

    public void setFormatRaw(Boolean formatRaw) {
        this.formatRaw = formatRaw;
    }

    public String getRegularParam() {
        return RegularParam;
    }

    public void setRegularParam(String regularParam) {
        RegularParam = regularParam;
    }
}
