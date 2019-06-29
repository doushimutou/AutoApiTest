package com.auth.service;

import com.auth.model.Result;

/**
 * Description
 * Author ayt  on
 */
public interface LoginService {
    /**
     * 登陆接口
     * @return
     */
    Result login(String ip, String account, String password);
}
