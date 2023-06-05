package com.hldk.emergency.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator on 2021/7/29.
 * @version 1.0
 */
@Component
@Data
@ConfigurationProperties("base-config")
public class Config {

    /**
     * 整体项目名称
     * 所有涉及到项目名称的地方引入此变量
     */
    private String cityName;

    /**
     * 登陆时解密秘钥
     */
    private String loginDecryptKey;

    /**
     * 验证码图片地址
     */
    private String path;
    /**
     * 管理员ID
     */
    private Integer adminRoleId;

    /**
     * 群众角色ID
     */
    private Integer userCrowdRoleId;


    /**
     * 在线人数Redis存储KEY
     */
    private String redisOnlineKeyPre;

    /**
     *文件地址
     */
    private String filePath;

    /**
     * Excel回执地址
     */
    private String fileErrorExcelPath;

}
