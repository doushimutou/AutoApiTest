package com.auth.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auth.dao.ApiOperationhistoryMapper;
import com.auth.dao.TestApiMapper;
import com.auth.entity.ApiOperationhistory;
import com.auth.entity.TestApi;
import com.auth.entity.TestApiExample;
import com.auth.model.ApiOperationEnum;
import com.auth.model.dto.ApiDTO;
import com.auth.service.ApiService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Component
public class ApiServiceImpl implements ApiService {

    @Resource
    TestApiMapper testApiMapper;
    @Resource
    ApiOperationhistoryMapper apiOperationhistoryMapper;

    /**
     * 获取接口列表
     *
     * @param projectId
     * @param page
     * @param name
     * @return
     */
    @Override
    public List<TestApi> getApiList(Integer projectId, Integer page, String name, Integer apiGroupLevelFirst_id) {
        PageHelper.startPage(page, 10);
        TestApiExample testApiExample = new TestApiExample();
        if (apiGroupLevelFirst_id == null) {
            if (name == null) {
                testApiExample.createCriteria().andProjectidEqualTo(projectId);
            }else {
                testApiExample.createCriteria().andProjectidEqualTo(projectId).andNameLike("%" + name + "%");
            }
        } else {
            testApiExample.createCriteria().andProjectidEqualTo(projectId).andApigrouplevelfirstidEqualTo(apiGroupLevelFirst_id);
        }

        List<TestApi> testApis = testApiMapper.selectByExample(testApiExample);
        return testApis;
    }

    /**
     * 添加api
     *
     * @param apiDTO
     * @return
     */
    @Override
    public Integer addApi(ApiDTO apiDTO) {
        TestApi testApi = new TestApi();
        BeanUtils.copyProperties(apiDTO, testApi);
        //mock状态默认为不开启动
        testApi.setMockstatus((byte) 0);
        testApi.setUpdatetime(new Date());
        testApi.setRequestHead(JSONObject.toJSONString(apiDTO.getHeadDict()));
        if (testApi.getRequestparametertype().equals("raw")) {
            testApi.setRequestparameter(apiDTO.getRequestparameter());
        } else {
            testApi.setRequestparameter(JSONObject.toJSONString(apiDTO.getRequestList()));
        }
        testApi.setResponse(JSONObject.toJSONString(apiDTO.getResponseList()));
        Integer a = testApiMapper.insert(testApi);
        //添加操作记录
        if (a > 0) {
            ApiOperationhistory operationhistory = new ApiOperationhistory();
            operationhistory.setDescription(ApiOperationEnum.INSERT.getMessage() + ":" + testApi.getName());
            operationhistory.setTime(new Date());
            operationhistory.setUser("admin");
            operationhistory.setApiinfoId(testApi.getId());
            apiOperationhistoryMapper.insert(operationhistory);
        }
        return a;
    }

    /**
     * 修改接口
     *
     * @param apiDTO
     * @return
     */
    @Override
    public Integer updateApiDeatil(ApiDTO apiDTO) {
        TestApi testApi = new TestApi();
        BeanUtils.copyProperties(apiDTO, testApi);
        testApi.setUpdatetime(new Date());
        testApi.setStatus(apiDTO.getStatus());
        testApi.setRequestHead(JSONObject.toJSONString(apiDTO.getHeadDict()));
        if (testApi.getRequestparametertype().equals("raw")) {
            testApi.setRequestparameter(apiDTO.getRequestparameter());
        } else {
            testApi.setRequestparameter(JSONObject.toJSONString(apiDTO.getRequestList()));
        }
        testApi.setResponse(JSONObject.toJSONString(apiDTO.getResponseList()));
        if (StringUtils.isEmpty(testApi.getMockCode())) {
            testApi.setMockstatus((byte) 0);
        } else {
            testApi.setMockstatus((byte) 1);
        }
        Integer a = testApiMapper.updateByPrimaryKey(testApi);
        //添加操作记录
        if (a > 0) {
            ApiOperationhistory operationhistory = new ApiOperationhistory();
            operationhistory.setDescription(ApiOperationEnum.UPDATE.getMessage() + ":" + testApi.getName());
            operationhistory.setTime(new Date());
            operationhistory.setUser("admin");
            operationhistory.setApiinfoId(testApi.getId());
            apiOperationhistoryMapper.insert(operationhistory);
        }
        return a;
    }

    /**
     * 获取api 详情
     *
     * @param projectID
     * @param apiID
     * @return
     */
    @Override
    public ApiDTO getApiInfo(Integer projectID, Integer apiID) {
        ApiDTO apiDTO = new ApiDTO();
        TestApi testApi = testApiMapper.selectByPrimaryKey(apiID);
        BeanUtils.copyProperties(testApi, apiDTO);
        if (apiDTO.getRequestparametertype().equals("raw")) {
            apiDTO.setRequestparameter(testApi.getRequestparameter());
            apiDTO.setRequestList(new ArrayList<>());
        } else {
            apiDTO.setRequestList(JSONArray.parseArray(testApi.getRequestparameter()));
        }
        apiDTO.setHeadDict(JSONObject.parseArray(testApi.getRequestHead()));
        apiDTO.setResponseList(JSONObject.parseArray(testApi.getResponse()));
        return apiDTO;
    }

    /**
     * 修改接口mock状态
     *
     * @param apiDTO
     * @return
     */
    @Override
    public Integer updateMock(ApiDTO apiDTO) {
        apiDTO.setUpdatetime(new Date());
        apiDTO.setMockstatus(apiDTO.getMockstatus());
        Integer a = testApiMapper.updateByPrimaryKeySelective(apiDTO);
        //添加操作记录
        if (a > 0) {
            ApiOperationhistory operationhistory = new ApiOperationhistory();
            operationhistory.setDescription(ApiOperationEnum.UPDATEMOCKSTATUS.getMessage());
            operationhistory.setTime(new Date());
            operationhistory.setUser("admin");
            operationhistory.setApiinfoId(apiDTO.getId());
            apiOperationhistoryMapper.insert(operationhistory);
        }
        return a;
    }
}
