package com.cfets.cms.error;

public enum  EmBusinessError implements CommonError{

    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOW_ERROR(10000,"未知错误"),
    //用户业务错误类型2开头
    SYS_USER_ADD_QUERY(20000,"用户查询错误"),
    SYS_USER_ADD_ERROR(20001,"用户新增错误"),
    SYS_USER_DEL_ERROR(20002,"用户删除错误"),
    SYS_USER_UPDATE_ERROR(20002,"用户更新错误"),
    SYS_USER_EXIST_ERROR(20003,"用户已存在"),
    //权限业务错误类型3开通
    ROLE_PERMISSION_ADD_ERROR(30001,"新增角色失败"),
    ROLE_PERMISSION_DEL_ERROR(30002,"删除角色失败"),
    ROLE_PERMISSION_UPDATE_ERROR(30003,"更新角色失败"),
    ROLE_PERMISSION_TREEINIT_ERROR(30004,"角色资源树初始化失败"),
    //秒杀业务
    SECKILL_EXECUTE_OK(40000,"秒杀成功"),
    SECKILL_EXECUTE_ERROR(40001,"秒杀失败"),
    SECKILL_STOCK_ERROR(40002,"库存售罄"),
    SECKILL_MD5_ERROR(40003,"秒杀地址验证非法"),
    SECKILL_REPEAT_ERROR(40004,"重复秒杀"),
    SECKILL_END_ERROR(40005,"活动已经结束"),
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg) {
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
