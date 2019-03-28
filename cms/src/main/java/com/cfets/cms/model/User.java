package com.cfets.cms.model;

import java.io.Serializable;

/**
 * 系统用户信息表
 */
public class User implements Serializable {
    private  String uid;
    private  String userName;
    private  String passWord;
    private  String creatTime;
    private  String updateTime;

    public User() {
    }
    public User(String uid, String userName, String passWord, String creatTime, String updateTime) {
        this.uid = uid;
        this.userName = userName;
        this.passWord = passWord;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
