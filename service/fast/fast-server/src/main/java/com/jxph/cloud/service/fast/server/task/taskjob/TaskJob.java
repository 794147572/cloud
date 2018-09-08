package com.jxph.cloud.service.fast.server.task.taskjob;

/**
 * @author 谢秋豪
 * @date 2018/9/1 20:03
 */
public interface TaskJob {
    void processImpl();
    void setTaskManagerId(int id);
}
