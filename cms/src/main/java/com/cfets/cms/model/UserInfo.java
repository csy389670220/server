package com.cfets.cms.model;

public class UserInfo {
    private String userId;//主键
    private String userName;//用户名
    private String cardInfo;//证件号
    private String imgBase ;//图片Base64码
    private String statu   ;//状态；1有效 0失效
    private String creatTime ;//创建时间
    private String  updateTime ;//更新时间

    public UserInfo() {
    }

    public UserInfo(String userId, String userName, String cardInfo, String imgBase, String statu, String creatTime, String updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.cardInfo = cardInfo;
        this.imgBase = imgBase;
        this.statu = statu;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getImgBase() {
        return imgBase;
    }

    public void setImgBase(String imgBase) {
        this.imgBase = imgBase;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", cardInfo='" + cardInfo + '\'' +
                ", imgBase='" + imgBase + '\'' +
                ", statu='" + statu + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
