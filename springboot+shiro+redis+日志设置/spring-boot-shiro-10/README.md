## 数据库初始化
> 0.以root权限登录mysql数据库
```
mysql -uroot -p
```
> 1.创建数据库
```
create database testshiro default character set utf8 collate utf8_general_ci;
```
> 2.创建用户
```
create user 'shiro'@'%' identified by 'shiro';
```
> 3.给用户授权
```
grant select,insert,update,delete,create,drop,alter on testshiro.* to shiro;
```
> 4.使用权限生效
```
flush privileges;
```