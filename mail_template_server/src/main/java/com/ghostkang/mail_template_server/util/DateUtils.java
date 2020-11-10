package com.ghostkang.mail_template_server.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: GhostKang
 * @Date: 2019/6/12 10:08
 * @Version: 1.0
 */
public class DateUtils {
    public static final String YYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYMMDD = "yyyy-MM-dd";
    public static final String YYMMDD2 = "yyyy/MM/dd";
    public static final String YYMMDDHHMMSS2 = "yyyyMMddHHmmss";
    public static final String YYMM = "yyyy-MM";
    public static final String HHMM = "HH:mm";
    public static final String YYMMDDHHMM = "yyyy年MM月dd日 HH:mm";
    public static final String YYMMDDHHMM2 = "yyyy.MM.dd HH:mm";
    public static final String HHMMSS = "HH:mm:ss";

    /**
     * 时间戳转化为日期
     *
     * @param time    时间戳,单位毫秒
     * @param pattern 格式
     * @return 日期 2018-10-12 03:23:11
     */
    public static String timeFormatString(long time, String pattern) {
        String result;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        result = sdf.format(new Date(time));
        return result;
    }

    /***
     * 格式化日期转化为date
     * @param s 2018-10-12 03:23:11
     * @param pattern yyyy-MM-dd HH:mm:ss
     * @return date
     */
    public static Date StringFormatDate(String s, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 根据日期获取当天是周几
     *
     * @param datetime 日期
     * @return 周几
     */
    public static Integer dateToWeek(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Integer[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = sdf.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }

}
