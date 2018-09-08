package com.jxph.cloud.common.enums;

/**
 * @author 谢秋豪
 * @date 2018/9/1 14:50
 */
public enum ResultCodeEnum {
    SUCCESS(200),
    FAILURE(500),
    // -------------------失败状态码----------------------
    // 参数错误
    // 参数为空
    PARAMS_IS_NULL(10001),
    // 参数不全
    PARAMS_NOT_COMPLETE(10002),
    // 参数类型错误
    PARAMS_TYPE_ERROR(10003),
    // 参数无效
    PARAMS_IS_INVALID(10004),
    // 系统业务出现问题
    BUSINESS_ERROR(30001),
    //--------- 数据错误----------
    // 数据未找到
    DATA_NOT_FOUND(50001),
    // 数据有误
    DATA_IS_WRONG(50002),
    // 数据已存在
    DATA_ALREADY_EXISTED(50003);
    private int code;

    ResultCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}