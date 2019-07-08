package com.wei.controller.demo;

import com.wei.service.demo.IDemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanping
 * @date 2018/9/27 17:20
 */
@RestController
public class DemoFeignController {

    /**
     * 编译器报错，无视。因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错
     */
    @Autowired
    private IDemoFeignService iDemoFeignService;

    @RequestMapping(value = {"/feign/demo/info", "/demo/info"}, method = RequestMethod.GET)
    public String getDemoFeignName(@RequestParam(value = "name") String name) {
        String result = iDemoFeignService.getDemoFeignServiceName(name);
        result += "[Feign]";
        System.out.println(result);
        return result;
    }
}
