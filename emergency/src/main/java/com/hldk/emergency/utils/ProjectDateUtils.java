package com.hldk.emergency.utils;


import com.hldk.common.util.core.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.hldk.common.util.core.DateUtil.*;

/**
 * @author md
 * @date 2022/07/06/17:24
 */
public class ProjectDateUtils {

    /**
     * 获取昨天的同一时间
     * @param date
     * @return
     */
    public static Date getYesterdayByDate(String date) {
        Calendar cal = Calendar.getInstance();
        Date parse = parse(date, "yyyy-MM-dd HH:mm:ss");
        cal.setTime(parse);
        cal.add(5, -1);
        Date time = cal.getTime();
        return parse((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(time));
    }

    /**
     * 前天开始时间
     * @return
     */
    public static Date getEndBeforeYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayEnd());
        cal.add(5, -2);
        return cal.getTime();
    }

    /**
     * 前天结束时间
     * @return
     */
    public static Date getBeginBeforeYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayBegin());
        cal.add(5, -2);
        return cal.getTime();
    }

    /**
     * 获取上周的同一时间
     * @param date
     * @return
     */
    public static Date getLastWeekByDate(String date) {
        Calendar cal = Calendar.getInstance();
        Date parse = parse(date, "yyyy-MM-dd HH:mm:ss");
        cal.setTime(parse);
        cal.add(5, -7);
        Date time = cal.getTime();
        return parse((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(time));
    }

    /**
     * 获取上周的同一天开始时间
     * @param date
     * @return
     */
    public static Date getLastWeekBeginTimeByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        Date time = cal.getTime();
        return DateUtil.getDayStartTime(time);
    }

    /**
     * 上上周最后一天结束时间
     * @return
     */
    public static Date getEndBeforeLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, -1);
        Date weekEndSta = cal.getTime();
        return DateUtil.getDayEndTime(weekEndSta);
    }

    /**
     * 上上周最后一天开始时间
     * @return
     */
    public static Date getBeginBeforeLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, -1);
        Date weekEndSta = cal.getTime();
        return DateUtil.getDayStartTime(weekEndSta);
    }

    /**
     * 获取上个月的同一时间
     * @param date
     * @return
     */
    public static Date getLastMonthTime(String date) {
        Calendar cal = Calendar.getInstance();
        Date parse = parse(date, "yyyy-MM-dd HH:mm:ss");
        cal.setTime(parse);
        cal.add(Calendar.MONTH, -1);
        Date time = cal.getTime();
        return parse((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(time));
    }

    /**
     * 获取上个月的同一时间
     * @param date
     * @return
     */
    public static Date getNextMonthTime(String date) {
        Calendar cal = Calendar.getInstance();
        Date parse = parse(date, "yyyy-MM-dd HH:mm:ss");
        cal.setTime(parse);
        cal.add(Calendar.MONTH, 1);
        Date time = cal.getTime();
        return parse((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(time));
    }

    /**
     * 上上月最后一天结束时间
     * @return
     */
    public static Date getEndBeforeLastMonthTime() {
        Calendar c = Calendar.getInstance();
        //当前日期设置为指定日期
        c.setTime(new Date());
        //指定日期月份减去一
        c.add(Calendar.MONTH, -2);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        //获取上给月最后一天的日期
        Date lastDateOfPrevMonth = c.getTime();
        return DateUtil.getDayEndTime(lastDateOfPrevMonth);
    }

    /**
     * 上上月最后一天开始时间
     * @return
     */
    public static Date getBeginBeforeLastMonthTime() {
        Calendar c = Calendar.getInstance();
        //当前日期设置为指定日期
        c.setTime(new Date());
        //指定日期月份减去一
        c.add(Calendar.MONTH, -2);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        //获取上给月最后一天的日期
        Date lastDateOfPrevMonth = c.getTime();
        return DateUtil.getDayStartTime(lastDateOfPrevMonth);
    }

    /**
     * 获取去年的同一时间
     * @param date
     * @return
     */
    public static Date getLastYearTime(Date date) {
        Calendar cal = Calendar.getInstance();
        //Date parse = parse(date, "yyyy-MM-dd HH:mm:ss");
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        Date time = cal.getTime();
        return parse((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(time));
    }


    /**
     * 获取11个月指点的月份开始时间
     * @param date
     * @return
     */
    public static Date getLastElevenMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        //Date parse = parse(date, "yyyy-MM-dd HH:mm:ss");
        cal.setTime(date);
        cal.add(Calendar.MONTH, -11);
        Date time = cal.getTime();
        return parse((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(time));
    }

    /**
     * 获取前年最后一天结束时间
     * @return
     */
    public static Date getEndBeforeLastYearTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.getEndDayOfYear());
        cal.add(Calendar.YEAR, -2);
        Date yearEndSta = cal.getTime();
        return DateUtil.getDayEndTime(yearEndSta);
    }

    /**
     * 获取前年最后一天开始时间
     * @return
     */
    public static Date getBeginBeforeLastYearTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.getEndDayOfYear());
        cal.add(Calendar.YEAR, -2);
        Date yearEndSta = cal.getTime();
        return DateUtil.getDayStartTime(yearEndSta);
    }

    /**
     * 获取两个时间的间隔天数
     * @param date1
     * @param date2
     * @return
     */
    public static String betweenDays(Date date1,Date date2){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long betweenDay = (time1 - time2)/(1000*3600*24);
        return String.valueOf(betweenDay);
    }

    /**
     * 获取十二个小时前的时间
     * @return
     */
    public static Date getTwelveHoursBefore(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.HOUR, -12);
        Date result = cal.getTime();
        return result;
    }

    /**
     * 小时数取整
     * @param date 起始时间
     * @return  取整后时间
     */
    public static Date getHours(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取12小时内小时数列表
     * @param date 起始时间
     * @return  取整后时间
     */
    public static List<Integer> getIntegerHoursInTwelveHours(Date date){
        final int hours = 12;
        List<Integer> result = new ArrayList<Integer>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        for(int i = 0;i<hours;i++) {
            result.add(cal.get(Calendar.HOUR_OF_DAY));
            cal.add(Calendar.HOUR, -1);
        }
        return result;
    }

    /**
     * 获取24小时内小时数列表
     * @param date 起始时间
     * @return  取整后时间
     */
    public static List<Integer> getIntegerHoursInTwentyFourHours(Date date){
        final int hours = 24;
        List<Integer> result = new ArrayList<Integer>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        for(int i = 0;i<hours;i++) {
            result.add(cal.get(Calendar.HOUR_OF_DAY));
            cal.add(Calendar.HOUR, -1);
        }
        return result;
    }

    public static void main(String[] args) {
        //Long lu = System.currentTimeMillis();
        //System.out.println(Integer.toHexString(lu.intValue()));
        System.out.println(getLastElevenMonth(new Date()));
        //System.out.println(getLastWeekBeginTimeByDate(new Date()));
    }
}
