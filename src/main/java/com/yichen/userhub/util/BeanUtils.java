package com.yichen.userhub.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bean工具类
 *
 * @author ZHANG YI FA
 * @date 2019-07-08
 */
public class BeanUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    public static final String GET = "get";

    public static final String SET = "set";


    /**
     * 对象拷贝
     *
     * @param source 有值对象
     * @param target 需要被赋值的对象
     */
    public static void copyProperties(Object source, Object target) {
        try {
            if (JudgeUtils.isNotNull(source)) {
                BeanUtils.copyProperties(source, target);
            }
        } catch (Exception e) {
            logger.error("bean copy error", e);
            throw e;
        }
    }



}
