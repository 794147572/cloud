package com.jxph.cloud.common.utils;


import com.jxph.cloud.common.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * @author 谢秋豪
 * @date 2018/9/1 14:38
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -3796886832705747283L;
    private int status;
    private String msg;
    private T data;

    public ResponseResult() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public ResponseResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult ok() {
        return ok(null);
    }

    public static <T> ResponseResult ok(T data) {
        return new ResponseResult<T>(ResultCodeEnum.SUCCESS.getCode(), null, data);
    }

    public static <T> ResponseResult error(String msg, T data) {
        return new ResponseResult<T>(ResultCodeEnum.FAILURE.getCode(), msg, data);
    }

    public static <T> ResponseResult error(String msg) {
        return error(msg, null);
    }
}