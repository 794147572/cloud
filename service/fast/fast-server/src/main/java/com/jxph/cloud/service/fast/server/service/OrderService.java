package com.jxph.cloud.service.fast.server.service;


import com.jxph.cloud.service.fast.api.pojo.TOrder;

/**
 * @author 谢秋豪
 * @date 2018/8/30 20:36
 */
public interface OrderService {
    void createOrder(TOrder order);

    void confirmMessage(String messageId);
}
