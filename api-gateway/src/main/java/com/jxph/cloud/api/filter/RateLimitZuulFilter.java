package com.jxph.cloud.api.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.jxph.cloud.api.utils.LimitResponseDecorate;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 谢秋豪
 * @date 2018/9/2 16:08
 */
public class RateLimitZuulFilter extends ZuulFilter {
    private final RateLimiter rateLimiter = RateLimiter.create(1000);


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    /**
     * 不开启限流设置为false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        if (!rateLimiter.tryAcquire()) {
            LimitResponseDecorate.failResponse(currentContext);
        }
        return null;
    }
}
