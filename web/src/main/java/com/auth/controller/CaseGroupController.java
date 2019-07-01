package com.auth.controller;

import com.auth.entity.CaseGroupFirst;
import com.auth.model.ApiResponse;
import com.auth.service.CaseGroupService;
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
public class CaseGroupController {
    @Resource
    CaseGroupService caseGroupService;

    /**
     * 添加分组
     *
     * @param caseGroupFirst
     * @return
     */
    @RequestMapping(value = "/automation/add_group", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addCaseGroup(@RequestBody CaseGroupFirst caseGroupFirst) {
        ApiResponse apiResponse = new ApiResponse();
        Integer a = caseGroupService.addCaseGroupFirst(caseGroupFirst);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 获取分组
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/automation/group", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getCaseGroup(@RequestParam Integer project_id) {
        ApiResponse apiResponse = new ApiResponse();
        List<CaseGroupFirst> caseGroupFirsts = caseGroupService.getCaseGroup(project_id);
        if (caseGroupFirsts.size() > 0) {
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setData(caseGroupFirsts);
            apiResponse.setCount(caseGroupFirsts.size());
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }
}
