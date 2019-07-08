package com.wei.service.demo;

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
     */
    public String getDemoRibbonServiceName(String name) {
        String result = restTemplate.getForObject("http://wei-service-provider/demo/info?name=" + name, String.class);
        result += "[Ribbon + REST]";
        System.out.println(result);
        return result;
    }
}
