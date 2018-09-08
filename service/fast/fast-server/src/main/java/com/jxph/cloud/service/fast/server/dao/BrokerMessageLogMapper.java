package com.jxph.cloud.service.fast.server.dao;

import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLog;
import com.jxph.cloud.service.fast.api.pojo.BrokerMessageLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrokerMessageLogMapper {
    long countByExample(BrokerMessageLogExample example);

    int deleteByExample(BrokerMessageLogExample example);

    int deleteByPrimaryKey(String messageId);

    int insert(BrokerMessageLog record);

    int insertSelective(BrokerMessageLog record);

    List<BrokerMessageLog> selectByExample(BrokerMessageLogExample example);

    BrokerMessageLog selectByPrimaryKey(String messageId);

    int updateByExampleSelective(@Param("record") BrokerMessageLog record, @Param("example") BrokerMessageLogExample example);

    int updateByExample(@Param("record") BrokerMessageLog record, @Param("example") BrokerMessageLogExample example);

    int updateByPrimaryKeySelective(BrokerMessageLog record);

    int updateByPrimaryKey(BrokerMessageLog record);
}