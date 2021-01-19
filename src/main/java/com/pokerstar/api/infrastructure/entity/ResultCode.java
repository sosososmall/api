package com.pokerstar.api.infrastructure.entity;

public enum ResultCode {
    SUCCESS(0, "成功"),
    /*
    * 1xxxxx 段为系统类
    * */
    UNKNOW_ERROR(10001, "未知错误!"),
    /*
    * 2xxxx 段为用户类
    * */
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_ALREADY_EXIST(20002, "用户已存在"),
    /*
     * 3xxxx 段为管理员类
     * 30XXX 为管理
     * 31XXX 为代理
     * */
    MANAGER_NOT_EXIST(30001, "管理员不存在"),
    MANAGER_ALREADY_EXIST(30002, "管理员已存在"),

    AGENT_NOT_EXIST(31001, "代理不存在"),
    AGENT_ALREADY_EXIST(31002, "代理已存在"),
    /*
     * 4xxxx 段为支付类
     * */
    /*
     * 5xxxx 段为统计类
     * */
    ;

    private int code;

    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
