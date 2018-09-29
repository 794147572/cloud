package com.jxph.cloud.service.fast.server.task.manager;

import com.jxph.cloud.service.fast.server.service.TaskManagerService;
import com.jxph.cloud.service.fast.server.task.job.TaskJob;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 谢秋豪
 * @date 2018/9/1 20:16
 */
@Slf4j
public class DefaultManagerTask extends AbstractManagerTask<TaskJob> {
    public DefaultManagerTask(TaskJob taskJob) {
        super(taskJob);
    }

    @Override
    public void initializeManager() {
        log.info("-----定时任务开始------");
    }

    @Override
    public void endTaskManager() {
        log.info("-----定时任务结束------");
    }

}
