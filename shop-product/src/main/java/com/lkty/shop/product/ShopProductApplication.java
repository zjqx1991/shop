package com.lkty.shop.product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = {"com.lkty.shop.product", "com.lkty.shop.common"})
public class ShopProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopProductApplication.class, args);
    }
}
