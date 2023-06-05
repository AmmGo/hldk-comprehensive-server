package com.hldk.emergency.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mq
 * @date 2023/2/3
 */
@Component
public class DateConverter implements Converter<String,Date> {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    private static final String shortDateFormat = "yyyy-MM-dd";

    private static final String timeStampFormat = "^\\d+$";

    private static final String hDateFormat = "yyyy年MM月dd日 HH:mm:ss";

    private static final String hshortDateFormat = "yyyy年MM月dd日";


    @Override
    public Date convert(String source) {
        String value =  source;
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        value = value.trim();
        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                return formatter.parse(value);
            } else if (value.matches(timeStampFormat)) {
                Long lDate = new Long(value);
                return new Date(lDate);
            } else if (value.contains("年")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(hDateFormat);
                } else {
                    formatter = new SimpleDateFormat(hshortDateFormat);
                }
                return formatter.parse(value);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }

}
