package com.jxph.cloud.service.fast.server.task;

import com.jxph.cloud.service.auth.client.runner.DistributedLock;
import com.jxph.cloud.service.fast.server.common.constant.RedisKeyConstant;
import com.jxph.cloud.service.fast.server.config.datasource.DataSourceConstant;
import com.jxph.cloud.service.fast.server.config.datasource.annotation.DataSource;
import com.jxph.cloud.service.fast.server.service.CouponTaskService;
import com.jxph.cloud.service.fast.server.service.TaskManagerService;
import com.jxph.cloud.service.fast.server.task.taskManager.DefaultManagerTask;
import com.jxph.cloud.service.fast.server.task.taskjob.CouponJob;
import com.jxph.cloud.service.fast.server.task.taskjob.TaskJob;
import com.jxph.cloud.service.fast.server.task.taskjob.TestJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @author 谢秋豪
 * @date 2018/9/2 21:48
 */
@Slf4j
@Component
public class CouponTask {
    @Autowired
    private DistributedLock distributedLock;
    @Autowired
    private TestJob testJob;
    @Autowired
    private TaskManagerService taskManagerService;
    @Autowired
    private CouponJob couponJob;

    @Scheduled(cron = "0 */1 * * * ?")
    @DataSource(DataSourceConstant.DATASOURCE_NAME_SECOND)
    public void couponJob(){
        Boolean tryLock = distributedLock.tryLock(RedisKeyConstant.COUPON_JOB_KEY,5000);
        if (tryLock) {
            log.info("本机拿到锁，执行job任务");
            DefaultManagerTask managerTask = new DefaultManagerTask(couponJob, taskManagerService);
            managerTask.process();
        }
    }
}
