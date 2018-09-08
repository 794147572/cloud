package com.jxph.cloud.service.fast.server.task.taskManager;

import com.jxph.cloud.service.fast.server.task.taskjob.TaskJob;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 谢秋豪
 * @date 2018/9/1 19:55
 */
@Slf4j
public abstract class AbstractManagerTask implements TaskManagerFactory  {
    private TaskJob taskJob;

    public TaskJob getTaskJob() {
        return taskJob;
    }

    public void setTaskJob(TaskJob taskJob) {
        this.taskJob = taskJob;
    }

    public AbstractManagerTask(TaskJob taskJob) {
        this.taskJob = taskJob;
    }

    @Override
    public void initializeManager(){
        log.info("-----定时任务开始------");
    }

    @Override
    public void process(){
        initializeManager();
        taskJob.processImpl();
        endTaskManager();
    }

    @Override
    public void endTaskManager(){
        log.info("-----定时任务结束------");
    }
}
