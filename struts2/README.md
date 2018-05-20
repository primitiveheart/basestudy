# struts2基本的知识点
## Servlet和Filter的区别
    serlvet：一般作为MVC的控制器
    Filter：也可以作为MVC中的控制器
    总结：Servlet能做的Filter都能做。但是Filter比Servler多了一个放行的功能。Filter完全能够替代Serlvet
## 搭建开发环境
    1、需要引入的包
    xwork-core.jar 和 struts2-core.jar
    2、在web.xml中配置核心的控制器，用于过滤所有的请求
    3、at the top of classpath 在创建一个固定名称struts.xml的配置文件
## 执行过程
    访问index.jsp也会经过框架的过滤器，由于后缀名不是action，过滤器直接放行

## struts2的配置文件
    1、struts2的配置文件在应用被加载(同时会初始化过滤器)。完成加载
    2、struts2的配置文件
        加载顺序    配置文件的名称     说明
        1           struts-default.xml
        2           struts-plugin.xml
        3           defulat.properties
        4           struts.xml          classpath top
        5           struts.properies
        6           web.xml
     总结:后面覆盖前面的。
    3、struts.xml的配置文件
    4、package元素
        属性name:要唯一，报的名称
        extends：struts2允许包与包之间可以继承，一般需要继承struts-default
                 在struts-default中定义struts2框架的核心内容
        abstract：如果一个包中，没有action元素，可以把包称为抽象，抽象包是被继承的
        namespace:名称空间，一般取值为/开头的字符串.名称空间+动作类的名称共同组成访问路径，
                默认值是：“”字符串
    5、action元素：配置动作
            属性：name：动作名称
                  class：动作类，是类的全限定名，可以不配，默认值：ActionSupport(在struts-default.xml中有配置)
                  method：动作方法的名称。可以不配，默认方法execute()
    6、动作方法执行前会经过很多的拦截器。虽然没有配置拦截器，但是有默认的拦截器在起作用(在struts-default.xml中有配置)
## Struts中的动作类
    1、动作类的编写
        方式一:动作类就是一个普通的javabean
        方式二：动作类实现Action接口
            接口中内容
            SUCCESS、NONE、ERROR、INPUT、LOGIN
            String execute() 默认的动作方法
        方式三:继承ActionSupport
     2、动作方法的调用
        动作类的生命周期：每次访问都会由框架进行实例化(多例的)
        请求的动作是什么，动作类需要编写对应的方法
        通配符 ：*
        DMI:动态方法调用。dynamic method invocation()不建议使用
            在struts，动态方法调用默认是关闭的
## struts2.xml其他配置
    1、常量配置
        在该配置文件中使用<constant>元素覆盖default。properties
    2、用多个struts配置文件
        <include file="user.xml></include>
## 动作类中访问servlet API
    与servlet进行深度解耦
    ServletContext、ServletRequest、HttpSession
        方式一:ServletActionContext
        方式二:动作类实现ServletContextAware和ServletRequestAware
     操作域对象的数据
     ActionContext操作域对象数据
        生命周期
            init:用户发出请求，就创建了ActionConext实例，存放到ThreadLocal
            process:一次请求范围中
            destroy:响应结束
## Struts2的结果类型
    1、用来产生结果输出
    2、struts.xml中相关配置
    action元素中配置元素result
     属性
        name：逻辑视图名称，它的值与当前动作方法的返回值对应。默认值是success
        type：结果类型。默认值:"dispatcher",请求转发
    3、struts常见的结果类型 
        在struts-default.xml中的struts-default的package中有定义
        
## 结果视图
    1、局部结果视图和全局结果视图
        局部视图:只能服务于当前的动作访问
        全局视图:访问动作时，在动作配置中找不到对应视图，则从全局视图中寻找
    2、自定义结果视图类型:CAPTCHA
        a、编写一个类，实现Result或者基础StrutsResultSupport
        b、声明结果类型
## 封装请求参数
    1、静态参数
        原理：struts2框架通过叫做staticParams拦截器
    2、动态参数(实际开发有关)
        动作类充当数据模型
            原理:strust2框架中actionMappingParams拦截器，完成动态参数注入
        动作类和数据模型分开
        模型驱动(ModelDrive)
            原理:strust2框架中modelDrive拦截器，完成动态参
      3、配合集合的使用
         用在批量添加数据时使用
## 用户注册案例
## 数据类型转换
    总结:
        保存数据到数据到数据库：String ----》其他类型
        显示数据:其他类型------>String
    1、Struts2中的类型转换简介
        日期：在Struts2会自动按本地日期格式转换
        类型转换失败:框架会自动转向一个name为input的视图，回显数据用的
    2、自定义类型转换器
        结论:继承DefaultTypeConverter，ConvertValue。也可以继承StrutsTypeConverter
        注册类型转换器
            1、局部类型转换器:安装属性名称进行注册
                类名-conversion.properties
                对象名称=全限定类名
            2、全局类型转换器:按照目标类型进行注册
              at the top of classpath，建立固定名称xworj-conversion.properties的配置文件
      3、类型转换失败的问题
            类型转换失败:框架会自动转向一个name为input的视图，回显数据用的
            
       小知识：struts2的错误回显是由一个conversionError拦截器负责
       所有的错误消息提示放到一个Map<String,String>(key:错误的名称，value：错误的消息)。
       拦截器如果没有发现Map中有元素，说明转换是失败，自动转向name=input的视图中，如果没有则是转换成功
## struts2中的ui标签
       表单有关的标签：数据回显和错误提示
## 数据验证
    验证：
    客户端验证:js
    服务器验证：java代码逻辑
    实际开发;客户端+服务器
    1、编程式是数据校验
        对动作类中所有的动作进行验证
            vadidate()
         对动作类进行某些动作进行验证
         方式一：@SkipValidation
         方式二：validateRegist()
    2、声明式数据校验(xml)
        对动作类中所有的动作进行验证
            动作类名-validation.xml
         对动作类进行某些动作进行验证
              动作类名-动作别名-validation.xml
     3、常用的内置的验证器
        
## struts2 中国际化
## struts2中的拦截器
    过滤器和拦截器是什么关系
        过滤器是Servlet的概念
        拦截器是Struts2的概念
     Struts2拦截器实现面向aop的编程
     1、自定义的拦截器
        直接实现Interceptor或者继承AbstractInterceptor
        配置拦截器
            声明拦截器
            在动作执行使用拦截器
        对动作类的所有方法进行了拦截
            AbstractInterceptor
        针对动作类中某个或某些方法进行拦截
            MethodFilterInterceptor
            如何配置
            <interceptor-ref>
                哪些需要进行拦截与不拦截
                <param name="excludeMethods">find</param
            </interceptor-ref>
            
            <interceptor-ref name=myDefaultStack>
                哪些需要进行拦截与不拦截
                <param name="interceter1.excludeMethods">find</param
            </interceptor-ref>
## 文件的上传和下载
    Struts2已经把文件上传做好了，通过fileupload的拦截进行
    文件下载：是由stream来完成的 resutl typr=stream
## OGNL的基本使用
    在struts2中充当el表达式的功能，获取数据显示到页面
    具体的功能
        在struts2中要想使用ognl的必须把OGNL表达式必须写在标签中
        1、支持对象方法的调用
        2、访问类的静态变量和静态方法（要开启struts.ognl.allowMethodAccess）
            <s:property value="@java.lang.Integer@MAX_VALUE"/>
        3、ognl可以创建集合
            创建list{元素,元素,}
            <s:radio list="{'1','0'}"></s:radio>
            创建Map #{key:value}
            
## ActionConext和ValueStack操作contextMap
    contextMap。它是每次struts2动作访问存放数据的中心
   ValueStack:每次动作访问都会创建该对象的实例
## OGNL的基本用法
    操作contextMap中的数据
    #：从contextMap中根据可以找对应的对象
    没有#:先从根中找对象的属性，没有找到，作为key从contextMap中找
## 模型驱动原理分析
## Struts2的常用通用标签
## Struts2中的常用的UI标签
## Struts2中的模板主题
## 防止表单的重复提交
    方案一：
        1、JS,防止用户点击多次按钮。但对刷新无效
        2、展现结果最好重定向
     方案二:
         令牌机制
            页面中
            生成唯一的token，放入到隐藏域和session中
            在action中
            比较session和隐藏域中的几个
            结果：一样，删除session的token
            不一样，
    