package com.auth.utils.Exception;

import com.alibaba.druid.wall.violation.ErrorCode;

import com.auth.model.ErroCode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Description
 * Author ayt  on
 */
@Data
public class NormalException extends RuntimeException {


    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String errorCode;


    public NormalException(String message) {
        super(message);
        this.message = message;
    }

    public NormalException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public NormalException(Throwable cause) {
        super(cause);
    }


    public NormalException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public NormalException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.errorCode = errorCode;
    }

    public NormalException(ErroCode errorCode) {
        this(errorCode.getCode(), " [" + errorCode.getMessage() + "] ", (Throwable) null);
    }


}


