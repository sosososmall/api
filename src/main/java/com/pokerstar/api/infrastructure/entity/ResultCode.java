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
    GET_CHANNEL_ERROR(40001, "获取支付通道失败"),
    ADD_CHANNEL_ERROR(40002, "新增支付通道失败"),
    DELETE_CHANNEL_ERROR(40003, "删除支付通道失败"),
    ENABLE_CHANNEL_ERROR(40004, "禁用支付通道失败"),
    UPDATE_CHANNEL_RATE_ERROR(40005, "修改支付通道费用信息失败"),

    MERCHANT_NOT_EXIST(41001,"商户不存在"),
    CHANNEL_MERCHANT_ENABLED(41002,"商户渠道未开通"),
    CHANNEL_MERCHANT_DEPOSIT_NOT_EXIST(41003,"支付类型不存在"),
    CHANNEL_MERCHANT_DEPOSIT_ENABLED(41004,"支付通道未开通"),
    LOWER_THAN_MINIMUM_AMOUNT(41005,"金额不能低于通道最低限制"),
    HIGHER_THAN_MAXIMUM_AMOUNT(41006,"金额不能高于通道最高限制"),
    ORDER_ALREADY_EXIST(41007,"订单已存在"),
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
