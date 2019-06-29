package com.auth.controller;

import com.auth.entity.TestGlobalHost;
import com.auth.model.ApiResponse;
import com.auth.model.dto.HostDTO;
import com.auth.service.HostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Controller
@RequestMapping("/api/global")
public class HostController {
    @Resource
    HostService hostService;

    /**
     * 获取测试地址列表
     */
    @RequestMapping(value = "/host_total", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getHost(@RequestParam Integer project_id, @RequestParam(required = false) Integer page, @RequestParam(required = false) String name) {
        ApiResponse apiResponse = new ApiResponse();
        List<HostDTO> hostDTOS = hostService.getHost(project_id, page, name);
        if (hostDTOS.size() > 0) {
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setData(hostDTOS);
            apiResponse.setCount(hostDTOS.size());
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;

    }

    /**
     * 添加测试地址
     */
    @RequestMapping(value = "/add_host", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addHost(@RequestBody TestGlobalHost testGlobalHost) {
        ApiResponse apiResponse = new ApiResponse();
        if (hostService.addHost(testGlobalHost) > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 删除测试地址列表
     */
    @RequestMapping(value = "/del_host", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse delHost(@RequestBody HostDTO hostDTO) {
        ApiResponse apiResponse = new ApiResponse();
        Integer delHostNum = hostService.delHost(hostDTO.getProjectId(), hostDTO.getIds());
        if (delHostNum > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 修改测试地址列表
     */
    @RequestMapping(value = "/update_host", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updateHost(@RequestBody TestGlobalHost testGlobalHost) {
        ApiResponse apiResponse = new ApiResponse();
        if (hostService.editHost(testGlobalHost) > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

}
