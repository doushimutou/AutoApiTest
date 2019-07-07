package com.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auth.dao.CaseApiMapper;
import com.auth.dao.TestApiMapper;
import com.auth.dao.TestGlobalHostMapper;
import com.auth.entity.CaseApi;
import com.auth.entity.CaseApiExample;
import com.auth.entity.TestApi;
import com.auth.entity.TestGlobalHost;
import com.auth.model.dto.CaseApiDTO;
import com.auth.model.dto.CaseApiResponseDTO;
import com.auth.service.CaseApiService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Author ayt  on
 */
@Service
public class CaseApiServiceImpl implements CaseApiService {
    private Logger logger = LoggerFactory.getLogger(CaseApiServiceImpl.class);

    @Resource
    CaseApiMapper caseApiMapper;
    @Resource
    TestApiMapper testApiMapper;
    @Resource
    TestGlobalHostMapper testGlobalHostMapper;


    /**
     * 获取case接口列表
     *
     * @param project_id 项目ID
     * @param page       页码
     * @param name       名称
     * @param case_id    case ID
     * @return
     */
    @Override
    public List<CaseApi> getCaseApi(Integer project_id, Integer page, String name, Integer case_id) {
        PageHelper.startPage(page, 10);
        CaseApiExample caseApiExample = new CaseApiExample();
        caseApiExample.createCriteria().andProjectIdEqualTo(project_id).andNameLike("%" + name + "%").andAutocaseIdEqualTo(case_id);
        return caseApiMapper.selectByExample(caseApiExample);
    }

    /**
     * 添加case api
     *
     * @param caseApiDTO
     * @return
     */
    @Override
    public Integer addNewApi(CaseApiDTO caseApiDTO) {
        CaseApi caseApi = new CaseApi();
        BeanUtils.copyProperties(caseApiDTO, caseApi);
        caseApi.setHeader(JSONObject.toJSONString(caseApiDTO.getHeadDict()));
        return caseApiMapper.insert(caseApi);
    }

    /**
     * 添加case_api  用已经存在的用例
     *
     * @param project_id
     * @param case_id
     * @param ids
     */
    @Override
    public Integer addOldApi(Integer project_id, Integer case_id, List<Integer> ids) {
        //testapi
        List<TestApi> testApis = ids.stream().map(
                id -> testApiMapper.selectByPrimaryKey(id)).collect(Collectors.toList());
        //插入的数据条数
        List<Integer> integers = testApis.stream().map(testApi -> {
            CaseApi caseApi = new CaseApi();
            caseApi.setHeader(testApi.getRequestHead());
            caseApi.setAddress(testApi.getApiaddress());
            caseApi.setAutocaseId(case_id);
            caseApi.setName(testApi.getName());
            caseApi.setHttpType(testApi.getHttpType());
            caseApi.setProjectId(project_id);
            caseApi.setRequestparamter(testApi.getRequestparameter());
            caseApi.setRequestparametertype(testApi.getRequestparametertype());
            caseApi.setRequesttype(testApi.getRequestType());
            caseApi.setExaminetype("no_check");
            caseApi.setApiId(testApi.getId());
            return caseApiMapper.insert(caseApi);
        }).collect(Collectors.toList());

        return integers.size();
    }

    /**
     * 获取caseApi详情
     *
     * @param project_id 项目id
     * @param case_id    用例id
     * @param caseApi_id 用例接口id
     * @return
     */
    @Override
    public CaseApiDTO getCaseApiInfo(Integer project_id, Integer case_id, Integer caseApi_id) {
        CaseApiDTO caseApiDTO = new CaseApiDTO();
        CaseApi caseApi = caseApiMapper.selectByPrimaryKey(caseApi_id);
        if (caseApi != null) {
            BeanUtils.copyProperties(caseApi, caseApiDTO);
            caseApiDTO.setHeadDict(JSONArray.parseArray(caseApi.getHeader()));
            if (caseApi.getRequestparametertype().equals("raw")) {
                caseApiDTO.setFormatRaw(true);
            } else {
                caseApiDTO.setRequestList(JSONArray.parseArray(caseApi.getRequestparamter()));
            }
            logger.info(JSONObject.toJSONString(caseApiDTO) + "aaaa");
        }
        return caseApiDTO;
    }

    /**
     * 用例api  执行结果
     *
     * @param project_id
     * @param case_id
     * @param api_id
     * @return
     */
    @Override
    public CaseApiDTO resultDetail(Integer project_id, Integer case_id, Integer api_id, Integer host_id) {
        TestGlobalHost testGlobalHost = testGlobalHostMapper.selectByPrimaryKey(host_id);
        CaseApiDTO caseApi = getCaseApiInfo(project_id, case_id, api_id);
        String url = caseApi.getHttpType().toLowerCase() + "://" + testGlobalHost.getHost() + caseApi.getAddress();
        caseApi.setUrl(url);
        return caseApi;
    }

    /**
     * 接口关联
     * 关联逻辑是根据case下，caseApi是否有小于ID的caseApi
     *
     * @param project_id
     * @param case_id
     * @return
     */
    @Override
    public List<CaseApiResponseDTO> getCollection(Integer project_id, Integer case_id, Integer caseApi_id) {
        List<CaseApiResponseDTO> caseApiResponseDTOS = new ArrayList<>();
        CaseApiExample caseApiExample = new CaseApiExample();
        if (caseApi_id != null) {
            caseApiExample.createCriteria().andAutocaseIdEqualTo(case_id).andIdLessThan(caseApi_id);
            List<CaseApi> caseApis = caseApiMapper.selectByExample(caseApiExample);
            caseApiResponseDTOS = caseApis.stream().map(caseApi -> {
                CaseApiResponseDTO caseApiResponseDTO = new CaseApiResponseDTO();
                caseApiResponseDTO.setId(caseApi.getId());
                caseApiResponseDTO.setName(caseApi.getName());
                caseApiResponseDTO.setResponse(JSONObject.parse(caseApi.getResponsedata()));
                return caseApiResponseDTO;
            }).collect(Collectors.toList());
        }
        return caseApiResponseDTOS;
    }
}
