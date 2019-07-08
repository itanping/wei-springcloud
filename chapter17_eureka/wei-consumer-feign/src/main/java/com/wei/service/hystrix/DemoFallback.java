package com.wei.service.hystrix;

import com.wei.service.demo.IDemoFeignService;
import org.springframework.stereotype.Component;

/**
 * @author tanping
 * @date 2018/8/18 14:32
 */
@Component
public class DemoFallback implements IDemoFeignService {

    /**
     * 通过@FeignClient("Eureka服务名称")，来指定调用消费哪个服务
     * 注解@RequestMapping映射微服务中的URL
     *
     * @return 案例
     */
    @Override
    public String getDemoFeignServiceName(String name) {
        String result = "[Feign] Sorry, " + name +"，我是熔断器的回调方法返回值，我的出现代表服务已出现故障";
        System.out.println(result);
        return result;
    }
}
