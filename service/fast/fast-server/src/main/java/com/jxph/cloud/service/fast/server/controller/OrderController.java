package com.jxph.cloud.service.fast.server.controller;

import com.jxph.cloud.common.utils.ResponseResult;
import com.jxph.cloud.service.fast.api.facade.OrderFacade;
import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.server.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢秋豪
 * @date 2018/9/3 20:46
 */
@RestController
@Api("订单接口")
public class OrderController implements OrderFacade {
    @Autowired
    private OrderService orderService;

    @Override
    @ApiOperation("测试创建订单")
    public ResponseResult<String> createOrder(@RequestBody TOrder tOrder) {
        orderService.createOrder(tOrder);
        return ResponseResult.ok();
    }
}
