package com.jxph.cloud.service.auth.client.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jxph.cloud.common.annotation.Login;
import com.jxph.cloud.common.constant.UserConstant;
import com.jxph.cloud.common.context.UserContextHolder;
import com.jxph.cloud.common.exception.AuthorizationException;
import com.jxph.cloud.service.auth.client.runner.JwtHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/9/1 11:50
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }
        if (annotation == null) {
            return true;
        }
        String token = request.getHeader(jwtHelper.getHeader());
        if (StringUtils.isBlank(token)) {
            throw new AuthorizationException(jwtHelper.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }
        DecodedJWT jwt = jwtHelper.verifyJWT(token);
        Map<String, Claim> claims = jwt.getClaims();
        if (claims == null || jwtHelper.isTokenExpired(jwt)) {
            throw new AuthorizationException(jwtHelper.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }
        if(!StringUtils.equals("true",claims.get(UserConstant.CONTEXT_KEY_USER_IS_LOGIN).asString())){
            throw new AuthorizationException("用户未登录，请登录", HttpStatus.UNAUTHORIZED.value());
        }
        if(claims.get(UserConstant.CONTEXT_KEY_USER_ID)!=null){
            UserContextHolder.set(UserConstant.CONTEXT_KEY_USER_ID, claims.get(UserConstant.CONTEXT_KEY_USER_ID).asString());
        }
        if(claims.get(UserConstant.CONTEXT_KEY_USER_NAME)!=null){
            UserContextHolder.set(UserConstant.CONTEXT_KEY_USER_NAME, claims.get(UserConstant.CONTEXT_KEY_USER_NAME).asString());
        }
        if(claims.get(UserConstant.CONTEXT_KEY_USERNAME)!=null){
            UserContextHolder.set(UserConstant.CONTEXT_KEY_USERNAME, claims.get(UserConstant.CONTEXT_KEY_USERNAME).asString());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolder.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
