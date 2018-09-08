package com.jxph.cloud.api.utils;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

/**
 * @author 谢秋豪
 * @date 2018/9/2 16:45
 */
public class LimitResponseDecorate {
    public static void failResponse(RequestContext currentContext) throws ZuulException {
        currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        currentContext.setResponseBody("请求过多，发生中断");
        currentContext.setSendZuulResponse(false);
        currentContext.set("route", false);
        throw new ZuulException(HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase(),
                HttpStatus.TOO_MANY_REQUESTS.value(), HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase());
    }
}
