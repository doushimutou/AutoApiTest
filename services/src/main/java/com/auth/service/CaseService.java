package com.auth.service;

import com.auth.entity.TestCase;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface CaseService {
    /**
     * 获取case列表 分页返回
     * @param projectID
     * @param page
     * @param name
     * @param fristGroupID
     * @return
     */
    List<TestCase> getCaseList(Integer projectID, Integer page, String name, Integer fristGroupID);

    /**
     * 新增用例
     * @param testCase
     * @return
     */
    Integer addCase(TestCase testCase);
}
