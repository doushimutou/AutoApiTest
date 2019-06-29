package com.auth.service.impl;

import com.auth.dao.TestGlobalHostMapper;
import com.auth.dao.TestProjectMapper;
import com.auth.entity.TestGlobalHost;
import com.auth.entity.TestGlobalHostExample;
import com.auth.entity.TestProject;
import com.auth.model.dto.HostDTO;
import com.auth.service.HostService;
import com.auth.utils.Exception.NormalException;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Author ayt  on
 */
@Component
public class HostServiceImpl implements HostService {
    @Resource
    TestGlobalHostMapper testGlobalHostMapper;
    @Resource
    TestProjectMapper testProjectMapper;

    @Override
    public List<HostDTO> getHost(Integer projectID, Integer page, String name) {
        if (page != null) {
            PageHelper.startPage(page, 10);
        }
        TestGlobalHostExample testGlobalHostExample = new TestGlobalHostExample();
        if (StringUtils.isEmpty(name)) {
            testGlobalHostExample.createCriteria();
        } else {
            testGlobalHostExample.createCriteria().andNameLike("%" + name + "%");
        }
        List<TestGlobalHost> testGlobalHostList = testGlobalHostMapper.selectByExample(testGlobalHostExample);
        //将查询到的host对象中放入project
        List<HostDTO> hostDTOS = testGlobalHostList.stream().map(testGlobalHost -> {
            HostDTO hostdto = new HostDTO();
            BeanUtils.copyProperties(testGlobalHost, hostdto);
            hostdto.setTestProject(testProjectMapper.selectByPrimaryKey(projectID));
            return hostdto;
        }).collect(Collectors.toList());
        return hostDTOS;
    }

    @Override
    public Integer addHost(TestGlobalHost testGlobalHost) {
        if (testGlobalHost.getStatus() == null) {
            testGlobalHost.setStatus((byte) 1);
        }
        return testGlobalHostMapper.insert(testGlobalHost);
    }

    @Override
    public Integer delHost(Integer projectId, List<Integer> ids) {
        TestGlobalHostExample testGlobalHostExample = new TestGlobalHostExample();
        testGlobalHostExample.createCriteria().andProjectIdEqualTo(projectId);
        List<TestGlobalHost> testGlobalHostList = testGlobalHostMapper.selectByExample(testGlobalHostExample);
        //根据projecId查询到的对应的hostId
        List<Integer> idsPro = testGlobalHostList.stream().map(testGlobalHost ->
                testGlobalHost.getId()).collect(Collectors.toList());
        //删除的行数返回
        return ids.stream().map(id -> {
                    if (idsPro.contains(id)) {
                        return testGlobalHostMapper.deleteByPrimaryKey(id);
                    } else {
                        throw new NormalException("id不存在");
                    }
                }
        ).collect(Collectors.toList()).size();
    }

    /**
     * 编辑host,启用禁用
     *
     * @param testGlobalHost
     */
    @Override
    public Integer editHost(TestGlobalHost testGlobalHost) {
        Integer a;
        TestGlobalHost testGlobalHost1 = testGlobalHostMapper.selectByPrimaryKey(testGlobalHost.getId());
        if (testGlobalHost.getStatus() == null) {
            testGlobalHost.setStatus((byte) 1);
            a = testGlobalHostMapper.updateByPrimaryKey(testGlobalHost);
        } else {
            testGlobalHost1.setStatus(testGlobalHost.getStatus());
            a = testGlobalHostMapper.updateByPrimaryKey(testGlobalHost1);
        }
        return a;
    }
}
