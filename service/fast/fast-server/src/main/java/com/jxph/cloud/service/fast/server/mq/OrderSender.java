package com.jxph.cloud.service.fast.server.mq;

import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.server.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 谢秋豪
 * @date 2018/8/30 14:50
 */
@Component
@Slf4j
public class OrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OrderService orderService;

    /**
     * 回调函数：confirm确认
     */
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback(){
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String s) {
            log.info("correlationData:{}",correlationData);
            String messageId = correlationData.getId();
            if(ack){
                orderService.confirmMessage(messageId);
            }else {
                //补偿处理,根据mq broker原因(队列已满就没有必要重投等等)进行重投或补偿
                log.info("confirm error");
            }
        }
    };

    public void sendOrder(TOrder order){
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange","order.abcd",order,correlationData);
    }
}
