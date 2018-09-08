package com.jxph.cloud.common.context;

import com.jxph.cloud.common.constant.UserConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/9/1 12:25
 */
public class UserContextHolder {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if(map==null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        return map.get(key);
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static String getUserId() {
        return returnStringValue(get(UserConstant.CONTEXT_KEY_USER_ID));
    }

    public static String getUserName() {
        return returnStringValue(get(UserConstant.CONTEXT_KEY_USERNAME));
    }

    public static String getName() {
        return returnStringValue(get(UserConstant.CONTEXT_KEY_USER_NAME));
    }

    private static String returnStringValue(Object value) {
        return value == null ? null : value.toString();
    }
}
