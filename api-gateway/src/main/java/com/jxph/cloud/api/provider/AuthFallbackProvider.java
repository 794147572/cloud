package com.jxph.cloud.api.provider;

import com.jxph.cloud.api.utils.ClientHttpResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @author 谢秋豪
 * @date 2018/9/4 11:46
 */
@Slf4j
@Component
public class AuthFallbackProvider implements FallbackProvider {
    @Value("${zuul.routes.auth.serviceId}")
    private String auth;

    @Override
    public String getRoute() {
        return auth;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return ClientHttpResponseUtils.newFallBackClientHttpResponse(route,cause);

    }
}
