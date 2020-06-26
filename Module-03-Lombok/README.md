# lombok的使用

案例运行在/test/下  
`LombokTest` Lombok的使用展示,实体类在`/model/UserWithLombok.java`中

## 依赖

一般使用springboot的redis时直接去用starter,里面包含了spring-data-redis和redis线程池lettuce(可以通过依赖得以确认)

```xml
<!--lombok-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

```
