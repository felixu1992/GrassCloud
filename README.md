# GrassCloud
随便玩玩，微服务构建的企业OA系统

所用技术：

- Spring Cloud
- Spring Boot
- Mybatis-Plus
- Redis
- RabbitMQ

模块介绍：

- common：公共模块
- eureka-server：注册中心，端口8761
- config-server：配置中心，端口8762
- gateway-server：网关，端口8763
- monitor-server：监控，端口8764
- oauth-server：授权认证中心，端口8765
- base-server：用户服务，端口7761
- generator-server：代码生成，端口7762

任务列表：

- [x] 基础模块创建
- [x] 基础Spring Cloud运行起来
- [x] 整理依赖
- [x] 使用Spring Cloud Oauth2授权认证
- [ ] 用户服务
- [ ] 日志服务
- [ ] 数据字典服务
- [ ] 文件上传服务
- [ ] sms消息服务
- [ ] 邮件服务
- [ ] 考勤服务
- [ ] 工作流服务
. . . . . . 

当前任务：    
**用户服务**

规约：   
大体遵循阿里规范    
暴露到外部的接口走外部`Controller`    
架构内部调用走`InnerController`    
请求入参使用`Form`后缀，使用`validation` 做基础校验     
出参使用`DTO`后缀     
统一返回结果，包括错误返回