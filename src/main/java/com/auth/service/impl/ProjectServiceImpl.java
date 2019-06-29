package com.auth.service.impl;

import com.auth.dao.TestProjectMapper;
import com.auth.entity.TestProject;
import com.auth.entity.TestProjectExample;
import com.auth.model.dto.TestProjectDTO;
import com.auth.service.ProjectService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description
 * Author ayt  on
 *
 * @author Administrator
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    TestProjectMapper testProjectMapper;


    @Override
    public int createProject(TestProject testProject) {
        if (testProject.getStatus() == null) {
            testProject.setStatus((byte) 1);
        }
        if (testProject.getCreattime() == null) {
            testProject.setCreattime(new Date());
        }
        testProject.setUpdatetime(new Date());
        return testProjectMapper.insert(testProject);
    }

    @Override
    public int editProject(TestProject testProject) {
        TestProject testProject1 = testProjectMapper.selectByPrimaryKey(testProject.getId());
        testProject1.setUpdatetime(new Date());
        if (!(testProject.getStatus() == null)) {
            testProject1.setStatus(testProject.getStatus());
        }
        return testProjectMapper.updateByPrimaryKeySelective(testProject1);

    }

    @Override
    public Integer deleteProject(Integer id) {
        return testProjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TestProject> selectProject(String projectName, Integer pageIndex) {
        PageHelper.startPage(pageIndex, 10);
        TestProjectExample testProjectExample = new TestProjectExample();
        if (projectName.isEmpty()) {
            testProjectExample.createCriteria();
        } else {
            testProjectExample.createCriteria().andNameLike("%" + projectName + "%");
        }

        return testProjectMapper.selectByExample(testProjectExample);
    }

    @Override
    public TestProjectDTO selectProjectDetail(Integer id) {
        TestProjectDTO testProjectDTO = new TestProjectDTO();
        if (id == null) {
            return testProjectDTO;
        }
        TestProject testProject = testProjectMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(testProject, testProjectDTO);
        testProjectDTO.setApiCount(10);
        testProjectDTO.setMemberCount(5);
        testProjectDTO.setDynamicCount(5);
        testProjectDTO.setStatusCount(10);
        return testProjectDTO;
    }


}
