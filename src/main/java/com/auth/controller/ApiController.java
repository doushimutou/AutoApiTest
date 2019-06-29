package com.auth.controller;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.auth.entity.ApiGroupFirst;
import com.auth.entity.TestApi;
import com.auth.model.ApiResponse;
import com.auth.model.dto.ApiDTO;
import com.auth.service.ApiGroupService;
import com.auth.service.ApiService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Author ayt  on
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Resource
    ApiService apiService;
    @Resource
    ApiGroupService apiGroupService;


    /**
     * apilist 接口列表、分组
     *
     * @param projectId
     * @param page
     * @param name
     * @return
     */
    @RequestMapping(value = "/api/api_list", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse apiList(@RequestParam Integer projectId, @RequestParam Integer page, @RequestParam(required = false) String name, @RequestParam(required = false) Integer apiGroupLevelFirst_id) {
        ApiResponse apiResponse = new ApiResponse();
        List<TestApi> apis = apiService.getApiList(projectId, page, name, apiGroupLevelFirst_id);
        if (apis.size() > 0) {
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setData(apis);
            apiResponse.setCount(apis.size());
        } else {
            apiResponse.setSuccessResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 添加api分组
     *
     * @param apiGroupFirst
     * @return
     */
    @RequestMapping(value = "/api/add_group", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addApiGroup(@RequestBody ApiGroupFirst apiGroupFirst) {
        ApiResponse apiResponse = new ApiResponse();
        Integer a = apiGroupService.addApiGroup(apiGroupFirst);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 通过项ID查询api分组
     *
     * @param project_id
     * @return
     */
    @RequestMapping(value = "/api/group", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getApiGroup(@RequestParam Integer project_id) {
        ApiResponse apiResponse = new ApiResponse();
        List<ApiGroupFirst> groupFirstLis = apiGroupService.getApiGroupByPro(project_id);
        if (groupFirstLis.size() > 0) {
            apiResponse.setCount(groupFirstLis.size());
            apiResponse.setData(groupFirstLis);
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 添加接口
     * @param
     * @return
     */
    @RequestMapping(value = "/api/add_api", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addApiDetail(@RequestBody Map<String, Object> apiMap) {
        if (apiMap.get("requestparametertype").equals("raw")) {
            apiMap.put("requestList", null);
        }
        ApiDTO apiDTO = new ApiDTO();
        transMap2Bean(apiMap, apiDTO);
        ApiResponse apiResponse = new ApiResponse();
        Integer a = apiService.addApi(apiDTO);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 更新api详情
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/api/update_api", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updateApiDetail(@RequestBody Map<String, Object> apiMap) {
        if (apiMap.get("requestparametertype").equals("raw")) {
            apiMap.put("requestList", null);
        }
        ApiDTO apiDTO = new ApiDTO();
        transMap2Bean(apiMap, apiDTO);
        ApiResponse apiResponse = new ApiResponse();
        Integer a = apiService.updateApiDeatil(apiDTO);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 获取接口详情
     *
     * @param project_id
     * @param api_id
     */
    @RequestMapping(value = "/api/api_info", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getApiInfo(@RequestParam Integer project_id, @RequestParam Integer api_id) {
        ApiResponse apiResponse = new ApiResponse();
        ApiDTO apiDTO = apiService.getApiInfo(project_id, api_id);
        if (apiDTO == null) {
            apiResponse.setFailedResponse(apiResponse);
        } else {
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setData(apiDTO);
        }
        return apiResponse;
    }

    /**
     * 更新mock状态
     *
     * @param apiDTO
     * @return
     */
    @RequestMapping(value = "/api/updateMock", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updateMock(@RequestBody ApiDTO apiDTO) {
        ApiResponse apiResponse = new ApiResponse();
        Integer a = apiService.updateMock(apiDTO);
        if (a > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * map to bean
     *
     * @param apiMap
     * @param apiDTO
     */
    public static void transMap2Bean(Map<String, Object> apiMap, ApiDTO apiDTO) {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(apiDTO, apiMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
