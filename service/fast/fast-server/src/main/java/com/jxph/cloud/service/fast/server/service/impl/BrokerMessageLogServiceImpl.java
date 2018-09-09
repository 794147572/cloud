package com.jxph.cloud.service.fast.server.service.impl;

import com.jxph.cloud.common.constant.BrokerMessageStatusConstant;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLog;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLogExample;
import com.jxph.cloud.service.fast.server.dao.BrokerMessageLogMapper;
import com.jxph.cloud.service.fast.server.service.BrokerMessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 谢秋豪
 * @date 2018/9/8 23:29
 */
@Service
public class BrokerMessageLogServiceImpl implements BrokerMessageLogService {
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
    @Override
    public List<BrokerMessageLog> selectSendMessage() {
        BrokerMessageLogExample brokerMessageLogExample = new BrokerMessageLogExample();
        BrokerMessageLogExample.Criteria criteria = brokerMessageLogExample.createCriteria();
        criteria.andStatusEqualTo(BrokerMessageStatusConstant.ORDER_SENDING);
        criteria.andNextRetryGreaterThan(new Date());
        List<BrokerMessageLog> brokerMessageLogs = brokerMessageLogMapper.selectByExample(brokerMessageLogExample);
        return brokerMessageLogs;
    }

    @Override
    public void updateBrokerMessageLogTryCount(BrokerMessageLog brokerMessageLog) {
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLog.setTryCount(brokerMessageLog.getTryCount()+1);
        brokerMessageLogMapper.updateByPrimaryKeySelective(brokerMessageLog);
    }

    @Override
    public void updateBrokerMessageLogStatusToFail(BrokerMessageLog brokerMessageLog) {
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLog.setStatus(BrokerMessageStatusConstant.ORDER_SEND_FAILURE);
        brokerMessageLogMapper.updateByPrimaryKeySelective(brokerMessageLog);
    }
}
