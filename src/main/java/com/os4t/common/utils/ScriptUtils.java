package com.os4t.common.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class ScriptUtils {

    private static final Logger logger = LoggerFactory.getLogger(ScriptUtils.class);

    private static final String EXPRESS_LANGUAGE = "js";
    private static final ScriptEngineManager SCRIPT_ENGINE_MANAGER = new ScriptEngineManager();
    private static final ScriptEngine SCRIPT_ENGINE = SCRIPT_ENGINE_MANAGER.getEngineByName(EXPRESS_LANGUAGE);

    public static Object eval(String express, Map<String, Object> parameter) {
        if (express == null)
            return null;

        try {
            if (parameter!=null && !parameter.isEmpty())
                for (Entry<String, Object> entry : parameter.entrySet())
                    SCRIPT_ENGINE.put(entry.getKey(), entry.getValue());

            return SCRIPT_ENGINE.eval(express);
        } catch (Exception e) {
            logger.error(null, e);
            return null;
        }
    }

    public static boolean equals(String express, Map<String, Object> parameter, Object target) {
        if (target == null)
            return false;

        return target.equals(eval(express, parameter));
    }

    public static boolean isTrue(String express, Map<String, Object> parameter) {
        return equals(express, parameter, Boolean.TRUE);
    }

    public static void main(String[] args) {

        ThreadLocal<String>  tl = new ThreadLocal<String>();
        System.out.println(tl.get()==null);
        Map<String, Object> param = new HashMap<String, Object>(1);
        param.put("str", "test");
        param.put("a", 1);
        param.put("isOK", true);
        param.put("CN", "中文");
        System.out.println(isTrue("true", null));
        System.out.println(isTrue("CN == \"中文2000/mm 2400*1000\"", param ));
        System.out.println(isTrue("str == \"test\"", param));
        System.out.println(isTrue("str.equals('1test!') || a==2 && !isOK", param));
    }
}