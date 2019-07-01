package com.auth.controller;

import com.auth.entity.TestProject;
import com.auth.model.ApiResponse;
import com.auth.model.dto.DelProjectDTO;
import com.auth.model.dto.TestProjectDTO;
import com.auth.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description
 * Author ayt  on
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/api")
public class ProjectController {
    private Logger logger = LoggerFactory.getLogger(ProjectService.class);
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/add_project", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse createProject(@RequestBody TestProject testProject) {
        ApiResponse apiResponse = new ApiResponse();
        if (projectService.createProject(testProject) > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/project/update_project", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse editProject(@RequestBody TestProject testProject) {
        ApiResponse apiResponse = new ApiResponse();
        if (projectService.editProject(testProject) > 0) {
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;

    }

    @RequestMapping(value = "/project/del_project", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse deleteProject(@RequestBody DelProjectDTO delProject) {
        ApiResponse apiResponse = new ApiResponse();
        delProject.getIds().forEach(id -> {
            if (!projectService.deleteProject(id).equals(1)) {
                apiResponse.setFailedResponse(apiResponse);
            }
            apiResponse.setSuccessResponse(apiResponse);
        });
        return apiResponse;
    }

    /**
     * 项目列表
     *
     * @param
     * @param page
     * @return
     */
    @RequestMapping(value = "/project/project_list")
    @ResponseBody
    public ApiResponse selectProject(@RequestParam String name, @RequestParam Integer page) {
        ApiResponse apiResponse = new ApiResponse();
        List<TestProject> testProjectList = projectService.selectProject(name, page);
        if (testProjectList.size() > 0) {
            apiResponse.setData(testProjectList);
            apiResponse.setSuccessResponse(apiResponse);
            apiResponse.setCount(testProjectList.size());
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        logger.info("这是：" + apiResponse.toString());
        return apiResponse;
    }

    /**
     * 获取项目详情
     *
     * @param
     */
    @RequestMapping(value = "/title/project_info",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getProjectDetail(@RequestParam Integer project_id) {
        ApiResponse apiResponse = new ApiResponse();
        TestProjectDTO testProjectDTO = projectService.selectProjectDetail(project_id);
        if (!testProjectDTO.getName().isEmpty()) {
            apiResponse.setData(testProjectDTO);
            apiResponse.setSuccessResponse(apiResponse);
        } else {
            apiResponse.setFailedResponse(apiResponse);
        }
        return apiResponse;
    }


}
