package com.ghostkang.mail_template_server.framework.result;


/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200, "成功"),

    FAIL(500,"服务器内部错误"),

    UNAUTHORIZED(401,"认证错误"),

    NOT_FOUND(404,"资源不存在"),

    USER_EXSIT(601,"用户已存在"),

    USER_NOT_EXSIT(602,"用户不存在"),

    PASSWORD_ERROR(603,"密码错误"),

    PARAM_ERROR(604,"参数错误"),

    CODE_TIMEOUT(604,"验证码已过期"),

    CODE_ERROR(604,"验证码错误");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
