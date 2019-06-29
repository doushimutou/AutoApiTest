package com.auth.service;

import com.auth.entity.CaseGroupFirst;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface CaseGroupService {
    /**
     * 添加case第一个分组
     * @param caseGroupFirst
     * @return
     */
    Integer addCaseGroupFirst(CaseGroupFirst caseGroupFirst);

    /**
     * 获取caseGroup
     * @param project_id
     * @return
     */
    List<CaseGroupFirst> getCaseGroup(Integer project_id);
}
