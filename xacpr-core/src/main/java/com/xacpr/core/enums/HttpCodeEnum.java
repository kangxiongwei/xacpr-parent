package com.xacpr.core.enums;

/**
 * Create by kangxiongwei on 2018/11/24 下午1:28
 */
public enum HttpCodeEnum {

    SUCCESS(200, "请求成功"),
    ERROR(500, "请求失败");

    private Integer code;
    private String message;

    HttpCodeEnum(Integer code, String message) {
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

    @Override
    public String toString() {
        return "HttpCodeEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                "} " + super.toString();
    }
}
