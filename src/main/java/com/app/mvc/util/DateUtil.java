package com.app.mvc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间通用处理工具类
 * @author kuangbinhua
 */
public class DateUtil {

    //日期时间类型格式
    public final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //日期时间类型格式-时间戳
    public static String DATETIME_FORMAT_TOO = "yyyyMMddHHmmss";

    public static String DATETIME_FORMAT_DAY = "yyyyMMdd";

    //日期类型格式
    public static String DATE_FORMAT = "yyyy-MM-dd";

    //时间类型的格式
    private static String TIME_FORMAT = "HH:mm:ss";

    //注意SimpleDateFormat不是线程安全的
    private static ThreadLocal<SimpleDateFormat> ThreadDateTime = new ThreadLocal<SimpleDateFormat>();
    private static ThreadLocal<SimpleDateFormat> ThreadDate = new ThreadLocal<SimpleDateFormat>();
    private static ThreadLocal<SimpleDateFormat> ThreadTime = new ThreadLocal<SimpleDateFormat>();

    /**
     *  格式化日期<br>
     *  已用作jstl函数
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null || format=="") {
            return "";
        } else if (DATE_FORMAT.equals(format)) {
            return dateInstance().format(date);
        } else if (DATETIME_FORMAT.equals(format)) {
            return datetimeInstance().format(date);
        } else if (TIME_FORMAT.equals(format)) {
            return timeInstance().format(date);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }

    private static SimpleDateFormat datetimeInstance() {
        SimpleDateFormat df = ThreadDateTime.get();
        if (df == null) {
            df = new SimpleDateFormat(DATETIME_FORMAT);
            ThreadDateTime.set(df);
        }
        return df;
    }

    private static SimpleDateFormat timestampInstance() {
        SimpleDateFormat df = ThreadDateTime.get();
        if (df == null) {
            df = new SimpleDateFormat(DATETIME_FORMAT_TOO);
            ThreadDateTime.set(df);
        }
        return df;
    }

    private static SimpleDateFormat dateInstance() {
        SimpleDateFormat df = ThreadDate.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            ThreadDate.set(df);
        }
        return df;
    }

    private static SimpleDateFormat timeInstance() {
        SimpleDateFormat df = ThreadTime.get();
        if (df == null) {
            df = new SimpleDateFormat(TIME_FORMAT);
            ThreadTime.set(df);
        }
        return df;
    }


    /**
     * 获取当前日期时间
     *
     * @return 返回当前时间的字符串值
     */
    public static String dateTime() {
        return datetimeInstance().format(new Date());
    }

    /**
     * 获取时间戳
     *
     * @return 返回时间戳
     */
    public static String timestamp(Date date) {
        return datetimeInstance().format(date);
    }

    /**
     * 将指定的时间格式化成出返回
     *
     * @param date
     * @return
     */
    public static String dateTime(Date date) {
        return datetimeInstance().format(date);
    }

    /**
     * 将指定的字符串解析为时间类型
     *
     * @param datestr
     * @return Date
     * @throws ParseException
     */
    public static Date dateTime(String datestr) throws ParseException {
        return datetimeInstance().parse(datestr);
    }

    /**
     * 获取当前的日期
     *
     * @return
     */
    public static String date() {
        return dateInstance().format(new Date());
    }

    /**
     * 将指定的时间格式化成出返回
     *
     * @param date
     * @return
     */
    public static String date(Date date) {
        return dateInstance().format(date);
    }

    /**
     * 将指定的字符串解析为时间类型
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date date(String dateStr) throws ParseException {
        return dateInstance().parse(dateStr);
    }

    /**
     * 获取当前的时间
     *
     * @return
     */
    public static String time() {
        return timeInstance().format(new Date());
    }

    /**
     * 讲指定的时间格式化成出返回
     *
     * @param date
     * @return
     */
    public static String time(Date date) {
        return timeInstance().format(date);
    }

    /**
     * 将指定的字符串解析为时间类型
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date time(String dateStr) throws ParseException {
        return timeInstance().parse(dateStr);
    }

    /**
     * 判断字符串是否为日期字符串
     * @param date 日期字符串
     * @return true or false
     */
    public static boolean isDate(String date) {
        try {
            datetimeInstance().parse(date);
            return true;
        } catch (ParseException e) {
        }
        return false;
    }


    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(Long seconds, String format) {
        if (seconds == null || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty())
            format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(seconds));
    }

    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
