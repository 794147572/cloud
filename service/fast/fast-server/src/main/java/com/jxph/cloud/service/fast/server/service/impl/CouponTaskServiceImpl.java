package com.jxph.cloud.service.fast.server.service.impl;

import com.jxph.cloud.service.fast.api.pojo.CouponTaskJob;
import com.jxph.cloud.service.fast.api.pojo.CouponTaskJobExample;
import com.jxph.cloud.service.fast.server.common.constant.CouponTaskJobStatusConstant;
import com.jxph.cloud.service.fast.server.dao.CouponTaskJobMapper;
import com.jxph.cloud.service.fast.server.service.CouponTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 谢秋豪
 * @date 2018/9/8 16:07
 */
@Service
public class CouponTaskServiceImpl implements CouponTaskService {
    @Autowired
    private CouponTaskJobMapper couponTaskJobMapper;

    @Override
    public List<CouponTaskJob> selectCreationCouponJob() {
        CouponTaskJobExample example = new CouponTaskJobExample();
        CouponTaskJobExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(CouponTaskJobStatusConstant.JOB_CREATION);
        example.setOrderByClause("create_time");
        example.setLimit(100);
        example.setOffset(0);
        return couponTaskJobMapper.selectByExample(example);
    }

    @Override
    public void updateCouponTask(CouponTaskJob couponTaskJob, int status) {
        updateCouponTask(couponTaskJob, status, null);
    }

    @Override
    public void updateCouponTask(CouponTaskJob couponTaskJob, int status, String remark) {
        couponTaskJob.setStatus(status);
        couponTaskJob.setUpdateTime(new Date());
        if (remark != null) {
            couponTaskJob.setRemark(remark);
        }
        couponTaskJobMapper.updateByPrimaryKeySelective(couponTaskJob);
    }


}
