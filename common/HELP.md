# 公共模块
设计思想是通过`bom`来做版本管理，对不同功能做分模块，`core`作为核心，为大部分项目所需要用到的，其他功能性模块，项目需要用到引用即可，避免简单项目引入过多依赖。

- `common-bom` 对`common`包下的子模块做版本控制，在引用时避免写版本号。
- `common-core` `common`的核心包，用于放置通用的`utils`、`exception`、`dto`、`form`等等。
- `common-swagger` `swagger`相关，引用该模块，即拥有`swagger`的能力。      
- `common-datasource` 数据连接能力   
- `common-security` oauth2客户端