package com.jxph.cloud.service.fast.server.dao;

import com.jxph.cloud.service.fast.api.pojo.TaskManagerLog;
import com.jxph.cloud.service.fast.api.pojo.TaskManagerLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskManagerLogMapper {
    long countByExample(TaskManagerLogExample example);

    int deleteByExample(TaskManagerLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskManagerLog record);

    int insertSelective(TaskManagerLog record);

    List<TaskManagerLog> selectByExample(TaskManagerLogExample example);

    TaskManagerLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskManagerLog record, @Param("example") TaskManagerLogExample example);

    int updateByExample(@Param("record") TaskManagerLog record, @Param("example") TaskManagerLogExample example);

    int updateByPrimaryKeySelective(TaskManagerLog record);

    int updateByPrimaryKey(TaskManagerLog record);
}