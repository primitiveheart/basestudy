# jax-rs的学习
## jersey的学习
  [Java Jersey使用总结](https://blog.csdn.net/u010395804/article/details/38398149)
## 在java EE项目中的应用
### 两种方式
    第一种方式:
         <init-param>
            <param-name>javax.ws.rs.Application</param-name>
            <param-value>com.zgb.APIApplication</param-value>
        </init-param>
    第二种方式:
       <init-param>
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>com.zgb</param-value>
        </init-param>
        <init-param>
            <param-name>jersey.config.server.provider.classnames</param-name>
            <param-value>org.glassfish.jersey.jackson.JacksonFeature</param-value>
        </init-param>
        
## 在javase项目中的应用
    [Jersey框架—基于JavaSE创建简单RESTful服务](https://www.jianshu.com/p/8b1b4b4717ff)