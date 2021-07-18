package com.lkty.shop.third.oss.properties;


import lombok.Getter;
import lombok.Setter;

/**
 * OSS服务配置类
 */
@Setter
@Getter
public class OssProperties {
    private String bucket;
    private String endpoint;
}
