package com.wuji.demo.enums;

import lombok.Getter;


@Getter
public enum ResultCode {
    SUCCESS("0000", 1000, "success"),
    VALIDATE_FAILED("9001", 1001, "参数错误"),
    DATA_NOT_EXIST("9002", 1002, "数据不存在"),
    SAME_DATA("9003", 1003, "数据重复"),
    NO_AUTH("9004", 1004, "无权限"),
    LOCK("9005", 1005, "正在处理中（加锁失败）"),
    OTHER_SERVICE_ERROR("9006", 1006, "依赖的其他服务出现异常"),
    FAILED("9999", 1007, "系统异常"),
    EXPRESS_FUNCTION_ERROR("5001", 5001, "%s公式错误 %s！"),
    NO_AUTH_APP("9007", 1008, "无权限"),
    SHA_ERROR("9008", 1009, "SHA加密失败"),
    WX_LOGIN_ERROR("9009", 1010, "微信登录失败"),
    API_REQUEST_FAIL("9010", 1011, "接口请求失败：%s");;

    private final String code;
    private final Integer subCode;
    private final String message;

    ResultCode(String code, Integer subCode, String message) {
        this.code = code;
        this.subCode = subCode;
        this.message = message;
    }
}
