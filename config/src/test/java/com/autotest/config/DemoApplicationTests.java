package com.auth.demo;

import com.alibaba.fastjson.JSON;
import com.auth.controller.LoginController;
import com.auth.dao.SysUserMapper;
import com.auth.entity.SysUser;
import com.auth.entity.SysUserExample;
import com.auth.service.LoginService;
import com.auth.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    LoginController controller;
    @Resource
    LoginService loginService;
    @Resource
    SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
//		System.out.println(controller.login("10.0","admin","123456"));
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andAccountEqualTo("admin");
        List<SysUser> lists = sysUserMapper.selectByExample(sysUserExample);
        logger.info(JSON.toJSONString(lists));
    }

    @Test
    public  void test(){
        List list1 = new ArrayList();
        list1.add(0);
        List list2 = list1;
        System.out.println(list1.get(0) instanceof Integer);
        System.out.println(list2.get(0) instanceof Integer);
    }

    @Test
    public  void test1(){


    }


}
