package com.jxph.cloud.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class RestUtil {

    static Logger log = LoggerFactory.getLogger(RestUtil.class);

    /**
     * 发送post 请求
     *
     * @param restTemplate
     * @param url
     * @param param
     * @param responseType
     * @param <T>
     * @return
     */
    public static <T> T postJSON(RestTemplate restTemplate, String url, Object param, Class<T> responseType) {
        HttpEntity<String> formEntity = makePostJSONEntiry(param);
        T result = restTemplate.postForObject(url, formEntity, responseType);
        log.info("rest-post-json 响应信息:{}", JSONUtils.toJsonString(result));
        return result;
    }

    /**
     * 生成json形式的请求头
     *
     * @param param
     * @return
     */
    public static HttpEntity<String> makePostJSONEntiry(Object param) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> formEntity = new HttpEntity<String>(
                JSONUtils.toJsonString(param), headers);
        log.info("rest-post-json-请求参数:{}", formEntity.toString());
        return formEntity;
    }


    public static HttpEntity<String> makePostTextEntiry(Map<String, ? extends Object> param) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> formEntity = new HttpEntity<String>(
                makeGetParamContent(param), headers);
        log.info("rest-post-text-请求参数:{}", formEntity.toString());
        return formEntity;
    }


    /**
     * 生成Get请求内容
     *
     * @param param
     * @param excluedes
     * @return
     */
    public static String makeGetParamContent(Map<String, ? extends Object> param, String... excluedes) {
        StringBuilder content = new StringBuilder();
        List<String> excludeKeys = Arrays.asList(excluedes);
        param.forEach((key, v) -> {
            content.append(key).append("=").append(v).append("&");
        });
        if (content.length() > 0) {
            content.deleteCharAt(content.length() - 1);
        }
        return content.toString();
    }
}