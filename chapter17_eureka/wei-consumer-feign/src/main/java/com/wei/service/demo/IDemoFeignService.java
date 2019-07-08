package com.wei.service.demo;

import com.wei.service.hystrix.DemoFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过@FeignClient("Eureka服务名称")，来指定调用消费哪个服务
 * fallback：指定 fallback 类，以在服务熔断的时候返回 fallback 类中的内容
 *
 * @author tanping
 * @date 2018/8/17 17:18
 */
@FeignClient(value = "wei-service-provider", fallback = DemoFallback.class)
public interface IDemoFeignService {

    /**
     * 注解@RequestMapping，映射服务提供者中的URL
     * @param name 入参
     * @return
     */
    @RequestMapping(value = "/demo/info", method = RequestMethod.GET)
    String getDemoFeignServiceName(@RequestParam(value = "name") String name);

    // Feign客户端和Ribbon类似，同样实现了客户端的负载均衡
    // 与Ribbon不同的是，Feign的调用与本地接口的调用更加类似，并且更加便捷、更加优雅，传入参数较多时得以体现
}
