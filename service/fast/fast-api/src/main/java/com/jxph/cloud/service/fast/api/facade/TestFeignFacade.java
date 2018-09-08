package com.jxph.cloud.service.fast.api.facade;

import com.jxph.cloud.common.utils.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 谢秋豪
 * @date 2018/9/3 20:50
 */
@RequestMapping("/test")
public interface TestFeignFacade {
    @RequestMapping(value= "/test",method = RequestMethod.GET)
    ResponseResult<String> testFeign();
}
