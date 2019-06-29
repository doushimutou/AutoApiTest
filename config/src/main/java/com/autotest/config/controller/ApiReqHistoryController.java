package com.auth.controller;

import com.auth.entity.ApiOperationhistory;
import com.auth.entity.ApiReqHistory;
import com.auth.model.ApiResponse;
import com.auth.service.ApiReqHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Controller
@RequestMapping("/api")
public class ApiReqHistoryController {

    @Resource
    ApiReqHistoryService apiReqHistoryService;

    @RequestMapping(value = "/api/add_history", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addHistory(@RequestBody ApiReqHistory apiReqHistory) {
        ApiResponse apiResponse = new ApiResponse();
        if (apiReqHistoryService.addApiReqHistory(apiReqHistory) > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/api/history_list", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse addHistory(@RequestParam Integer api_id) {
        ApiResponse apiResponse = new ApiResponse();
        List<ApiReqHistory> historyList = apiReqHistoryService.getHistoryList(api_id);
        if (historyList.size() > 0) {
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setData(historyList);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 分页接口操作记录
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/api/operation_history", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse addOperationHistory(@RequestParam Integer project_id, @RequestParam Integer page, @RequestParam Integer api_id) {
        ApiResponse apiResponse = new ApiResponse();
        List<ApiOperationhistory> historyList = apiReqHistoryService.getApiopeHistory(page,api_id);
        if (historyList.size() > 0) {
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setData(historyList);
            apiResponse.setCount(historyList.size());
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

}
