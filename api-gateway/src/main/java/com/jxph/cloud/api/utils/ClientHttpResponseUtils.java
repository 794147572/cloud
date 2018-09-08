package com.jxph.cloud.api.utils;

import com.jxph.cloud.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 谢秋豪
 * @date 2018/9/4 11:51
 */
@Slf4j
public class ClientHttpResponseUtils {
    public static ClientHttpResponse newFallBackClientHttpResponse(String route, Throwable cause){
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                if (cause != null) {
                    log.error("http exception:{}", cause);
                }
                return new ByteArrayInputStream(JSONUtils.toJsonString("The service is unavailable").getBytes("UTF-8"));
                /*return new ByteArrayInputStream("The service is unavailable".getBytes("UTF-8"));*/
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
