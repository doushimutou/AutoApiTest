package com.auth.model;

import lombok.Data;

/**
 * Description
 * Author ayt  on
 */
@Data
public class ApiResponse extends Result {
    /**
     * token
     */
    protected String token;
    /**
     * 项目列表返回总数
     */
    private Integer count;

    public ApiResponse() {
    }

    public ApiResponse(Integer code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "token='" + token + '\'' +
                ", count=" + count +
                ", data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public void setSuccessResponse(ApiResponse apiResponse) {
        apiResponse.setCode(Integer.valueOf(ErroCode.SUCCESS.getCode()));
        apiResponse.setMessage(ErroCode.SUCCESS.getMessage());
    }

    public void setFailedResponse(ApiResponse apiResponse) {
        apiResponse.setCode(Integer.valueOf(ErroCode.FAILED.getCode()));
        apiResponse.setMessage(ErroCode.FAILED.getMessage());
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(Integer.valueOf(ErroCode.SUCCESS.getCode()), ErroCode.SUCCESS.getMessage(),data);
    }
    public static ApiResponse failed() {
        return new ApiResponse(Integer.valueOf(ErroCode.FAILED.getCode()), ErroCode.FAILED.getMessage());
    }
}
