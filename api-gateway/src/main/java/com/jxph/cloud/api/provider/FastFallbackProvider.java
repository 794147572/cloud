package com.jxph.cloud.api.provider;

import com.jxph.cloud.api.utils.ClientHttpResponseUtils;
import com.jxph.cloud.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 谢秋豪
 * @date 2018/9/1 22:06
 */
@Slf4j
@Component
public class FastFallbackProvider implements FallbackProvider {
    @Value("${zuul.routes.fast.serviceId}")
    private String fast;

    @Override
    public String getRoute() {
        return fast;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return ClientHttpResponseUtils.newFallBackClientHttpResponse(route,cause);
    }
}
