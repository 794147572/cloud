package com.jxph.cloud.service.fast.server.service.impl;

import com.jxph.cloud.service.auth.client.runner.IpConfig;
import com.jxph.cloud.service.fast.api.pojo.TaskManagerLog;
import com.jxph.cloud.service.fast.server.common.constant.TaskManagerLogStatusConstant;
import com.jxph.cloud.service.fast.server.dao.TaskManagerLogMapper;
import com.jxph.cloud.service.fast.server.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 谢秋豪
 * @date 2018/9/8 15:55
 */
@Service
public class TaskManagerServiceImpl implements TaskManagerService {
    @Autowired
    private IpConfig ipConfig;
    @Autowired
    private TaskManagerLogMapper taskManagerLogMapper;

    @Override
    public Integer createTaskManager() {
        TaskManagerLog taskManagerLog = new TaskManagerLog();
        taskManagerLog.setStatus(TaskManagerLogStatusConstant.TASK_MANAGER_START);
        taskManagerLog.setCreateTime(new Date());
        taskManagerLog.setUpdateTime(new Date());
        taskManagerLog.setOperatorAddress(ipConfig.getHostIp() + ":" + ipConfig.getPort());
        taskManagerLogMapper.insertSelective(taskManagerLog);
        return taskManagerLog.getId();
    }

    @Override
    public TaskManagerLog updateTaskMangerToSuccess(Integer taskManagerId) {
        TaskManagerLog taskManagerLog = new TaskManagerLog();
        taskManagerLog.setId(taskManagerId);
        taskManagerLog.setStatus(TaskManagerLogStatusConstant.TASK_MANAGER_SUCCESS);
        taskManagerLog.setUpdateTime(new Date());
        taskManagerLogMapper.updateByPrimaryKeySelective(taskManagerLog);
        return taskManagerLog;
    }

}
