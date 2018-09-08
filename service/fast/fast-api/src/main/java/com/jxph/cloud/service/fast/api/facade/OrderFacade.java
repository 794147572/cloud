package com.jxph.cloud.service.fast.api.facade;

import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.fast.api.pojo.TOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 谢秋豪
 * @date 2018/9/3 20:44
 */
@RequestMapping("/orders")
public interface OrderFacade {

    @PostMapping("")
    ResponseResult<String> createOrder(@RequestBody TOrder tOrder);
}
