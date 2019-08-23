package com.example.iis.business;
/**
 * @author: Farben
 *
 * @description: x系统枚举自定义code字典
 *
 * @create: 2019/8/21-10:14
 **/
public enum EmBusinessCode implements CommonError{

    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOW_ERROR(10000,"未知错误"),
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessCode(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
