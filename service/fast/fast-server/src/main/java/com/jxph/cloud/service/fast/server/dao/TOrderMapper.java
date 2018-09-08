package com.jxph.cloud.service.fast.server.dao;

import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.api.pojo.TOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrderMapper {
    long countByExample(TOrderExample example);

    int deleteByExample(TOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    List<TOrder> selectByExample(TOrderExample example);

    TOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}