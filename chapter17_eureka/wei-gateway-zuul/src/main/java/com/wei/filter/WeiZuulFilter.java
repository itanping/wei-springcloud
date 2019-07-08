package com.wei.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tanping
 * @date 2018/10/25 13:46
 */
@Component
public class WeiZuulFilter extends ZuulFilter {

    /**
     * 类型包含 pre、post、route、error
     * pre：在路由代理之前执行
     * route：代理的时候执行
     * error：出现错的时候执行
     * post：在route 或者是 error 执行完成后执行
     *
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行
     * 这里定义为pre，表示会在请求被路由之前执行
     *
     * @return 过滤器类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * Zuul filter 为链式过滤器，多个filter按顺序执行，通过数字指定
     * 数字越大，优先级越低
     *
     * @return 执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否启用该过滤器
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围
     *
     * @return true:启用过滤器 / false:禁用过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑实现Demo
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        System.out.println("[ Demo For Zuul Filter ] Execute!");

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getParameter("token");

        if (StringUtils.isEmpty(token)) {
            System.out.println("[ Demo For Zuul Filter ] token parameter is empty!");

            // 使用 Zuul 过滤此种场景的请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is empty!");
        } else {
            System.out.println("[ Demo For Zuul Filter ] test success!");
        }

        return null;
    }
}
