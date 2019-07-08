package com.wei.controller.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解@RefreshScope必须加，否则客户端会收到服务端的更新消息，但是更新不了，因为不知道更新哪里的
 *
 * @author tanping
 * @date 2018/10/11 22:29
 */
@RestController
@RefreshScope
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