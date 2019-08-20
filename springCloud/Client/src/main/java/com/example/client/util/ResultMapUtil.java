package com.example.client.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * Created on 2018-09-18
 * <p>
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
     * @param result 结果编码
     * @param msg    信息
     * @return 结果信息对象
     */
    public static Map<String, Object> build(String result, Object msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", result);
        map.put("data", msg);
        return map;
    }






}
