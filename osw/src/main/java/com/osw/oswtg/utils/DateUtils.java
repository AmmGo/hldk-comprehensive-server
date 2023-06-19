package com.osw.oswtg.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 获取前N天时间
     */
    public static String getBeforeTime(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - n);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
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

    public static String getBeforeOneHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("一个小时前的时间：" + df.format(calendar.getTime()));
        System.out.println("当前的时间：" + df.format(new Date()));
        return df.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(secondTime(10000000));
        System.out.println(secondTimeHour(10000000));

    }
}
