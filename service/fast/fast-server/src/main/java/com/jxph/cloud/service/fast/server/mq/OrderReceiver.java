package com.jxph.cloud.service.fast.server.mq;


import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 谢秋豪
 * @date 2018/8/30 15:24
 */
@Component
@Slf4j
public class OrderReceiver {

    @RabbitHandler()
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(name = "order-exchange", durable = "true", type = "topic"),
            key = "order.*"
    ))
    public void onOrderMessage(@Payload TOrder order, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        //消费者操作
        log.info("收到消息开始消费，订单编号：{}",order.getId());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }

}

