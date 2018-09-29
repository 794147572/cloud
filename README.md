##cloud
整合SpringBoot 2.0.4、SpringCloud(Finchley.SR1)、MyBatis、Redis、RabbitMQ的代码脚手架<br>

目前主要分为common（通用）、api-gateway（网关）、eureka（注册中心）、monitor（监控）、service（服务）模块<br>
服务模块分为auth、fast模块，auth模块分为api、client、server模块，client模块是公共启动项的抽取，fast分为api、server模块

##基本组件/功能

* Jwt加密解密
* eureka注册中心
* hystrix熔断与降级
* feign服务调用
* zuul网关
* redis集群缓存
* rabbitMQ，实现消息100%投递
* turbine、actuator监控
* scheduled+redis分布式锁
* 注解方式动态切换数据源

##服务启动
修改auth.server与fast.server模块中的application-dev.properties文件，修改文件中rabbitmq和redis的配置
