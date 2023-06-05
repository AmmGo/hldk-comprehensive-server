package com.hldk.emergency.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间计算相关方法
 * @author sfy
 */
public class TimeUtils {
    /**
     * 计算两个日期date间隔的小时数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return duration 时间间隔的小时数
     */
    public static Double dateTimeDurationHours(Date startTime,Date endTime){
        long between = endTime.getTime() - startTime.getTime();
        double duration = between / (60 * 60 * 1000) ;
        return duration;
    }

    /**
     * 计算当前日期12个月内的年月列表(从前往后)
     * @return List<String> 顺序输出年月列表
     */
    public static List<String> getYearMonthRecentTwelveMonths(){
        final int month =12;
        Date date = new Date();
        List<String> result = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        //获取开始年月
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -11);
        date = calendar.getTime();
        for(int i=0;i<month;i++){
            result.add(simpleDateFormat.format(date));
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 1);
            date = cal.getTime();
        }
        return result;
    }

    public static String secondTime(long between) {
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String str = day + "天" + hour + "小时" + min + "分" + s + "秒";
        return str;
    }

    public static Double secondTimeHour(double between) {
        //long day = between / (24 * 60 * 60 * 1000);
        double hour = between / (60 * 60 * 1000) ;
        return hour;
    }

    public static void main(String[] args) {
        System.out.println(getYearMonthRecentTwelveMonths());
        System.out.println(secondTime(10000000));
        System.out.println(secondTimeHour(10000000));

    }
}
