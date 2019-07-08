package com.wei.controller.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanping
 * @date 2018/8/16 19:22
 */
@RestController
public class DemoServiceController {

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/demo/info")
    public String getDemoInfo(@RequestParam String name) {
        String result = "Hi，" + name + "，我是服务，我被调用了，服务名为：" + serviceName + "，端口为：" + port;
        System.out.println(result);
        return result;
    }
}
