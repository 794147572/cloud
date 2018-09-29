package com.jxph.cloud.service.fast.server.task.job;

import com.jxph.cloud.common.constant.BrokerMessageTryCountConstant;
import com.jxph.cloud.common.utils.JSONUtils;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLog;
import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.server.mq.OrderSender;
import com.jxph.cloud.service.fast.server.service.BrokerMessageLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xqh
 * @date 2018/9/30 0:20
 */
@Component
@Slf4j
public class RetryMessageJob implements TaskJob {
    @Autowired
    private OrderSender orderSender;
    @Autowired
    private BrokerMessageLogService brokerMessageLogService;

    @Override
    public void processImpl() {
        List<BrokerMessageLog> list = brokerMessageLogService.selectSendMessage();
        list.forEach(messageLog -> {
            if (messageLog.getTryCount() >= BrokerMessageTryCountConstant.TRYCOUNT_MAX_LIMIT) {
                brokerMessageLogService.updateBrokerMessageLogStatusToFail(messageLog);
                //解决方案
            } else {
                brokerMessageLogService.updateBrokerMessageLogTryCount(messageLog);
                TOrder order = JSONUtils.parse(messageLog.getMessage(), TOrder.class);
                try {
                    orderSender.sendOrder(order);
                } catch (Exception e) {
                    log.error("send error");
                }
            }
        });
    }
}
