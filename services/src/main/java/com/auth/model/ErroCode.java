package com.auth.model;

import lombok.AllArgsConstructor;

/**
 * Description
 *
 * @AllArgsConstructor 使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
 * @NoArgsConstructor 使用后创建一个无参构造函数
 * Author ayt  on
 */
@AllArgsConstructor
public enum ErroCode {


    SUCCESS("1", "成功"),
    FAILED("2", "失败");


    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
