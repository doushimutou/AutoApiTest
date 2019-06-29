package com.auth.model.dto;

import com.auth.entity.TestGlobalHost;
import com.auth.entity.TestProject;

import java.util.List;

/**
 * Description
 * Author ayt  on
 */
public class HostDTO extends TestGlobalHost{
    /**
     * total host列表页总数
     */
    private Integer total;
    /**
     * project host对应的project
     */
    TestProject testProject;
    /**
     * 删除host列表对应的hostId
     */
    List<Integer> ids ;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public TestProject getTestProject() {
        return testProject;
    }

    public void setTestProject(TestProject testProject) {
        this.testProject = testProject;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
