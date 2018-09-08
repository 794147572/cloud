package com.jxph.cloud.service.fast.server;

import com.jxph.cloud.service.auth.client.EnableAuthClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableSwagger2
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableAuthClient
@MapperScan(value = "com.jxph.cloud.service.fast.server.dao")
public class FastServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastServerApplication.class, args);
	}
}
