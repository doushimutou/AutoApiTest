package com.auth.service;


import com.auth.entity.TestApi;
import com.auth.model.dto.ApiDTO;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */

public interface ApiService {
    /**
     * 获取接口列表
     * @param projectId
     * @param page
     * @param name
     * @return
     */
    List<TestApi> getApiList(Integer projectId, Integer page, String name, Integer apiGroupLevelFirst_id);

    /**
     * 添加接口
     * @param apiDTO
     * @return
     */
    Integer addApi(ApiDTO apiDTO);

    /**
     * 修改接口
     * @param apiDTO
     * @return
     */
    Integer updateApiDeatil(ApiDTO apiDTO);

    /**
     * 获取api 详情
     * @param projectID
     * @param apiID
     * @return
     */
    ApiDTO getApiInfo(Integer projectID, Integer apiID);

    /**
     * 修改接口mock状态
     * @param apiDTO
     * @return
     */
    Integer updateMock(ApiDTO apiDTO);
}
