package com.lkty.shop.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LKTYObjectConfig
        implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时间
        this.setFieldValByName("createTime", new Date(), metaObject);
        // 更新时间
        this.setFieldValByName("updateTime", new Date(), metaObject);
        // 版本号
        this.setFieldValByName("version", 0, metaObject);
        // 逻辑删除
        this.setFieldValByName("delFlag", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
