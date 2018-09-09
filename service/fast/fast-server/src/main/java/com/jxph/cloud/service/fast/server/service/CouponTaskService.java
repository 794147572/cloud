package com.jxph.cloud.service.fast.server.service;

import com.jxph.cloud.service.fast.api.pojo.CouponTaskJob;

import java.util.List;

/**
 * @author 谢秋豪
 * @date 2018/9/8 16:05
 */
public interface CouponTaskService {
    /**
     * 查找状态为已创建的couponJob
     */
    List<CouponTaskJob> selectCreationCouponJob();

    void updateCouponTask(CouponTaskJob couponTaskJob, int status);

    void updateCouponTask(CouponTaskJob couponTaskJob, int status, String remark);

}
