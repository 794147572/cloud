package com.jxph.cloud.service.fast.api.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "订单")
public class TOrder implements Serializable {
    private static final long serialVersionUID = 6694440593947361863L;
    @ApiModelProperty(value = "订单编号")
    private String id;

    @ApiModelProperty(value = "订单内容")
    private String name;

    @ApiModelProperty(value = "消息编号")
    private String messageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }
}