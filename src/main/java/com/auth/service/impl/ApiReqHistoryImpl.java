package com.auth.service.impl;

import com.auth.dao.ApiOperationhistoryMapper;
import com.auth.dao.ApiReqHistoryMapper;
import com.auth.entity.ApiOperationhistory;
import com.auth.entity.ApiOperationhistoryExample;
import com.auth.entity.ApiReqHistory;
import com.auth.entity.ApiReqHistoryExample;
import com.auth.service.ApiReqHistoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Service
public class ApiReqHistoryImpl implements ApiReqHistoryService {

    @Resource
    ApiReqHistoryMapper historyMapper;
    @Resource
    ApiOperationhistoryMapper operationhistoryMapper;

    /**
     * 添加请求历史记录
     *
     * @param apiReqHistory
     * @return
     */
    @Override
    public Integer addApiReqHistory(ApiReqHistory apiReqHistory) {
        apiReqHistory.setRequesttime(new Date());
        return historyMapper.insert(apiReqHistory);
    }

    /**
     * 获取请求历史列表
     *
     * @param api_id
     * @return
     */
    @Override
    public List<ApiReqHistory> getHistoryList(Integer api_id) {
        ApiReqHistoryExample historyExample = new ApiReqHistoryExample();
        historyExample.createCriteria().andApiinfoIdEqualTo(api_id);
        return historyMapper.selectByExample(historyExample);
    }

    /**
     * 获取操作记录历史
     *
     * @param page
     * @param api_id
     * @return
     */
    @Override
    public List<ApiOperationhistory> getApiopeHistory(Integer page, Integer api_id) {
        PageHelper.startPage(page,10);
        ApiOperationhistoryExample example = new ApiOperationhistoryExample();
        example.createCriteria().andApiinfoIdEqualTo(api_id);
        return operationhistoryMapper.selectByExample(example);
    }
}
