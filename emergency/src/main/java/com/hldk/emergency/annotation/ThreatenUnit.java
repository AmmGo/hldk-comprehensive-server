package com.hldk.emergency.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Administrator on 2021/4/29.
 * @version 1.0
 * 单位注解 用于拼接
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
public @interface ThreatenUnit {

    //名称
    String value();
    //单位
    String unit();
    //默认值
    String defaultValue();
    //类型 1威胁单位 2威胁道路 3威胁土地 4威胁设施
    String type();


}
