[TOC]
## Http3
#### 发送 Excel 表格 / 图片 等
```java
    resp.setContentType("application/vnd.ms-excel");

    resp.setContentType("image/jpeg");
```
可以设置 Excel 表格类型，每次输出一行，间隔线用\
#### 刷新请求
```java
    resp.setIntHeader("Refresh",5) 
```
* 显示计算复杂的网页（例如计算得到位数很大的质数，分多次请求显示）
* 配合缓存使用