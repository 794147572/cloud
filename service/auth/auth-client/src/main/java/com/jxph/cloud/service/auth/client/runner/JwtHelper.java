package com.jxph.cloud.service.auth.client.runner;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jxph.cloud.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/9/1 11:06
 */

@Component
public class JwtHelper {
    private static final Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    @Value("${jwt.security.secret}")
    private String SECRET;
    @Value("${jwt.security.issuer}")
    private String ISSUER;
    @Value("${jwt.header}")
    private String header;

    public String getHeader() {
        return header;
    }

    public String createJWT(Map<String, String> map) {
        String sign = null;
        try {
            Date date = DateUtils.addDateDays(new Date(), 1);
            JWTCreator.Builder builder = JWT.create();
            map.forEach((k, v) -> {
                builder.withClaim(k, v);
            });
            sign = builder.withIssuer(ISSUER).withExpiresAt(date).sign(Algorithm.HMAC256(SECRET));
        } catch (UnsupportedEncodingException e) {
            logger.error("create jwt error:{}", e);
        }
        return sign;
    }

    public DecodedJWT verifyJWT(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
            jwt = verifier.verify(token);
        } catch (UnsupportedEncodingException e) {
            logger.error("verify jwt error");
        }
        return jwt;
    }

    public boolean isTokenExpired(DecodedJWT jwt) {
        Date date = jwt.getExpiresAt();
        return date.before(new Date());
    }
}
