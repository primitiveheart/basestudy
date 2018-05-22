# springMVC
     组件：
        1、前端控制器DispatcherServlet
        作用接收请求，响应结果，相当于转发器
        2、处理器映射器HandlerMapping
        作用：根据请求的url查找handler
        3、处理器适配器HandlerAdapter
        作用:按照特定的规则(HandlerAdapter要求的规则)去执行Handler
        4、处理器Handler
        注意:编写Handler时按照HandlerAdapter的要求去做，这样适配器才可以去正确的执行Handler
        5、视图解析器View Resolver
         作用:进行视图解析，根据逻辑视图名解析成真正的视图(View)
        6、视图View
        View 是一个接口，实现类支持不同的View类型
## 前端控制器
    在web.xml中配置DispatcherServlet，使用contextConfigLocation来加载xml文件
## 处理器映射器
    在springmvc.xml中配置处理器映射器
    非注解
        第一种方式:
        <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
        第二种方式:
        <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
            <property name="mappings">
                <props>
                    <prop key="/http">httpController</prop>
                </props>
            </property>
        </bean>
    注解
        <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"></bean>
        <mvc:annotation-driven></mvc:annotation-driven>
## 处理器适配器
    在springmvc.xml中配置处理器适配器
    非注解
        第一种方式：
        <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
        第二种方式：
        <bean class="org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter"></bean>
    注解
        <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"></bean>
        <mvc:annotation-driven></mvc:annotation-driven>
## handler
    非注解
        第一种方式:
        <bean name="/simple" class="controller.SimpleController"></bean>对应
        的类是 public class SimpleController implements Controller 
        第二种方式:这个方式没有返回值，可以设置json来设置响应response
        <bean id="httpController" class="controller.HttpController"></bean>对应的类是
        public class HttpController implements HttpRequestHandler 
    注解
        <context:component-scan base-package="controller"></context:component-scan>
        @Controller
        public class AnnotationController
## 视图解析器
    在springmvc.xml中视图解析器
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/page/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
## 视图编写
## 绑定参数
    1、默认支持的类型
        HttpServletRequest
        HttpServletResponse
        HttpSession
        Model/ModelMap:将model填充到request域中
    2、简单类型
        @RequestParam对简单类型的参数进行绑定
        如果不使用@Request，要求request传入的参数名称和controll而的名称一致
        如果使用，可以不一致
    3、绑定pojo
    4、自定义参数绑定
        将请求参数的日期数据串转成换成日期类型
        要转换的日期类想要和pojo的日期属性的类型一致
        1、实现Converter转换器的接口
        2、需要向处理器适配器中注入自定义参数邦定
     5、包装类型的pojo参数绑定
        pojo中属性是pojo
        页面和controller方法参数
        页面参数
            <input name="itemCustom.name">
        controller的方法参数
             public String query(ItemCustomVo itemCutsomVo)
             ItemCustom{
                Item Item;
                ItemCustome itemCustom
             }
     6、集合参数绑定
        数组绑定
        list绑定
            放到包装类型的pojo中
        map绑定
            放到包装类型的pojo中
## 结果类型
    1、返回ModelAndView
    2、返回String，返回的是逻辑视图名称
        redirect重定向
        forward页面转发
    3、返回void，需要加上注解@ResponseBody
        指定响应结果
## 服务端数据校验
     服务端校验
        控制层Controller：校验页面请求的参数的合法
        在服务端校验控制层controller校验，不区分客户端类型
     springmvc使用hibernate的校验框架validation(和hibernate框架无关)
     校验需要引入的jar
     hibernate-validator-4.3.0.Final.jar
     jboss-logging-3.1.0.CR2.jar
     validation-api-1.0.0.GA.jar
     1、配置
## 数据回显
    1、pojo的数据进行回显
    2、@ModelAttribute
    3、使用model
## 处理异常
    系统的dao、service、controller 出现都通过throws Exception，最后由DispatcherServlet前端控制器交由异常处理器进行异常处理
    springmvc提供全局异常处理器(一个系统只有一个异常处理器)进行统一的异常处理
    1、自定义异常类
        对不同的异常类型定义异常类
        编写异常类继承Exception
    2、全局异常处理器
        a、解析出异常类型
        b、如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
        c、如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型("信息为“未知错误")
        编写异常处理器实现HandlerExceptionResolver
    3、错误页面
    4、在springmvc.xml配置异常处理器
        
## 上传图片
    springmvc对多部件类型的解析
    在spring.xml中配置multipart类型解析器
    <bean class="CommonsMultipartResolver">
    MultipartFile
    创建虚拟目录
        注意：文件要按分目录进行存储，来增加i/o的性能
     
## Json
## RESTful
## 拦截器
    定义拦截器:实现了HandlerInterceptor
        a、编写拦截类，实现HandlerInterceptor
        b、拦截器的配置

    一、springmvc拦截器针对HandlerMapping进行拦截设置
    二、springMvc配置类似全局的拦截器，springmvc框架将配置的类似全局的拦截器注入到每个每个HandlerMapping中
        <!-- /** 表示拦截所有的url包括url子路径-->
        <mvc:mapping path="/**>
    1、进入hanler执行之前 preHandler
        身份认证和身份授权
        return false :表示拦截
        return true ：表示方向
    2、进入handler之后，在返回modelAndView之前 postHandler
        将公用模型数据放在这里
    3、执行Handler完成执行此方法 afterCompletion
        统一的异常处理和统一的日志处理