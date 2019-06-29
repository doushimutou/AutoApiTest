package com.auth.model.dto;

import com.auth.entity.TestProject;
import lombok.Data;

/**
 * Description
 * Author ayt  on
 */
@Data
public class TestProjectDTO extends TestProject {
    /**
     * 项目列表总计
     */
    Integer count;
    /**
     * 项目动态数
     */
    Integer dynamicCount;
    /**
     * 项目成员数量
     */
    Integer memberCount;
    /**
     * 接口数
     */
    Integer apiCount;
    /**
     * 状态码数量
     */
    Integer statusCount;
}
