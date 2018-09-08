package com.jxph.cloud.service.fast.server.task.taskjob;

import com.jxph.cloud.service.fast.api.pojo.CouponTaskJob;
import com.jxph.cloud.service.fast.api.pojo.CouponTaskJobExample;
import com.jxph.cloud.service.fast.server.common.constant.CouponTaskJobStatusConstant;
import com.jxph.cloud.service.fast.server.dao.CouponTaskJobMapper;
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
@Scope("prototype")
public class CouponJob implements TaskJob {
    @Autowired
    private CouponTaskJobMapper couponTaskJobMapper;
    @Autowired
    @Qualifier("myTaskExecutePool")
    private Executor taskExecutePool;

    private int couponThreadCounts = 10;

    private int taskManagerId;

    @Override
    public void processImpl() {
        List<CouponTaskJob> list = selectCreationCouponJob();
        int len = list.size() / couponThreadCounts;
        if (len == 0) {
            taskExecutePool.execute(new CouponThread(list));
        } else {
            for (int i = 0; i < couponThreadCounts; i++) {
                List<CouponTaskJob> subList = list.subList(i * len, len * (i + 1) > list.size() ? list.size() : len * (i + 1));
                taskExecutePool.execute(new CouponThread(subList));
            }
        }
    }

    @Override
    public void setTaskManagerId(int id) {
        this.taskManagerId = id;
    }

    private List<CouponTaskJob> selectCreationCouponJob() {
        CouponTaskJobExample example = new CouponTaskJobExample();
        CouponTaskJobExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(CouponTaskJobStatusConstant.JOB_CREATION);
        example.setOrderByClause("create_time");
        example.setLimit(100);
        example.setOffset(0);
        return couponTaskJobMapper.selectByExample(example);
    }

    class CouponThread extends Thread {
        private List<CouponTaskJob> couponTaskJobs;

        public CouponThread(List<CouponTaskJob> couponTaskJobs) {
            this.couponTaskJobs = couponTaskJobs;
        }

        @Override
        public void run() {
            couponTaskJobs.forEach(couponTaskJob -> {
                couponTaskJob.setTaskManagerId(taskManagerId);
                updateCouponTask(couponTaskJob, CouponTaskJobStatusConstant.JOB_EXECUTION);
                try {
                    //业务处理
                    updateCouponTask(couponTaskJob, CouponTaskJobStatusConstant.JOB_SUCCESS);
                } catch (Exception e) {
                    updateCouponTask(couponTaskJob, CouponTaskJobStatusConstant.JOB_FAILURE, e.toString());
                }
            });
        }

        private void updateCouponTask(CouponTaskJob couponTaskJob, int status) {
            updateCouponTask(couponTaskJob, status, null);
        }

        private void updateCouponTask(CouponTaskJob couponTaskJob, int status, String remark) {
            couponTaskJob.setStatus(status);
            couponTaskJob.setUpdateTime(new Date());
            if (remark != null) {
                couponTaskJob.setRemark(remark);
            }
            couponTaskJobMapper.updateByPrimaryKeySelective(couponTaskJob);
        }
    }
}
