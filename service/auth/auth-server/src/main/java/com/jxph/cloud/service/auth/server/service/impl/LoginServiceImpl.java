package com.jxph.cloud.service.auth.server.service.impl;

import com.jxph.cloud.common.constant.UserConstant;
import com.jxph.cloud.common.exception.UserInvalidException;
import com.jxph.cloud.service.auth.api.form.LoginForm;
import com.jxph.cloud.service.auth.api.pojo.SysUser;
import com.jxph.cloud.service.auth.api.pojo.SysUserExample;
import com.jxph.cloud.service.auth.client.runner.JwtHelper;
import com.jxph.cloud.service.auth.server.common.utils.MD5Helper;
import com.jxph.cloud.service.auth.server.dao.SysUserMapper;
import com.jxph.cloud.service.auth.server.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/9/3 22:27
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public String login(LoginForm loginForm) throws UserInvalidException {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(loginForm.getUsername());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers.isEmpty()) {
            throw new UserInvalidException("用户名或密码不正确");
        }
        SysUser sysUser = sysUsers.get(0);
        if(!StringUtils.equals(sysUser.getPassword(),MD5Helper.encryPassword(loginForm.getPassword(),sysUser.getSalt()))){
            throw new UserInvalidException("用户名或密码不正确");
        }
        Map<String, String> map = new HashMap<>();
        map.put(UserConstant.CONTEXT_KEY_USERNAME, sysUser.getUsername());
        map.put(UserConstant.CONTEXT_KEY_USER_ID, sysUser.getUserId().toString());
        map.put(UserConstant.CONTEXT_KEY_USER_IS_LOGIN, "true");
        String token = jwtHelper.createJWT(map);
        return token;
    }
}
