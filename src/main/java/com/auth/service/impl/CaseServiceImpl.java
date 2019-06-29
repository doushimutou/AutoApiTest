package com.auth.service.impl;

import com.auth.dao.TestCaseMapper;
import com.auth.entity.TestCase;
import com.auth.entity.TestCaseExample;
import com.auth.service.CaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Service
public class CaseServiceImpl implements CaseService {


    @Resource
    TestCaseMapper testCaseMapper;

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
}
