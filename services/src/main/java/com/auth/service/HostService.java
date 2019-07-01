package com.auth.service;

import com.auth.entity.TestGlobalHost;
import com.auth.model.dto.HostDTO;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface HostService {
    /**
     * 分页查询
     *
     * @param projectID
     * @param page
     * @param name
     * @return
     */
    List<HostDTO> getHost(Integer projectID, Integer page, String name);

    /**
     * 添加host
     *
     * @param testGlobalHost
     * @return
     */
    Integer addHost(TestGlobalHost testGlobalHost);

    /**
     * 删除host
     * @param projectId
     * @return
     */
    Integer delHost(Integer projectId, List<Integer> ids);

    /**
     * 编辑host,启用禁用
     * @param testGlobalHost
     */
    Integer editHost(TestGlobalHost testGlobalHost);
}
