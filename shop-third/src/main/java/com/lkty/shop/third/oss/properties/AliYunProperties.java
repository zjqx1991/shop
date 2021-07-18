package com.lkty.shop.third.oss.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里服务配置类
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.cloud.alicloud")
public class AliYunProperties {
    private String accessKey;
    private String secretKey;
    private OssProperties oss;
//    private SmsProperties sms;
//    private StsProperties sts;
//    private AliPayProperties aliPay;
}
