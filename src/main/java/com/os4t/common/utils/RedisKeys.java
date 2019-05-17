package com.os4t.common.utils;

/**
 * Redis所有Keys
 *
 * @author  18256595192@163.com
 *
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
