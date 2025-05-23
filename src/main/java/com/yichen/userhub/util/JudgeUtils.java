package com.yichen.userhub.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;


/**
 * 判断工具类
 *
 * @author ZHANG YI FA
 * @date 2019-07-08
 */
public class JudgeUtils {

    private static final Logger logger = LoggerFactory.getLogger(JudgeUtils.class);

    public static final String successfulMsgCode = "0000";

    public static final String successfulMsgType = "N";

    public static final String errorMsgType = "E";

    /**
     * 判断所有类型是否为空
     *
     * @param t   判断对象
     * @param <T> 类型
     * @return 是否为空
     */
    public static <T> boolean isNull(T t) {
        //判断对象
        if (null == t) {
            return true;
        }

        //判断字符串
        boolean boolString = (t instanceof String) && ("null".equalsIgnoreCase(String.valueOf(t)) || StringUtils.isBlank(String.valueOf(t))) ;
        if (boolString) {
            return true;
        }

        //判断集合
        boolean boolCollection = (t instanceof Collection) && (CollectionUtils.isEmpty((Collection<?>) t) || 0 == ((Collection<?>) t).size());
        if (boolCollection) {
            return true;
        }

        //判断Map
        boolean boolMap = (t instanceof Map) && (0 == ((Map) t).size());
        if (boolMap) {
            return true;
        }

        return false;
    }

    /**
     * 判断所有类型是否为不为空
     *
     * @param t   判断对象
     * @param <T> 类型
     * @return 是否不为空
     */
    public static <T> boolean isNotNull(T t) {
        return !isNull(t);
    }

    @SafeVarargs
    public static <T> boolean isNullAny(T... ts) {
        if (null == ts) {
            return true;
        }

        for (T t : ts) {
            if (null == t) {
                return true;
            }
        }
        return false;
    }

    public static <T, L> boolean equals(T t, L l) {
        return t.equals(l);
    }

    public static <T, L> boolean notEquals(T t, L l) {
        return !equals(t, l);
    }

    public static boolean equals(String str1, String str2) {
        return StringUtils.equals(str1, str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return StringUtils.equalsIgnoreCase(str1, str2);
    }

    public static boolean notEquals(String str1, String str2) {
        return !equals(str1, str2);
    }

    public static boolean equalsAny(String str1, String... strs) {
        if (null == strs && null == str1) {
            return true;
        }
        if (null == strs) {
            return false;
        }
        boolean f = false;
        for (String s : strs) {
            if (equals(str1, s)) {
                f = true;
                break;
            }
        }
        return f;
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotBlankAll(String... args) {
        if (null == args) {
            return false;
        }
        boolean f = true;
        for (String s : args) {
            if (isBlank(s)) {
                f = false;
                break;
            }
        }
        return f;
    }

    public static boolean isBlankAll(String... args) {
        if (null == args) {
            return true;
        }
        boolean f = true;
        for (String s : args) {
            if (isNotBlank(s)) {
                f = false;
                break;
            }
        }
        return f;
    }

    public static boolean isBlankAny(String... args) {
        if (null == args) {
            return true;
        }
        boolean f = false;
        for (String s : args) {
            if (isBlank(s)) {
                f = true;
                break;
            }
        }
        return f;
    }


    public static boolean isEmpty(Collection<?> c) {
        if (null == c) {
            return true;
        }
        if (c.size() <= 0) {
            return true;
        }
        return false;
    }


    public static boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }


    public static boolean isEmpty(Map<?, ?> map) {
        if (null == map) {
            return true;
        }
        if (map.size() <= 0) {
            return true;
        }
        return false;
    }


    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }


    public static boolean isSuccess(String msgCd) {
        if (StringUtils.isEmpty(msgCd)) {
            throw new RuntimeException("MsgCd is null.");
        }
        int len = msgCd.length();
        return StringUtils.equals(msgCd, successfulMsgCode);
    }

    public static <T> boolean isEmpty(T[] ts) {
        if (null == ts) {
            return true;
        }
        if (ts.length <= 0) {
            return true;
        }
        return false;
    }

    public static <T> boolean isNotEmpty(T[] ts) {
        return !isEmpty(ts);
    }


    public static boolean contain(String[] args, String s) {
        if (isEmpty(args)) {
            return false;
        }
        boolean f = false;
        for (String a : args) {
            if (equals(a, s)) {
                f = true;
                break;
            }
        }
        return f;
    }

    /**
     * 第一个字符串是否包含第二个字符串
     * @param firstStr 第一个字符串
     * @param second 第二个字符串
     * @return 是否包含
     */
    public static boolean contains(String firstStr, String second) {
        if (isEmpty(firstStr) || isEmpty(second)) {
            return false;
        }
        boolean f = false;
        if(firstStr.contains(second)) {
            f = true;
        }
        return f;
    }

    /**
     * 是否没有包含MqUrl
     * @param firstStr 第一个字符串
     * @param second 第二个字符串
     * @return 是否包含
     */
    public static boolean notContainsMqUrl(String firstStr, String second) {
        return !containsMqUrl(firstStr, second);
    }

    /**
     * 是否包含MqUrl
     * @param firstStr 第一个字符串
     * @param second 第二个字符串
     * @return 是否包含
     */
    public static boolean containsMqUrl(String firstStr, String second) {
        if (isEmpty(firstStr) || isEmpty(second)) {
            return false;
        }
        boolean f = false;
        if(firstStr.contains(second)) {
            f = true;
        }
        return f;
    }

    public static boolean isNotSuccess(String msgCd) {
        return !isSuccess(msgCd);
    }


    public static boolean not(boolean flag) {
        return !flag;
    }

    public static boolean isTrue(Boolean flag, boolean defaultFlag) {
        if (null == flag) {
            return defaultFlag;
        }
        return flag;
    }


    public static boolean available(InputStream inputStream) {
        try {
            if (null != inputStream && inputStream.available() > 0) {
                return true;
            }
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("Failed to during available input stream. ", e);
            }
        }
        return false;
    }


//    public static <T> T callbackIfNecessary(boolean flag, Callback<T> callback) {
//        if (flag) {
//            return callback.callback();
//        }
//        return null;
//    }
//
//
//    public static void callbackIfNecessary(boolean flag, Callback0 callback) {
//        if (flag) {
//            callback.callback();
//        }
//    }
//
//
//    public static void callbackIfNecessary(Callback<Boolean> callback, Callback0 callback0) {
//        if (callback.callback()) {
//            callback0.callback();
//        }
//    }

}
