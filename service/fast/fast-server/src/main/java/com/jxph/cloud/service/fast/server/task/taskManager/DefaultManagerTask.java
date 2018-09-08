package com.jxph.cloud.service.fast.server.task.taskManager;

import com.jxph.cloud.service.auth.client.runner.IpConfig;
import com.jxph.cloud.service.fast.api.pojo.TaskManagerLog;
import com.jxph.cloud.service.fast.server.common.constant.TaskManagerLogStatusConstant;
import com.jxph.cloud.service.fast.server.dao.TaskManagerLogMapper;
import com.jxph.cloud.service.fast.server.task.taskjob.TaskJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 谢秋豪
 * @date 2018/9/1 20:16
 */
@Slf4j
@Component
public class DefaultManagerTask extends AbstractManagerTask {
    @Autowired
    private IpConfig ipConfig;

    @Autowired
    private TaskManagerLogMapper taskManagerLogMapper;

    private int taskManagerId;

    public DefaultManagerTask(TaskJob taskJob) {
        super(taskJob);
    }

    public int getTaskManagerId() {
        return taskManagerId;
    }

    private void setTaskManagerId(int taskManagerId) {
        this.taskManagerId = taskManagerId;
    }


    @Override
    public void initializeManager() {
        TaskManagerLog taskManagerLog = newDefaultTaskManagerLog();
        taskManagerLogMapper.insertSelective(taskManagerLog);
        setTaskManagerId(taskManagerLog.getId());
        getTaskJob().setTaskManagerId(taskManagerLog.getId());
    }

    @Override
    public void endTaskManager() {
        taskManagerLogMapper.updateByPrimaryKeySelective(updateDefaultTaskManagerLog());
    }

    private TaskManagerLog newDefaultTaskManagerLog() {
        TaskManagerLog taskManagerLog = new TaskManagerLog();
        taskManagerLog.setStatus(TaskManagerLogStatusConstant.TASK_MANAGER_START);
        taskManagerLog.setCreateTime(new Date());
        taskManagerLog.setUpdateTime(new Date());
        taskManagerLog.setOperatorAddress(ipConfig.getHostIp() + ":" + ipConfig.getPort());
        return taskManagerLog;
    }

    private TaskManagerLog updateDefaultTaskManagerLog() {
        TaskManagerLog taskManagerLog = new TaskManagerLog();
        taskManagerLog.setId(getTaskManagerId());
        taskManagerLog.setStatus(TaskManagerLogStatusConstant.TASK_MANAGER_SUCCESS);
        taskManagerLog.setUpdateTime(new Date());
        return taskManagerLog;
    }
}
