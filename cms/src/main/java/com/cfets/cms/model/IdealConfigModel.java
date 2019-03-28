package com.cfets.cms.model;

import java.io.Serializable;

/**
 * ideal系统参数实体类
 */
public class IdealConfigModel  implements Serializable {
    private String  idealId;//主键
    private String  milieuVal;//环境
    private String  function;//功能
    private String  machineName;//机器名
    private String  realIp;//实IP
    private String  mappingIp;//内外网映射IP
    private String  virtualIp;//虚IP
    private String  depIp;//DEP组播子网IP
    private String  userPass;//用户名密码

    public IdealConfigModel(){

    }

    public IdealConfigModel(String idealId, String milieuVal, String function, String machineName, String realIp, String mappingIp, String virtualIp, String depIp, String userPass) {
        this.idealId = idealId;
        this.milieuVal = milieuVal;
        this.function = function;
        this.machineName = machineName;
        this.realIp = realIp;
        this.mappingIp = mappingIp;
        this.virtualIp = virtualIp;
        this.depIp = depIp;
        this.userPass = userPass;
    }

    public String getIdealId() {
        return idealId;
    }

    public void setIdealId(String idealId) {
        this.idealId = idealId;
    }

    public String getMilieuVal() {
        return milieuVal;
    }

    public void setMilieuVal(String milieuVal) {
        this.milieuVal = milieuVal;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getRealIp() {
        return realIp;
    }

    public void setRealIp(String realIp) {
        this.realIp = realIp;
    }

    public String getMappingIp() {
        return mappingIp;
    }

    public void setMappingIp(String mappingIp) {
        this.mappingIp = mappingIp;
    }

    public String getVirtualIp() {
        return virtualIp;
    }

    public void setVirtualIp(String virtualIp) {
        this.virtualIp = virtualIp;
    }

    public String getDepIp() {
        return depIp;
    }

    public void setDepIp(String depIp) {
        this.depIp = depIp;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "IdealConfigModel{" +
                "idealId='" + idealId + '\'' +
                ", milieuVal='" + milieuVal + '\'' +
                ", function='" + function + '\'' +
                ", machineName='" + machineName + '\'' +
                ", realIp='" + realIp + '\'' +
                ", mappingIp='" + mappingIp + '\'' +
                ", virtualIp='" + virtualIp + '\'' +
                ", depIp='" + depIp + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
