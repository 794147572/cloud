package com.jxph.cloud.service.fast.server.task.manager;

import com.jxph.cloud.service.fast.server.task.job.TaskJob;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 谢秋豪
 * @date 2018/9/1 19:55
 */
@Slf4j
public abstract class AbstractManagerTask<T extends TaskJob> implements TaskManagerFactory  {
    private T taskJob;

    public T getTaskJob() {
        return taskJob;
    }

    public void setTaskJob(T taskJob) {
        this.taskJob = taskJob;
    }

    public AbstractManagerTask(T taskJob) {
        this.taskJob = taskJob;
    }

    @Override
    public void process(){
        initializeManager();
        taskJob.processImpl();
        endTaskManager();
    }
}
