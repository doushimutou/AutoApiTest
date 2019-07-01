package com.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.auth.dao.SysUserMapper;
import com.auth.entity.SysUser;
import com.auth.entity.SysUserExample;
import com.auth.model.Result;
import com.auth.model.ResultCode;
import com.auth.service.LoginService;
import com.auth.utils.Exception.NormalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Resource
    SysUserMapper sysUserMapper;

    /**
     * 查询账户是否存在，如果存在则更新登陆信息
     *
     * @param ip
     * @param account
     * @param password
     * @return
     */
    @Override
    public Result login(String ip, String account, String password) {
        Result result = new Result();
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
        try {
            List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
            logger.info(JSON.toJSONString(sysUserList));
            if (CollectionUtils.isEmpty(sysUserList)) {
                result.setCode(ResultCode.ERROR);
                result.setMessage("此账号不存在");
            } else if (!sysUserList.get(0).getPassword().equals(password)) {
                result.setCode(ResultCode.DAO_ERROR);
                result.setMessage("密码不正确");
            } else {
                result.setCode(ResultCode.SUCCESS);
                result.setMessage("成功");
                result.setData(sysUserList.get(0));
                SysUser sysUser = sysUserList.get(0);
                sysUser.setLastloginip("10.1.1.2");
                sysUser.setLastlogintime(new Date());
                sysUserMapper.updateByPrimaryKey(sysUser);
            }
        } catch (Exception e) {
            throw new  NormalException("数据库查询有错误");
        }
        return result;
    }
}
