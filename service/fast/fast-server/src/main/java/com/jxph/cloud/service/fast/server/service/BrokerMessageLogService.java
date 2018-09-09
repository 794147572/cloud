package com.jxph.cloud.service.fast.server.service;

import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLog;

import java.util.List;

/**
 * @author 谢秋豪
 * @date 2018/9/8 23:28
 */
public interface BrokerMessageLogService {
    List<BrokerMessageLog> selectSendMessage();

    void updateBrokerMessageLogTryCount(BrokerMessageLog brokerMessageLog);

    void updateBrokerMessageLogStatusToFail(BrokerMessageLog brokerMessageLog);
}
