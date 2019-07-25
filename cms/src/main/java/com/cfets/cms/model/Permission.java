package com.cfets.cms.model;

import java.util.Date;

public class Permission {
    private Integer id;

    private Integer parentId;

    private String perCode;

    private String perDesc;

    private Date createTime;

    private Integer perLev;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode == null ? null : perCode.trim();
    }

    public String getPerDesc() {
        return perDesc;
    }

    public void setPerDesc(String perDesc) {
        this.perDesc = perDesc == null ? null : perDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPerLev() {
        return perLev;
    }

    public void setPerLev(Integer perLev) {
        this.perLev = perLev;
    }
}