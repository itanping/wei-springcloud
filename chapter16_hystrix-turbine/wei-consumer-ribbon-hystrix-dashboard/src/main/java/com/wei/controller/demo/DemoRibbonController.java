package com.wei.controller.demo;

import com.wei.service.demo.DemoRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanping
 * @date 2018/8/23 18:32
 */
@RestController
public class DemoRibbonController {

    /**
     * 自动装载错误提示，不用管这个，运行的时候会被正确注入
     */
    @Autowired
    private DemoRibbonService demoRibbonService;

    @RequestMapping(value = {"/ribbon/demo/info", "/demo/info"})
    public String getDemoRibbonServiceName(@RequestParam String name) {
        return demoRibbonService.getDemoRibbonServiceName(name);
    }
}