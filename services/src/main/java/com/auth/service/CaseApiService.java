package com.auth.service;

import com.auth.entity.CaseApi;
import com.auth.model.dto.CaseApiDTO;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface CaseApiService {
    /**
     * 获取case接口列表
     *
     * @param project_id 项目ID
     * @param page       页码
     * @param name       名称
     * @param case_id    case ID
     * @return
     */
    List<CaseApi> getCaseApi(Integer project_id, Integer page, String name, Integer case_id);

    /**
     * 添加case api
     * @param caseApiDTO
     * @return
     */
    Integer addNewApi(CaseApiDTO caseApiDTO);

    /**
     * 添加case_api  用已经存在的用例
     * @param project_id
     * @param case_id
     * @param ids
     */
    Integer addOldApi(Integer project_id, Integer case_id, List<Integer> ids);

    /**
     * 获取caseApi详情
     * @param project_id 项目id
     * @param case_id 用例id
     * @param caseApi_id 用例接口id
     * @return
     */
    CaseApiDTO getCaseApiInfo(Integer project_id, Integer case_id, Integer caseApi_id);

}
