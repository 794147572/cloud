package com.jxph.cloud.service.fast.server.task.taskjob;

import com.jxph.cloud.service.fast.api.pojo.CouponTaskJob;
import com.jxph.cloud.service.fast.api.pojo.CouponTaskJobExample;
import com.jxph.cloud.service.fast.server.common.constant.CouponTaskJobStatusConstant;
import com.jxph.cloud.service.fast.server.config.datasource.DataSourceContextHolder;
import com.jxph.cloud.service.fast.server.dao.CouponTaskJobMapper;
import com.jxph.cloud.service.fast.server.service.CouponTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author 谢秋豪
 * @date 2018/9/2 21:58
 */
@Component
public class CouponJob implements TaskJob {
    @Autowired
    private CouponTaskService couponTaskService;
    @Autowired
    @Qualifier("myTaskExecutePool")
    private Executor taskExecutePool;

    private int couponThreadCounts = 10;

    private int taskManagerId;

    @Override
    public void processImpl() {
        List<CouponTaskJob> list = couponTaskService.selectCreationCouponJob();
        int len = list.size() / couponThreadCounts;
        String dataSource = DataSourceContextHolder.getDataSource();
        if (len == 0) {
            taskExecutePool.execute(new CouponThread(list,dataSource));
        } else {
            for (int i = 0; i < couponThreadCounts; i++) {
                List<CouponTaskJob> subList = list.subList(i * len, len * (i + 1) > list.size() ? list.size() : len * (i + 1));
                taskExecutePool.execute(new CouponThread(subList,dataSource));
            }
        }
    }

    @Override
    public void setTaskManagerId(int id) {
        this.taskManagerId = id;
    }

    class CouponThread extends Thread {
        private List<CouponTaskJob> couponTaskJobs;
        private String dataSource;

        public CouponThread(List<CouponTaskJob> couponTaskJobs,String dataSource) {
            this.couponTaskJobs = couponTaskJobs;
            this.dataSource = dataSource;
        }

        @Override
        public void run() {
            DataSourceContextHolder.setDataSource(dataSource);
            couponTaskJobs.forEach(couponTaskJob -> {
                couponTaskJob.setTaskManagerId(taskManagerId);
                couponTaskService.updateCouponTask(couponTaskJob, CouponTaskJobStatusConstant.JOB_EXECUTION);
                try {
                    //业务处理
                    couponTaskService.updateCouponTask(couponTaskJob, CouponTaskJobStatusConstant.JOB_SUCCESS);
                } catch (Exception e) {
                    couponTaskService.updateCouponTask(couponTaskJob, CouponTaskJobStatusConstant.JOB_FAILURE, e.toString());
                }
            });
        }

    }
}
