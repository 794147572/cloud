package com.jxph.cloud.api.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.jxph.cloud.api.utils.LimitResponseDecorate;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.binder.hystrix.MicrometerMetricsPublisher;
import io.micrometer.core.instrument.binder.hystrix.MicrometerMetricsPublisherCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 谢秋豪
 * @date 2018/9/2 16:32
 */
public class FastRateLimitZuulFilter extends ZuulFilter {
    private Map<String, RateLimiter> map = new ConcurrentHashMap<>();

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Object service = currentContext.get("serviceId");
        if (service != null) {
            //RibbonRoutingFilter
            if (map.get(service.toString()) == null) {
                map.put(service.toString(), RateLimiter.create(500));
            }
        } else {
            //SimpleHostRoutingFilter
            URL host = currentContext.getRouteHost();
            if (host != null) {
                String url = host.toString();
                if(map.get(url)==null){
                    map.put(url, RateLimiter.create(500));
                }
            }
        }
        RateLimiter rateLimiter = map.get(service);
        if (!rateLimiter.tryAcquire()) {
            LimitResponseDecorate.failResponse(currentContext);
        }
        return null;
    }
}
