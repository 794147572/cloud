package com.jxph.cloud.service.fast.server.task.manager;

import com.jxph.cloud.service.fast.api.pojo.TaskManagerLog;

/**
 * @author 谢秋豪
 * @date 2018/9/28 20:04
 */
public interface TaskManagerService {
    Integer createTaskManager();
    void updateTaskMangerToSuccess(Integer taskManagerId);
}
