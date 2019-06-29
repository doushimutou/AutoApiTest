package com.auth.model;

import lombok.Data;

/**
 * Description
 * Author ayt  on
 */
@Data
public class Result {
    /**
     * 结果体
     */
    protected Object data;

    /**
     * 状态码
     */
    protected Integer code;

    /**
     * 信息
     */
    protected String message;

}
