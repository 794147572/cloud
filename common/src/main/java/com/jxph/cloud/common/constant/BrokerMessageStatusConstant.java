package com.jxph.cloud.common.constant;

/**
 * @author 谢秋豪
 * @date 2018/8/30 17:57
 */
public interface BrokerMessageStatusConstant {
    int ORDER_SENDING = 0;
    int ORDER_SEND_SUCCESS = 1;
    int ORDER_SEND_FAILURE = 2;
    /**
     * min
     */
    int ORDER_TIMEOUT = 1;
}
