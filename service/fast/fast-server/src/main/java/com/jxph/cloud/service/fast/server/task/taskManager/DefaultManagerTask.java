package com.jxph.cloud.service.fast.server.task.taskManager;

import com.jxph.cloud.service.fast.server.service.TaskManagerService;
import com.jxph.cloud.service.fast.server.task.taskjob.TaskJob;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author 谢秋豪
 * @date 2018/9/1 20:16
 */
@Slf4j
public class DefaultManagerTask extends AbstractManagerTask {
    private int taskManagerId;
    private TaskManagerService taskManagerService;

    public DefaultManagerTask(TaskJob taskJob,TaskManagerService taskManagerService) {
        super(taskJob);
        this.taskManagerService = taskManagerService;
    }

    public int getTaskManagerId() {
        return taskManagerId;
    }

    private void setTaskManagerId(int taskManagerId) {
        this.taskManagerId = taskManagerId;
    }


    @Override
    public void initializeManager() {
        Integer taskManagerId = taskManagerService.createTaskManager();
        setTaskManagerId(taskManagerId);
        getTaskJob().setTaskManagerId(taskManagerId);
    }

    @Override
    public void endTaskManager() {
        taskManagerService.updateTaskMangerToSuccess(getTaskManagerId());
    }
}
