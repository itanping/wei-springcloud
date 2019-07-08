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

    @Value("${config.env:env parameter error!}")
    private String configEnv;

    @Value("${config.tip:tip parameter error!}")
    private String configTip;

    @GetMapping("/demo/info")
    public String hello() {
        String result = "[Config Client] env:" + configEnv + ", tip:" + configTip;
        return result;
    }
}
