package com.auth.service;

import com.auth.entity.ApiGroupFirst;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface ApiGroupService {
     /**
      * 添加接口分组
      * @param apiGroupFirst
      * @return
      */
     Integer addApiGroup(ApiGroupFirst apiGroupFirst);

     /**
      * 通过project—id 获取接口分组
      * @param project_id
      * @return
      */
     List<ApiGroupFirst> getApiGroupByPro(Integer project_id);
}
