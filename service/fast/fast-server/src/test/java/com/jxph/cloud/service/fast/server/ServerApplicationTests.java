package com.jxph.cloud.service.fast.server;

import com.jxph.cloud.service.fast.api.pojo.TOrder;
import com.jxph.cloud.service.fast.server.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private OrderService orderService;

	@Test
	public void testCreateOrder() throws Exception{
		TOrder order = new TOrder();
		order.setId("201808300000003");
		order.setName("测试");
		order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
		orderService.createOrder(order);
	}
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedis(){
		redisTemplate.opsForValue().set("test","test",60, TimeUnit.SECONDS);
		Object test = redisTemplate.opsForValue().get("test");
		System.out.println(test);
	}
}
