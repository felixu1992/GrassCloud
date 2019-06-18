# 公共模块
设计思想是通过`bom`来做版本管理，对不同功能做分模块，`core`作为核心，为大部分项目所需要用到的，其他功能性模块，项目需要用到引用即可，避免简单项目引入过多依赖。

- `common-bom` 对`common`包下的子模块做版本控制，在引用时避免写版本号。
    - maven的版本控制
- `common-core` `common`的核心包，用于放置通用的`utils`、`exception`、`dto`、`form`等等。
    - 放一些通用工具类，实体，依赖等
- `common-swagger` `swagger`相关，引用该模块，即拥有`swagger`的能力。 
    - 提供`grass.swagger.xxx`形式的yml配置     
- `common-datasource` 数据连接能力   
- `common-security` oauth2客户端
- `common-logging` 用于收集操作日志
    - 使用方法，使用`grass.logging.enable=true`开启日志收集，默认引入即开启，在`controller`需要被收集的方法上加上`@AccessLogger`注解即可被收集，
    注解里的属性用以描述当前方法的作用，其原理是利用`AOP`拦截方法请求前和请求后，然后通过`RabbitMQ`异步将日志发送到日志服务收集入库