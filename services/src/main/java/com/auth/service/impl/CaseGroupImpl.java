package com.auth.service.impl;

import com.auth.dao.CaseGroupFirstMapper;
import com.auth.entity.CaseGroupFirst;
import com.auth.entity.CaseGroupFirstExample;
import com.auth.service.CaseGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Service
public class CaseGroupImpl implements CaseGroupService {
    @Resource
    CaseGroupFirstMapper caseGroupFirstMapper;

    @Override
    public Integer addCaseGroupFirst(CaseGroupFirst caseGroupFirst) {
        return caseGroupFirstMapper.insert(caseGroupFirst);
    }

    /**
     * 获取caseGroup
     *
     * @param project_id
     * @return
     */
    @Override
    public List<CaseGroupFirst> getCaseGroup(Integer project_id) {

        CaseGroupFirstExample caseGroupFirstExample = new CaseGroupFirstExample();
        caseGroupFirstExample.createCriteria().andProjectIdEqualTo(project_id);
        return caseGroupFirstMapper.selectByExample(caseGroupFirstExample);

    }
}
