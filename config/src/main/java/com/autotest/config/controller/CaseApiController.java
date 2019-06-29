package com.auth.controller;

import com.auth.entity.CaseApi;
import com.auth.model.ApiResponse;
import com.auth.model.dto.CaseApiDTO;
import com.auth.service.CaseApiService;
import org.apache.ibatis.annotations.Case;
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
public class CaseApiController {

    @Resource
    CaseApiService caseApiService;

    /**
     * 用例的api列表
     *
     * @param project_id
     * @param page
     * @param name
     * @param case_id
     */
    @RequestMapping(value = "/automation/api_list", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getCaseApiList(Integer project_id, Integer page, String name, Integer case_id) {

        ApiResponse apiResponse = new ApiResponse();
        List<CaseApi> caseApis = caseApiService.getCaseApi(project_id, page, name, case_id);
        if (caseApis.size() > 0) {
            apiResponse.setCount(caseApis.size());
            apiResponse.setData(caseApis);
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 新增用例 接口
     *
     * @param caseApiDTO
     * @return
     */
    @RequestMapping(value = "/automation/add_new_api", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addNewApi(@RequestBody CaseApiDTO caseApiDTO) {
        ApiResponse apiResponse = new ApiResponse();
        Integer a = caseApiService.addNewApi(caseApiDTO);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 用已经配置好的接口来组成用例
     *
     * @return
     */
    @RequestMapping(value = "/automation/add_old_api", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addOldApi(@RequestBody CaseApiDTO caseApiDTO) {
        ApiResponse apiResponse = new ApiResponse();
        Integer a = caseApiService.addOldApi(caseApiDTO.getProjectId(), caseApiDTO.getAutocaseId(), caseApiDTO.getIds());
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 用例接口详情
     * @param project_id
     * @param case_id
     * @param api_id
     * @return
     */
    @RequestMapping(value = "/automation/api_info", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getCaseApiInfo(@RequestParam Integer project_id, @RequestParam Integer case_id, @RequestParam Integer api_id) {
        CaseApiDTO caseApiDTO = caseApiService.getCaseApiInfo(project_id, case_id, api_id);
        if (caseApiDTO.getId() != null) {
            return ApiResponse.success(caseApiDTO);
        } else {
            return ApiResponse.failed();
        }
    }

}
