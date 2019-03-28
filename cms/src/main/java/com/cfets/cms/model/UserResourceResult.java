package com.cfets.cms.model;


import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chengsiyu
 * @date 2019/1/24 17:33
 * 用户对应资源信息详细类
 */
public class UserResourceResult {
    private BigDecimal id;

    private BigDecimal userId;

    private BigDecimal resourceId;

    private BigDecimal createUserId;

    private Date createTime;

    private ResourceInfo resourceInfo;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public BigDecimal getResourceId() {
        return resourceId;
    }

    public void setResourceId(BigDecimal resourceId) {
        this.resourceId = resourceId;
    }

    public BigDecimal getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(BigDecimal createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ResourceInfo getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }
}
