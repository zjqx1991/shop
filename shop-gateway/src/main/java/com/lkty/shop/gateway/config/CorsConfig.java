package com.lkty.shop.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 配置跨域访问
 */
//@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        //cors跨域配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);//是否允许携带cookie
        corsConfiguration.addAllowedOrigin("*"); //允许跨域访问的域名，可填写具体域名，*代表允许所有访问
        corsConfiguration.addAllowedMethod("*");//允许访问类型：get  post 等，*代表所有类型
        corsConfiguration.addAllowedHeader("*");

        //配置源对象
        configurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsWebFilter(configurationSource);
    }

}
