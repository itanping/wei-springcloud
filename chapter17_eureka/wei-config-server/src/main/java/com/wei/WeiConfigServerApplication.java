package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config Server
 * 注解@EnableConfigServer，开启对配置中心的支持
 * @author tanping
 */
@SpringBootApplication
@EnableConfigServer
public class WeiConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiConfigServerApplication.class, args);
    }
}
