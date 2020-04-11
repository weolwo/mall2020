package com.poplar.valid;

import lombok.Getter;

/**
 * Create BY poplar ON 2020/4/11
 */
@Getter
public enum MSGEnum {

    PARAM_VALID_ERROR(400, "参数校验错误"),

    UNKNOWN_EXCEPTION(607, "未知异常，请联系客服");

    private Integer code;

    private String message;

    MSGEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
