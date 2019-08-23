package com.example.iis.business;
/**
 * @author: Farben
 * 
 * @description: 业务错误，code字典父类接口
 * 
 * @create: 2019/8/21-10:14
 **/
public interface CommonError {

    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
