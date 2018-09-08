package com.jxph.cloud.common.exception;

import java.io.Serializable;

/**
 * @author 谢秋豪
 * @date 2018/9/1 16:19
 */
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -8915516558804880980L;
    private String msg;
    private int code = 0500;

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
