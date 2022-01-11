package com.makunpeng.matrix.interfaces.post.api;

import org.springframework.http.HttpStatus;

/**
 * API调用结果状态
 *
 * @author Aaron Ma
 * @since 1.0
 */
public enum ApiResultStatus {
    SUCCESS("10000", "success", null, null),

    ERROR("20000", "服务不可用", null, null),

    AUTH_INVALID("20001", "授权权限不足", null, null),

    FAILED("40004", "业务处理失败", null, null);

    public String getCode() {
        return code;
    }

    public String getSub_code() {
        return sub_code;
    }

    public String getMsg() {
        return msg;
    }

    public String getSub_msg() {
        return sub_msg;
    }

    /**
     * 获取对应的 HTTP 状态码
     * @return HTTP 状态码
     */
    public HttpStatus httpStatus() {
        char flag = this.code.charAt(0);
        if (flag == '1') {
            return HttpStatus.OK;
        }
        if (flag == '2') {
            return HttpStatus.BAD_REQUEST;
        }
        if (flag == '4') {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.OK;
    }

    private final String code;
    private final String sub_code;
    private final String msg;
    private final String sub_msg;

    ApiResultStatus(String code, String msg, String sub_code, String sub_msg) {
        this.code = code;
        this.msg = msg;
        this.sub_code = sub_code;
        this.sub_msg = sub_msg;
    }
}
