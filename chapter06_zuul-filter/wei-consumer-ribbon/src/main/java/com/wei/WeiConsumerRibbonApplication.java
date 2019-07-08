package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 注解@EnableHystrix，开启Hystrix熔断功能
 *
 * @author tanping
 */
@SpringBootApplication
@EnableEurekaClient
public class WeiConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiConsumerRibbonApplication.class, args);
    }

    /**
     * 注解@Bean，向程序注入一个Bean
     * 注解@LoadBalanced，开启RestTemplate的负载均衡功能
     * 初始化RestTemplate，用来发起 REST 请求
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
