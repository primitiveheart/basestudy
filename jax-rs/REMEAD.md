# jax-rs的学习
## jersey的学习
  [Java Jersey使用总结](https://blog.csdn.net/u010395804/article/details/38398149)
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