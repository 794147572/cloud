package com.jxph.cloud.service.fast.server.task.manager;

/**
 * @author 谢秋豪
 * @date 2018/9/2 20:30
 */
public interface TaskManagerFactory extends TaskFactory  {
    void initializeManager();
    void endTaskManager();
}
