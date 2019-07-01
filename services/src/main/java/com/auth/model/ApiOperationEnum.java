package com.auth.model;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public enum ApiOperationEnum {
    INSERT(1, "新增"),
    UPDATE(2, "修改"),
    DELETE(3, "删除"),
    UPDATEMOCKSTATUS(4,"更新mock状态");
    private Integer code;

    private String message;

    ApiOperationEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
