**项目结构**
```
os4t
├─db  项目SQL语句
│
├─common 公共模块
│  ├─aspect 系统日志
│  ├─exception 异常处理
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息
│ 
├─modules 功能模块
│  ├─app API接口模块(APP调用)
│  ├─job 定时任务模块
│  ├─oss 文件服务模块
│  └─sys 权限模块
│ 
├─Os4tApplication 项目启动类
│
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源


**技术选型：** 
- 核心框架：Spring Boot 1.5
- 安全框架：Apache Shiro 1.3
- 视图框架：Spring MVC 4.3
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.0
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x 
<br> 


 **本地部署**
- 通过git下载源码
- 创建数据库os4t，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据
- 修改application-dev.yml，更新MySQL账号和密码
- Eclipse、IDEA运行Os4tApplication.java，则可启动项目
- 项目访问路径：http://localhost:8082/os4t
- 账号密码：admin/admin
- Swagger路径：http://localhost:8082/os4t/swagger/index.html


 **项目演示**
- 演示地址：http://118.25.6.199:8080/os4t/index.html
- 账号密码：admin/admin