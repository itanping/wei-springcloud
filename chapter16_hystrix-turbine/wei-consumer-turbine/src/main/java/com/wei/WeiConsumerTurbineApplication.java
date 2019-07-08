package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 注解@EnableTurbine，开启 Turbine 聚合监控
 *
 * @author tanping
 */
@SpringBootApplication
@EnableTurbine
public class WeiConsumerTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiConsumerTurbineApplication.class, args);
    }

}
