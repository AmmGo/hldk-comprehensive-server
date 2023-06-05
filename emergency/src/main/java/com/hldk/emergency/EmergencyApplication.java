package com.hldk.emergency;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 *@Author  md
 *@Date  2022/12/20 11:12
 */
@SpringBootApplication(scanBasePackages = {"com.hldk.emergency","com.hldk.common"})
//@ServletComponentScan(basePackages = {"com.hldk.common.auth.filter"})
@MapperScan("com.hldk.emergency")
public class EmergencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmergencyApplication.class, args);
    }

}
