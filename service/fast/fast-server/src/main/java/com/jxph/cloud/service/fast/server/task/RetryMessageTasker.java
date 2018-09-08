package com.jxph.cloud.service.fast.server.task;

import com.jxph.cloud.common.constant.BrokerMessageStatusConstant;
import com.jxph.cloud.common.constant.BrokerMessageTryCountConstant;
import com.jxph.cloud.common.utils.JSONUtils;
import com.jxph.cloud.service.auth.client.runner.DistributedLock;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLog;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLogExample;
import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.server.common.constant.RedisKeyConstant;
import com.jxph.cloud.service.fast.server.dao.BrokerMessageLogMapper;
import com.jxph.cloud.service.fast.server.mq.OrderSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * @author 谢秋豪
 * @date 2018/8/30 21:09
 */
@Component
@Slf4j
public class RetryMessageTasker {
    @Autowired
    private OrderSender orderSender;
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
    @Autowired
    private DistributedLock distributedLock;

    @Scheduled(cron = "0/15 * * * * ?")
    public void reSend() {
        Boolean tryLock = distributedLock.tryLock(RedisKeyConstant.RETRY_MESSAGE_KEY,5000);
        if (tryLock) {
            log.info("本机拿到锁，执行reSend任务");
            reSendJobs();
        }
    }

    private void reSendJobs() {
        BrokerMessageLogExample brokerMessageLogExample = new BrokerMessageLogExample();
        BrokerMessageLogExample.Criteria criteria = brokerMessageLogExample.createCriteria();
        criteria.andStatusEqualTo(BrokerMessageStatusConstant.ORDER_SENDING);
        criteria.andNextRetryGreaterThan(new Date());
        List<BrokerMessageLog> list = brokerMessageLogMapper.selectByExample(brokerMessageLogExample);
        list.forEach(messageLog -> {
            BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
            brokerMessageLog.setUpdateTime(new Date());
            if (messageLog.getTryCount() >= BrokerMessageTryCountConstant.TRYCOUNT_MAX_LIMIT) {
                brokerMessageLog.setStatus(BrokerMessageStatusConstant.ORDER_SEND_FAILURE);
                brokerMessageLog.setMessageId(messageLog.getMessageId());
                brokerMessageLogMapper.updateByPrimaryKeySelective(brokerMessageLog);
                //解决方案
            } else {
                messageLog.setTryCount(messageLog.getTryCount() + 1);
                brokerMessageLogMapper.updateByPrimaryKey(messageLog);
                TOrder order = JSONUtils.parse(messageLog.getMessage(), TOrder.class);
                try {
                    orderSender.sendOrder(order);
                } catch (Exception e) {
                    log.info("send error");
                }
            }
        });
    }
}
