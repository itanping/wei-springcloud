package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 注解@EnableDiscoveryClient，向服务中心注册(Eureka2.0已经不需要)
 * 注解@EnableFeignClients，开启Feign客户端功能
 *
 * @author tanping
 */
@SpringBootApplication
@EnableFeignClients
public class WeiConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiConsumerFeignApplication.class, args);
    }
}
