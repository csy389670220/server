package com.cfets.cms.util;

import com.cfets.cms.common.SysConstants;
import com.cfets.cms.error.EmBusinessError;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuteng_fb
 * Created on 2018-09-18
 * <p>
 * 返回给前端的结果集工具类
 */
public class ResultMapUtil {

    /**
     * 成功结果信息
     *
     * @param msg 信息
     * @return 成功结果信息map
     */
    public static Map<String, Object> success(Object msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "success");
        map.put("data", msg);
        return map;
    }

    /**
     * 失败结果信息
     *
     * @param msg 信息
     * @return 失败结果信息map
     */
    public static Map<String, Object> fail(Object msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "failure");
        map.put("data", msg);
        return map;
    }


    /**
     * 成功数据结果信息
     *
     * @param data 数据
     * @return 成功数据结果信息map
     */
    public static Map<String, Object> successData(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "success");
        map.put("data", data);
        return map;
    }

    /**
     * 失败数据结果信息
     *
     * @param data 数据
     * @return 失败数据结果信息map
     */
    public static Map<String, Object> failData(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "failure");
        map.put("data", data);
        return map;
    }

    /**
     * 构建返回结果
     *
     * @param code 结果编码
     * @param msg    信息
     * @return 结果信息对象
     */
    public static Map<String, Object> build(String code, Object msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("data", msg);
        return map;
    }

    /**
     * 构建返回结果
     *
     * @param sysConstants 结果枚举
     * @return 结果信息对象
     */
    public static Map<String, Object> build(SysConstants sysConstants) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", sysConstants.getCode());
        map.put("data", sysConstants.getMsg());
        return map;
    }

    /**
     * 构建返回结果
     *
     * @param emBusinessError 错误信息枚举
     * @return 结果信息对象
     */
    public static Map<String, Object> build(EmBusinessError emBusinessError) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", emBusinessError.getErrCode());
        map.put("data", emBusinessError.getErrMsg());
        return map;
    }


}
