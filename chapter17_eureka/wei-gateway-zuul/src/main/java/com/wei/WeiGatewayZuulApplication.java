package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author tanping
 * @date 2018/10/24 18:20
 *
 * 注解@EnableZuulProxy，开启Zuul功能，自带熔断
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class WeiGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiGatewayZuulApplication.class, args);
    }
}
