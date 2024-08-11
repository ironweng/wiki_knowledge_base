# Myprofile知识库系统

##项目描述
基于SpringBoot+Vue3的一个使用方便的电子资源管理平台，用于打造一个专属的知识库系统

##技术栈
SpringBoot ，SpringMVC，Mybatis，MySQL， Redis， RocketMQ，Websocket，Vue3， Nginx

##相关内容简述
基于Vue3和SpringBoot实现前后端的功能开发，使用Maven管理项目，规范开发流程；使用Nginx服务器部署静态资源，实现反向代理；使用Git远程仓库管理代码；
使用Redis+token的方案实现单点登录功能；使用异步线程和RocketMQ实现点赞通知功能的异步解耦；通过WebSocket建立客户端与服务器的长连接，实现点赞实时通知功能；使用Spring定时任务执行电子书信息更新SQL；
使用模板引擎Freemarker配合Mybatis Generator快速完成单表的增删改查管理功能，提升后续代码的开发效率；基于ThreadLocal和拦截器封装分页参数，避免多层级传递，提高性能；
在数据库优化方面：采用主动更新+超时删除的方案解决缓存一致性问题；结合业务场景适当设置数据库冗余，提升查询速度；主从表中设置唯一键关联来提升查询效率等。
