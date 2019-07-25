package com.cfets.cms.util;

/**
 * @author chengsiyu
 * 描述：异常定义字典
 */
public enum SysConstants {

    //通用状态定义
    OK("0", "成功"),
    FAIL("1", "失败");



    private String code;
    private String msg;

    SysConstants(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SysConstants getSysConstants(String code) {
        for (SysConstants sysConstants : SysConstants.values()) {
            if (sysConstants.getCode().equals(code)) {
                return sysConstants;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
