package com.jxph.cloud.service.fast.server.task;

import com.jxph.cloud.service.auth.client.runner.DistributedLock;
import com.jxph.cloud.service.fast.server.common.constant.RedisKeyConstant;
import com.jxph.cloud.service.fast.server.config.datasource.DataSourceConstant;
import com.jxph.cloud.service.fast.server.config.datasource.annotation.DataSource;
import com.jxph.cloud.service.fast.server.task.taskManager.DefaultManagerTask;
import com.jxph.cloud.service.fast.server.task.taskjob.CouponJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    private CouponJob couponJob;
    @Autowired
    private DefaultManagerTask managerTask;

    @Scheduled(cron = "0 */1 * * * ?")
    @DataSource(DataSourceConstant.DATASOURCE_NAME_SECOND)
    public void couponJob(){
        Boolean tryLock = distributedLock.tryLock(RedisKeyConstant.COUPON_JOB_KEY,5000);
        if (tryLock) {
            log.info("本机拿到锁，执行job任务");
            managerTask.setTaskJob(couponJob);
            managerTask.process();
        }
    }
}
