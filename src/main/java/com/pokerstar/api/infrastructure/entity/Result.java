package com.pokerstar.api.infrastructure.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 7017239650564895681L;

    private Boolean status;

    private int code;

    private String msg;

    private T data;

    public static Result success() {
        Result result = new Result();
        result.code = 0;
        result.status = true;
        result.msg = null;
        result.data = null;
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.code = 0;
        result.status = true;
        result.msg = null;
        result.data = data;
        return result;
    }

    public static Result fail(int code) {
        Result result = new Result();
        result.code = code;
        result.status = true;
        result.msg = null;
        result.data = null;
        return result;
    }

    public static Result fail(int code, String msg) {
        Result result = new Result();
        result.code = code;
        result.status = true;
        result.msg = msg;
        result.data = null;
        return result;
    }
}
