package com.wei.controller.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanping
 * @date 2018/10/11 22:29
 */
@RestController
public class DemoController {

    @Value("${config.env:config environment error}")
    private String configEnv;

    @Value("${config.tips:错误配置属性config.tips测试，此处应该为config.tip}")
    private String configTip;

    @GetMapping("/demo/info")
    public String hello() {
        String result = "[Config Client] " + configEnv + ", " + configTip;
        return result;
    }
}
