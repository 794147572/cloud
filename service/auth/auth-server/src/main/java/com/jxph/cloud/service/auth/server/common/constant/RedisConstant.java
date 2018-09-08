package com.jxph.cloud.service.auth.server.common.constant;

/**
 * @author 谢秋豪
 * @date 2018/9/1 18:51
 */
public interface RedisConstant {
   String REDIS_SESSION = "AUTH:SESSION:";
   int REDIS_SESSION_EXPIRE = 1800;
   String REIDS_USER_PREFIX = "AUTH:USER:";
   int REDIS_USER_EXPIRE = 1800;
   int REDIS_USER_NULL_EXPIRE = 100;
}
