package com.auth.controller;

import com.alibaba.fastjson.JSON;
import com.auth.model.ApiResponse;
import com.auth.model.Result;
import com.auth.entity.SysUser;
import com.auth.model.ResultCode;
import com.auth.service.LoginService;
import com.auth.utils.TokenUtil;
import com.auth.utils.WebLogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Description
 * Author ayt  on
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/user")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse login(@RequestBody SysUser sysUser) {

        logger.info("这个是个迷："+ JSON.toJSONString(sysUser) );
        ApiResponse apiResponse = new ApiResponse();
        Result result = loginService.login(sysUser.getLastloginip(), sysUser.getAccount(), sysUser.getPassword());
        BeanUtils.copyProperties(result, apiResponse);
        if (!result.getCode().equals(ResultCode.SUCCESS)) {
            return apiResponse;
        }
            SysUser user = (SysUser) result.getData();
            //返回token
            String token = TokenUtil.sign(user.getName(), String.valueOf(user.getId()));
            apiResponse.setToken(token);

        return apiResponse;
    }

}
