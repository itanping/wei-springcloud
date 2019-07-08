package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注解@EnableEurekaClient，表明自己是一个Eureka Client
 *
 * @author tanping
 */
@SpringBootApplication
@EnableEurekaClient
public class WeiServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiServiceProviderApplication.class, args);
    }
}
