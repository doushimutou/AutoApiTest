package com.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth.dao.CaseApiMapper;
import com.auth.dao.TestApiMapper;
import com.auth.dao.TestCaseMapper;
import com.auth.dao.TestGlobalHostMapper;
import com.auth.entity.*;
import com.auth.model.ApiResponse;
import com.auth.model.RequestParamas;
import com.auth.model.TestResult;
import com.auth.model.dto.StartTestDTO;
import com.auth.service.CaseService;
import com.auth.utils.http.NewAssured;
import com.github.pagehelper.PageHelper;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description
 * Author ayt  on
 */
@Service
public class CaseServiceImpl implements CaseService {
    private Logger logger = LoggerFactory.getLogger(CaseServiceImpl.class);


    @Resource
    TestCaseMapper testCaseMapper;
    @Resource
    TestGlobalHostMapper testGlobalHostMapper;
    @Resource
    CaseApiMapper caseApiMapper;
    @Resource
    TestApiMapper testApiMapper;

    /**
     * 获取case列表 分页返回
     *
     * @param projectID
     * @param page
     * @param name
     * @param fristGroupID
     * @return
     */
    @Override
    public List<TestCase> getCaseList(Integer projectID, Integer page, String name, Integer fristGroupID) {
        PageHelper.startPage(page, 10);
        TestCaseExample example = new TestCaseExample();
        if (fristGroupID == null) {
            example.createCriteria().andProjectIdEqualTo(projectID).andCasenameLike("%" + name + "%");
        } else {
            example.createCriteria().andProjectIdEqualTo(projectID).andCasenameLike("%" + name + "%").andAutogroupfirstIdEqualTo(fristGroupID);
        }
        return testCaseMapper.selectByExample(example);
    }

    /**
     * 新增用例
     *
     * @param testCase
     * @return
     */
    @Override
    public Integer addCase(TestCase testCase) {
        testCase.setUpdatetime(new Date());
        return testCaseMapper.insert(testCase);
    }

    /**
     * 开始测试
     * 实际发送http请求
     *
     * @param startTestDTO
     */
    @Override
    public ApiResponse startTest(StartTestDTO startTestDTO) {
        TestGlobalHost testGlobalHost = testGlobalHostMapper.selectByPrimaryKey(startTestDTO.getHost_id());
        TestApi testApi = testApiMapper.selectByPrimaryKey(startTestDTO.getId());
        CaseApi caseApi = caseApiMapper.selectByPrimaryKey(startTestDTO.getId());
        String url = caseApi.getHttpType().toLowerCase() + "://" + testGlobalHost.getHost() + caseApi.getAddress();
        String params = caseApi.getRequestparamter();
        if (caseApi.getRequesttype().equals("GET")) {
            Response response = NewAssured.get(paramsConverToMap(params), url);
            //将请求结果回写数据库
            caseApi.setHttpcode(String.valueOf(response.getStatusCode()));
            caseApi.setResponsedata(response.getBody().asString());
            caseApiMapper.updateByPrimaryKey(caseApi);
            if (response.getStatusCode() == 200) {
                return ApiResponse.success(response.getBody().as(Object.class));
            } else {
                return ApiResponse.failed();
            }
        } else {
            String requestParameterType = caseApi.getRequestparametertype();
            Response response = NewAssured.post(postParamsConverToMap(params, requestParameterType), url);
            caseApi.setHttpcode(String.valueOf(response.getStatusCode()));
            caseApi.setResponsedata(String.valueOf(response.getBody()));
            caseApiMapper.updateByPrimaryKey(caseApi);
            if (response.getStatusCode() == 200) {
                return ApiResponse.success(response.getBody().asString());
            } else {
                return ApiResponse.failed();
            }
        }
    }



    /**
     * get请求参数转换成map
     *
     * @param params
     * @return
     */
    public Map<String, String> paramsConverToMap(String params) {
        List<RequestParamas> lists = JSONObject.parseArray(params, RequestParamas.class);
        Map<String, String> map = lists.stream().collect(Collectors.toMap(RequestParamas::getName, RequestParamas::getValue));
        return map;
    }

    /**
     * post请求转换成map
     *
     * @param params
     * @return
     */
    public Map<String, Object> postParamsConverToMap(String params, String requestParameterType) {
        Map<String, Object> map = new HashMap<>();
        if ("raw".equals(requestParameterType)) {
            map = (Map) JSONObject.parse(params);
        } else {
            List<RequestParamas> lists = JSONObject.parseArray(params, RequestParamas.class);
            map = lists.stream().collect(Collectors.toMap(RequestParamas::getName, RequestParamas::getValue));
        }
        return map;
    }


}
