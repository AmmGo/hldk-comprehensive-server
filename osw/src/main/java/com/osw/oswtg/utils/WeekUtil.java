package com.osw.oswtg.utils;

import com.hldk.common.util.core.CollectionUtil;
import com.hldk.common.util.core.DateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class WeekUtil {

    /**
     * 地球半径,单位 km
     */
    private static final double EARTH_RADIUS = 6378.137;
    /**
     * 获取近七天的时间集合
     * @return
     */
    public static List<String> getDataList() {
        List<String> arrayList = new ArrayList<>();
            for (int i = 7; i > 0; i--) {
                arrayList.add(DateUtils.getBeforeTime(i));
            }
        return arrayList;
    }

    public static <T, E> List<E> listToListView(List<T> list, Class<E> clazz) {
        if (CollectionUtil.isNotEmpty(list)) {
            try {
                List<E> eList = new ArrayList();
                Iterator var3 = list.iterator();

                while(var3.hasNext()) {
                    T t = (T) var3.next();
                    E e = clazz.newInstance();
                    BeanUtils.copyProperties(t, e, clazz);
                    eList.add(e);
                }

                return eList;
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }

        return null;
    }
    public static <E> E entityToView(Object entity, Class<E> clazz) {
        if (null != entity) {
            try {
                E e = clazz.newInstance();
                BeanUtils.copyProperties(entity, e, clazz);
                return e;
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

        return null;
    }

    /**
     * workbook返回流数据
     *
     * @param workbook
     * @param response
     * @param fileName
     */
    public static void workbookWriteIO(Workbook workbook, HttpServletResponse response, String fileName) {
        try {
            response.setContentType("application/octet-stream");
            response.setHeader("name", fileName);
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "protected");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-disposition",
                    "attachment; filename=\"" + URLEncoder.encode(fileName + DateUtil.format(new Date(), "yyyy-MM-dd-hh-mm-sss") + ".xlsx", "UTF-8") + "\"");
            workbook.write(response.getOutputStream()); // 输出流控制workbook
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据对象字段去重
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    /**
     * 创建excel文档，
     *
     * @param list        数据
     * @param keys        list中map的key数组集合
     * @param columnNames excel的列名
     */
    public static Workbook createWorkBook(List<Map<String, Object>> list, String[] keys, String columnNames[]) {
        // 创建excel工作簿
        SXSSFWorkbook wb = new SXSSFWorkbook(100);//在内存中只保留100行记录,超过100就将之前的存储到磁盘里
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        sheet.protectSheet("password");
        CellStyle lockedStyle = wb.createCellStyle();
        lockedStyle.setLocked(true);
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for (int i = 0; i < keys.length; i++) {
            sheet.setColumnWidth(i, (int) (35.7 * 150));
        }

        // 创建第一行
        Row row = sheet.createRow(0);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        //设置列名
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
            cell.setCellStyle(lockedStyle);
        }
        //设置每行每列的值
        for (int i = 1; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow(i);
            // 在row行上创建一个方格
            for (int j = 0; j < keys.length; j++) {
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null ? " " : list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
                cell.setCellStyle(lockedStyle);
            }
        }
        return wb;
    }
    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param longitude1 第一个点的经度
     * @param latitude1  第一个点的纬度
     * @param longitude2 第二个点的经度
     * @param latitude2  第二个点的纬度
     * @return 返回距离 单位千米
     */
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 纬度
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);
        // 经度
        double lng1 = Math.toRadians(longitude1);
        double lng2 = Math.toRadians(longitude2);
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 千米
        s = s * EARTH_RADIUS;
        return s;
    }

    public static void main(String[] args) {
        double distance = getDistance(106.169331, 38.503432, 106.16, 38.50);
        System.out.println(distance);
    }
}
