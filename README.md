# GrassCloud

随便玩玩，微服务构建的企业OA系统

## 技术栈

- Spring Cloud
- Spring Boot
- Mybatis-Plus
- Redis
- RabbitMQ

## 模块描述

|                             模块                             |   描述   | 端口 |
| :----------------------------------------------------------: | :------: | :--: |
| [common](<https://github.com/felixu1992/GrassCloud/blob/master/common/HELP.md>) | 公共模块 |      |
| [eureka-server](<https://github.com/felixu1992/GrassCloud/blob/master/eureka-server/HELP.md>) | 注册中心 | 8761 |
| [config-server](<https://github.com/felixu1992/GrassCloud/blob/master/config-server/HELP.md>) | 配置中心 | 8762 |
| [gateway-server](<https://github.com/felixu1992/GrassCloud/blob/master/gateway-server/HELP.md>) | 路由网关 | 8763 |
| [monitor-server](<https://github.com/felixu1992/GrassCloud/blob/master/monitor-server/HELP.md>) | 监控中心 | 8764 |
| [oauth-server](<https://github.com/felixu1992/GrassCloud/blob/master/oauth-server/HELP.md>) | 认证中心 | 8765 |
| [base-server](<https://github.com/felixu1992/GrassCloud/blob/master/base-server/HELP.md>) | 用户服务 | 7761 |
| [generator-server](<https://github.com/felixu1992/GrassCloud/blob/master/generator-server/HELP.md>) | 代码生成 | 7762 |
| [logging-server](<https://github.com/felixu1992/GrassCloud/blob/master/logging-server/HELP.md>) | 日志服务 | 7763 |

## 开发规约
1. 大体遵循阿里规范
2. 暴露到外部的接口走外部`Controller` 
3. 架构内部调用走`InnerController`
4. 请求入参使用`Form`后缀，使用`validation` 做基础校验
5. 出参使用`DTO`后缀
6. 统一返回结果，包括错误返回

## 代办任务

- [x] 基础模块创建
- [x] 基础Spring Cloud运行起来
- [x] 整理依赖
- [x] 使用Spring Cloud Oauth2授权认证
- [ ] 基础架构整理
- [ ] 用户服务
- [ ] 日志服务
- [ ] 数据字典服务
- [ ] 文件上传服务
- [ ] sms消息服务
- [ ] 邮件服务
- [ ] 考勤服务
- [ ] 工作流服务
  . . . . . . 

## 当前任务
**基础架构整理**

> 由于接下来要专注于别的事情，暂时放缓更新速度，两个月后再加速迭代速度
>
> 遗留问题：服务名称修改，依赖整理