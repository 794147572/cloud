package com.jxph.cloud.service.fast.api.pojo;

import java.util.Date;

public class CouponTaskJob {
    private Integer id;

    private Integer status;

    private Integer operaorUserId;

    private Date createTime;

    private Date updateTime;

    private String application;

    private String couponCondition;

    private String remark;

    private Integer taskManagerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperaorUserId() {
        return operaorUserId;
    }

    public void setOperaorUserId(Integer operaorUserId) {
        this.operaorUserId = operaorUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getCouponCondition() {
        return couponCondition;
    }

    public void setCouponCondition(String couponCondition) {
        this.couponCondition = couponCondition == null ? null : couponCondition.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getTaskManagerId() {
        return taskManagerId;
    }

    public void setTaskManagerId(Integer taskManagerId) {
        this.taskManagerId = taskManagerId;
    }
}