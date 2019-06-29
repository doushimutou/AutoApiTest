package com.auth.service.impl;

import com.auth.dao.ApiGroupFirstMapper;
import com.auth.entity.ApiGroupFirst;
import com.auth.entity.ApiGroupFirstExample;
import com.auth.service.ApiGroupService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Component
public class ApiGroupServiceImpl implements ApiGroupService {

    @Resource
    ApiGroupFirstMapper firstMapper;

    @Override
    public Integer addApiGroup(ApiGroupFirst apiGroupFirst) {
        return firstMapper.insert(apiGroupFirst);
    }

    /**
     * 通过project—id 获取接口分组
     *
     * @param project_id
     * @return
     */
    @Override
    public List<ApiGroupFirst> getApiGroupByPro(Integer project_id) {
        ApiGroupFirstExample apiGroupFirstExample = new ApiGroupFirstExample();
        apiGroupFirstExample.createCriteria().andProjectIdEqualTo(project_id);
        return firstMapper.selectByExample(apiGroupFirstExample);
    }
}
