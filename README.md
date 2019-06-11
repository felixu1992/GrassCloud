# GrassCloud
随便玩玩，微服务构建的企业协同系统

所用技术：

- Spring Cloud
- Spring Boot
- Mybatis-Plus
- Redis
- RabbitMQ

模块介绍：

- common：公共模块
- eureka-server：注册中心
- config-server：配置中心
- gateway-server：网关
- generator-server：代码生成
- monitor-server：监控
- oauth-server：授权认证中心
- base-server：用户服务，即整个微服务中最核心的服务

任务列表：

- [x] 基础模块创建
- [x] 基础Spring Cloud运行起来
- [ ] 整理依赖
- [ ] 使用Spring Cloud Oauth2授权认证
- [ ] Base服务，即用户服务构建
- [ ] 完善Base服务    
. . . . . . 

规约：   
大体遵循阿里规范    
暴露到外部的接口走外部`Controller`    
架构内部调用走`InnerController`    
请求入参使用`Form`后缀，使用validation做基础校验     
出参使用`DTO`后缀     
统一返回结果，包括错误返回