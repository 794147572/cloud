package com.jxph.cloud.api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 谢秋豪
 * @date 2018/9/1 22:12
 */
@Slf4j
public class DefaultFilter extends ZuulFilter {
    /**
     * 定义filter的类型，有pre、route、post、error四种
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义filter的顺序，数字越小表示顺序越高，越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示是否需要执行该filter，true表示执行，false表示不执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter需要执行的具体操作
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.info("tokenFilter:{},{}", request.getMethod(), request.getRequestURL().toString());
        String requestURL = request.getRequestURL().toString();
        /*if (flag) {
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("router", true);
        } else {
            //不对其进行路由
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(400);
            currentContext.setResponseBody("fast is empty");
            currentContext.set("router", false);
        }*/
        return null;
    }
}
