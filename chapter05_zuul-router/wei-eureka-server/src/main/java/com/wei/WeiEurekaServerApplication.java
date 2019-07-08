package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注解@EnableEurekaServer，开启Eureka服务注册中心功能
 *
 * @author tanping
 */
@SpringBootApplication
@EnableEurekaServer
public class WeiEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiEurekaServerApplication.class, args);
    }
}
