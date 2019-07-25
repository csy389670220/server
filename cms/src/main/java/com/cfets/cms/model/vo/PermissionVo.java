package com.cfets.cms.model.vo;

import com.cfets.cms.model.Permission;

import java.util.List;

public class PermissionVo  extends Permission {
    private List<PermissionVo> childPer;

    private int check ;//是否被选中，0-否 1-是

    public List<PermissionVo> getChildPer() {
        return childPer;
    }

    public void setChildPer(List<PermissionVo> childPer) {
        this.childPer = childPer;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}