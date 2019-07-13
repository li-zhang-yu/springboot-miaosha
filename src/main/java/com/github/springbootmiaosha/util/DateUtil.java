package com.github.springbootmiaosha.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author lizhangyu
 * @Date 2019-07-13
 */
public class DateUtil {

    /**
     * 时间格式化格式
     */
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式化格式
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当天日期（yyyy-MM-dd）
     *
     * @return
     */
    public static String getTodayDate() {
        return DATE_FORMAT.format(new Date());
    }

    /**
     * 格式化日期（yyyy-MM-dd）
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    /**
     * 格式化时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date);
    }

}
