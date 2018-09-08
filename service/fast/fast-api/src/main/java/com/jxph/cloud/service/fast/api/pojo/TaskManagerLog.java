package com.jxph.cloud.service.fast.api.pojo;

import java.util.Date;

public class TaskManagerLog {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String operatorAddress;

    private String taskJobId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperatorAddress() {
        return operatorAddress;
    }

    public void setOperatorAddress(String operatorAddress) {
        this.operatorAddress = operatorAddress == null ? null : operatorAddress.trim();
    }

    public String getTaskJobId() {
        return taskJobId;
    }

    public void setTaskJobId(String taskJobId) {
        this.taskJobId = taskJobId == null ? null : taskJobId.trim();
    }
}