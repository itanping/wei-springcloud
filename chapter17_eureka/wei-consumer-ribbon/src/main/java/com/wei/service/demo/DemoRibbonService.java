package com.wei.service.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanping
 * @date 2018/9/26 22:32
 */
@Service
public class DemoRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 创建一个新接口用来消费服务提供者提供的接口
     * 用程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
     *
     * 方法加上@HystrixCommand注解，该注解对该方法创建了熔断器的功能，并指定fallbackMethod熔断方法（在Ribbon中使用熔断器）
     */
    @HystrixCommand(fallbackMethod = "returnError")
    public String getDemoRibbonServiceName(String name) {
        String result = restTemplate.getForObject("http://wei-service-provider/demo/info?name=" + name, String.class);
        result += "[Ribbon + REST]";
        System.out.println(result);
        return result;
    }

    /**
     * 当服务不可用时会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞
     *
     * @return 自定义字符串
     */
    private String returnError(String name) {
        String result = "[Ribbon] Sorry, " + name +"，我是Hystrix熔断器的回调方法返回值，我的出现代表服务已出现故障";
        System.out.println(result);
        return result;
    }
}
