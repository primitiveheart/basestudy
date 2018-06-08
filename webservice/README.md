# web service的学习
    基于web的服务
    webservice两个系统的远程的调用
    webservice的调用是跨语言的
    
    Web服务的网址:http://www.webxml.com.cn/zh_cn/index.aspx
## java程序调用网络上web服务
    第一步：使用wsimport命令解析wsdl文件，生成本地代码
    第二步:将生成的代码复制到项目中
    第三步：调用本地代码
## WSDL和SOAP
    wsdl:web服务描述语言
        通过xml形式的说明服务在什么地方
        通过xml的形式说明服务提供什么样的方法
        WSDL称为webservice的说明书
    soap:简单对象访问协议
        soap=http+xml
        组成：
            envelop(必须)
            body(必须)
## 通过jdk发布一个web服务
    1、在类上使用@webservice注解
    2、在类中提供一个合法的方法(方法不能是static和final)
    3、发布服务
        EndPoint.publish
    4、访问当前发布的服务对应的wsdl
        服务的地址+?wsdl
## SOAP 1.1和1.2
    1、命名空间不同
    2、头信息有差异
    3、生成的wsdl的文件的内容不同
## wsimport的使用
## webservice客户端调用服务的方式
    注意：soap协议的webservice服务，http的请求必须为post方式请求
    监听工具tcp/ip
### 使用wsimport命令生成本地代码调用
### ajax调用
    请求体要符合soap协议
### urlconnection调用
### 客户端编程方式
## 使用注解方式修改wsdl文件内容
    @WebService
    @WebMethod(exclude=true)使用exclude不对外发布服务
    @WebParam()修改参数名
    @WebResult修改返回值名称
# cxf学习
## 在javase项目中开发cxf框架的webservice
    CXF发布服务的类
    ServerFactoryBean
    JaxWsServerFactoryBean
        类的方法必须使用@WebService
## 给消息添加拦截器
    LoggingInInterceptor:添加一个拦截请求的消息的拦截器
    LoggingOutInterceptor:添加一个拦截响应的消息的拦截器
## 在web项目中开发cxf框架的webservice
    在web.xml配置一个CXFServlet
    在web-inf下提供CXF框架的配置默认的cxf-servlet.xml
    开发一个提供服务的类
    在cxf-servlet.xml配置服务
        第一种发布方式:没有接口的发布
            <jaxws:endpoint id= address="/hello" implementor="">
                <jaxws:inInterceptors>
                    <bean class="LoggingInInterceptor">
                </jaxws:inInterceptors>
            </jaxws:endpoint>
        第二种发布方式:带有接口的发布
            serverClass:接口类型
            <jaxws:server address="" serverClass="">
                <jaxws:serviceBean>
                    <bean class>
                </jaxws:serviceBean>
             </jaxws:server>
## RESTFul方式的webservice服务