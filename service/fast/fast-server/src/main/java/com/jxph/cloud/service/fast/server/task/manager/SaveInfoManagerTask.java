package com.jxph.cloud.service.fast.server.task.manager;

import com.jxph.cloud.service.fast.server.service.TaskManagerService;
import com.jxph.cloud.service.fast.server.task.job.TaskSaveManagerInfoJob;

/**
 * @author xqh
 * @date 2018/9/29 23:59
 */
public class SaveInfoManagerTask extends AbstractManagerTask<TaskSaveManagerInfoJob> {
    private int taskManagerId;
    private TaskManagerService taskManagerService;

    public SaveInfoManagerTask(TaskSaveManagerInfoJob taskJob, TaskManagerService taskManagerService) {
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
