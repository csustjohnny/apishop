# API商店部署手册

## 一、使用的技术：

**前端：**html, css, bootstrap, vue

**后端**：spring, springMVC, mybatis框架，mysql数据库, maven工具，redis缓存, niginx方向代理，多个tomcat集群部署。

**前后端分离：**此项目开发中借用了一个免费的内网穿透工具Ngrok。效果为：前缀为csust，映射的端口为本机8888。

## 二、部署步骤：

1、打包，把maven打包成war包。

2、部署：把war包放在tomcat的webapps目录下并改名为ROOT

3、改端口：因为此次部署是在一台电脑同时部署多个tomcat，会出现端口占用问题，把其中的一台改为8111

4、把前端代码部署在nginx

5、反向代理：此次让nginx监听的8888端口

```
server{
	listen 8888;
	server_name localhost;
}
```

然后反向代理到8111端口和8080端口

```
upstream tomcat_8111_8888{
	server 127.0.0.1:8111 weight = 1;
	server 127.0.0.1:8080 weight = 2;
}
location / {
	proxy_pass http:/tomcat_8111_8888
}
```

6、打开redis。

7、测试：首先访问8080端口

![8080](\img\8080.png)

然后是8111端口

![8081](\img\8081.png)

最后是8888端口：

![8888端口](\img\8888.png)

8、1，session共享问题：本项目采用重写shiro的EnterpriseCacheSessionDAO方式使用redis缓存sessionid，达到session共享的目的。