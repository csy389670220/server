package com.cfets.cms.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author chengsiyu
 * @date 2019/1/17 17:33
 * ResourceInfo对象树形结构传输类
 */
public class ResourceInfoDto {
    private BigDecimal id;

    private BigDecimal parentId;

    private String resourceType;

    private String resourceCode;

    private String resourceName;

    private String resourceDes;

    private String flag;

    private Date createTime;

    private Date updateTime;

    private List<ResourceInfoDto> children;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDes() {
        return resourceDes;
    }

    public void setResourceDes(String resourceDes) {
        this.resourceDes = resourceDes;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public List<ResourceInfoDto> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceInfoDto> children) {
        this.children = children;
    }
}