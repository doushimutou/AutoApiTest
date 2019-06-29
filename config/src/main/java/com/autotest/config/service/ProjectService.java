package com.auth.service;

import com.auth.entity.TestProject;
import com.auth.model.dto.TestProjectDTO;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface ProjectService {
    /**
     * 创建项目
     * @param testProject
     * @return
     */
    int createProject(TestProject testProject);

    /**
     * 编辑、启用禁用
     * @param testProject
     * @return
     */
    int editProject(TestProject testProject);

    /**
     * 删除项目
     * @param id
     * @return
     */
    Integer deleteProject(Integer id);

    /**
     * 查询项目列表
     * @param projectName
     */
    List<TestProject> selectProject(String projectName,Integer pageIndex);

    /**
     * 通过id 查询项目详情
     * @param id
     * @return
     */
    TestProjectDTO selectProjectDetail(Integer id);
}
