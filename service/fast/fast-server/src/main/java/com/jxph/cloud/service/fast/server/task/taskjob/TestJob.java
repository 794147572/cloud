package com.jxph.cloud.service.fast.server.task.taskjob;

import org.springframework.stereotype.Component;

/**
 * @author 谢秋豪
 * @date 2018/9/8 15:18
 */
@Component
public class TestJob implements TaskJob {
    @Override
    public void processImpl() {
        System.out.println("错误");
    }

    @Override
    public void setTaskManagerId(int id) {

    }
}
