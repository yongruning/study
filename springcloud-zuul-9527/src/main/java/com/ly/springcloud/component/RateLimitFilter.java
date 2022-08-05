package com.ly.springcloud.component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 限流器
 */
@Component
public class RateLimitFilter extends ZuulFilter {
    // 创建令牌桶
    //RateLimiter.create(1)1: 是每秒生成令牌的数量
    // 数值越大代表处理请求量越多，数值越小代表处理请求量越少
    private static final RateLimiter RATE_LIMIT = RateLimiter.create(5);

    /**
     * 过滤器类型 pre表示在请求之前进行逻辑操作
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 限流器的优先级应为最高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER;
    }

    /**
     * 是否开启过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器拦截业务逻辑代码
     */
    @Override
    public Object run() throws ZuulException {
        //是否能从令牌桶中获取到令牌
        if (!RATE_LIMIT.tryAcquire()) {
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("访问太多频繁，请稍后再访问！！！");
            requestContext.getResponse().setContentType(
                    "application/json; charset=utf-8");
        }
        return null;
    }
}
