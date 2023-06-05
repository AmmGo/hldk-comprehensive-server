package com.hldk.emergency.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.hldk.common.core.manger.LoginManager;
import com.hldk.common.core.token.Token;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Administrator on 2021/5/25.
 * @version 1.0
 * MyBatisplus 自动填充属性
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Token token = LoginManager.getToken();
        if (null != token){
            Integer userId = token.getUserId();
            this.setFieldValByName("creatorId", userId, metaObject);
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Token token = LoginManager.getToken();
        if (null != token){
            Integer userId = token.getUserId();
            this.setFieldValByName("updateId", userId, metaObject);
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
