package com.auth.controller;

import com.auth.entity.TestCase;
import com.auth.model.ApiResponse;
import com.auth.service.CaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@RequestMapping("/api")
@Controller
public class CaseController {

    @Resource
    CaseService caseService;

    /**
     * 获取case列表 分页返回
     *
     * @param project_id
     * @param page
     * @param name
     * @param first_group_id
     * @param second_group_id
     * @return
     */
    @RequestMapping(value = "/automation/case_list", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getCaseLsit(@RequestParam Integer project_id, @RequestParam Integer page, @RequestParam String name, @RequestParam(required = false) Integer first_group_id, @RequestParam(required = false) Integer second_group_id) {
        ApiResponse apiResponse = new ApiResponse();
        List<TestCase> cases = caseService.getCaseList(project_id, page, name, first_group_id);
        if (cases.size() > 0) {
            apiResponse.setCount(cases.size());
            apiResponse.setData(cases);
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/automation/add_case", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addCase(@RequestBody TestCase testCase) {
        ApiResponse apiResponse = new ApiResponse();
        Integer a = caseService.addCase(testCase);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }



}
