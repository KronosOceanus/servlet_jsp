[TOC]

# JDBC深入

## mysql用户（用户信息储存在mysql数据库的user表中）

### 创建一个名字为user，密码为password的用户（*表示可以从任意ip地址访问）
```sql
create user 'user'@'ip' identified by 'password';
```
### 删除用户
```sql
drop user 'user'@'ip';
```
### 修改用户
```sql
rename user 'user'@'ip' to 'newUser'@'newIp';
```
### 修改密码
```sql
set password for 'user'@'ip' = password('newPassword');
```
### 查看权限
```sql
show grants for 'user'@'ip'
```
### 授权操作
表也可以用*通配符
```sql
grant 权限 on 数据库.表 to   'user'@'ip';
 
//all privileges  除grant外的所有权限
            select          仅查权限
            select,insert   查和插入权限
            ...
            usage                   无访问权限
            alter                   使用alter table
            alter routine           使用alter procedure和drop procedure
            create                  使用create table
            create routine          使用create procedure
            create temporary tables 使用create temporary tables
            create user             使用create user、drop user、rename user和revoke  all privileges
            create view             使用create view
            delete                  使用delete
            drop                    使用drop table
            execute                 使用call和存储过程
            file                    使用select into outfile 和 load data infile
            grant option            使用grant 和 revoke
            index                   使用index
            insert                  使用insert
            lock tables             使用lock table
            process                 使用show full processlist
            select                  使用select
            show databases          使用show databases
            show view               使用show view
            update                  使用update
            reload                  使用flush
            shutdown                使用mysqladmin shutdown(关闭MySQL)
            super                   􏱂􏰈使用change master、kill、logs、purge、master和set global。还允许mysqladmin􏵗􏵘􏲊􏲋调试登陆
            replication client      服务器位置的访问
            replication slave       由复制从属使用
```
