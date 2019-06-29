package com.auth.service;

import com.auth.entity.ApiOperationhistory;
import com.auth.entity.ApiReqHistory;

import java.util.List;

/**
 * api请求历史记录
 * api 操作记录也放这个service
 * Created by ayt on ${DTAE}
 * just try
 */

public interface ApiReqHistoryService {
    /**
     * 添加请求历史记录
     *
     * @param apiReqHistory
     * @return
     */
    Integer addApiReqHistory(ApiReqHistory apiReqHistory);

    /**
     * 获取请求历史列表
     *
     * @param api_id
     * @return
     */
    List<ApiReqHistory> getHistoryList(Integer api_id);

    /**
     *获取操作记录历史
     * @param page
     * @param api_id
     * @return
     */
    List<ApiOperationhistory> getApiopeHistory( Integer page, Integer api_id);
}
