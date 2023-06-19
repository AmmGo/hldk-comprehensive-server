package com.osw.oswtg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *@Author  md
 *@Date  2022/12/20 11:12
 */
@SpringBootApplication(scanBasePackages = {"com.osw.oswtg","com.hldk.common"})
//@ServletComponentScan(basePackages = {"com.hldk.common.auth.filter"})
@MapperScan("com.osw.oswtg")
public class EmergencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmergencyApplication.class, args);
    }

}
