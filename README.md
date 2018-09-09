# cloud
整合SpringBoot 2.0.4、SpringCloud(Finchley.SR1)、MyBatis、Redis、RabbitMQ的代码脚手架<br>
目前主要分为common（通用）、api-gateway（网关）、eureka（注册中心）、monitor（监控）、service（服务）模块<br>
服务模块分为auth、fast模块，auth模块分为api、client、server，其中client是公共启动项的抽取，fast分为api、server
# 基本组件/功能
* Jwt加密解密
* eureka注册中心
* hystrix熔断与降级
* feign服务调用
* zuul网关
* redis集群缓存
* rabbitMQ，实现消息100%投递
* turbine、actuator监控
* 分布式定时任务(scheduled+redis分布式锁)
* 注解方式动态切换数据源
# 服务启动
修改auth.server与fast.server模块中的application-dev.properties文件，修改文件中jdbc，rabbitmq和redis配置
# 计划
目前的RabbitMQ是未封装的，接下来会封装RabbitMQ组件到一个独立模块，有时间的话会写一个完整的后台管理类项目以及前台的基本模块
