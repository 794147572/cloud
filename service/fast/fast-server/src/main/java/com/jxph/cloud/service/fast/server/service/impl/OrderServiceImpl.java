package com.jxph.cloud.service.fast.server.service.impl;


import com.jxph.cloud.common.constant.BrokerMessageStatusConstant;
import com.jxph.cloud.common.utils.DateUtils;
import com.jxph.cloud.common.utils.JSONUtils;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLog;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLogExample;
import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.server.dao.BrokerMessageLogMapper;
import com.jxph.cloud.service.fast.server.dao.TOrderMapper;
import com.jxph.cloud.service.fast.server.mq.OrderSender;
import com.jxph.cloud.service.fast.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 谢秋豪
 * @date 2018/8/30 20:37
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TOrderMapper orderMapper;
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
    @Autowired
    private OrderSender orderSender;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void createOrder(TOrder order) {
        orderMapper.insert(order);
        Date date = new Date();
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        brokerMessageLog.setMessageId(order.getMessageId());
        brokerMessageLog.setMessage(JSONUtils.toJsonString(order));
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setNextRetry(DateUtils.addDateMinutes(date, BrokerMessageStatusConstant.ORDER_TIMEOUT));
        brokerMessageLog.setStatus(BrokerMessageStatusConstant.ORDER_SENDING);
        brokerMessageLogMapper.insertSelective(brokerMessageLog);
        orderSender.sendOrder(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void confirmMessage(String messageId) {
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        brokerMessageLog.setStatus(BrokerMessageStatusConstant.ORDER_SEND_SUCCESS);
        brokerMessageLog.setUpdateTime(new Date());
        BrokerMessageLogExample brokerMessageLogExample = new BrokerMessageLogExample();
        BrokerMessageLogExample.Criteria criteria = brokerMessageLogExample.createCriteria();
        criteria.andMessageIdEqualTo(messageId);
        brokerMessageLogMapper.updateByExampleSelective(brokerMessageLog,brokerMessageLogExample);
    }
}
