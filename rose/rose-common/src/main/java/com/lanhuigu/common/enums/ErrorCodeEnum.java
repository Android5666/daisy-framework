package com.lanhuigu.common.enums;

import lombok.Getter;

/**
 * 错误码
 *
 * @author yihonglei
 * @date 2019/11/16 1:18 PM
 */
public enum ErrorCodeEnum {
    SUCCESS(1, "success"),
    SYSTEM_DEFAULT_ERROR(0, "网络异常,请您重试!"),
    ILLEGAL_ARGUMENT_ERROR(10000, "无效参数");

    @Getter
    private int code;
    @Getter
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}