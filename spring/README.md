# spring 的学习
## spring的核心
    IoC(控制反转)和AOP(面向切面编程)
## Spring的IOC
    IOC的底层原理实现是：工厂+反射+配置文件
    控制反转:创建对象的控制权被反转给了spring
    DI:Dependency Injection 依赖注入，在spring框架负责创建bean对象时，动态的将依赖的对象注入到bean组件
    DI:spring创建对象的过程中，将这个对象的属性设置进来
        面向对象中：
            对象之间的关系
                依赖：
                    class A{
                        private B b;
                        public B getB(){}
                    }
                继承：is a 是一个
                组合：has a （有一个）
                    松散
                    紧密
### ApplicationContext接口的实现类
    ClassPathXmlApplicatonContext:读取classpath下的applicationContext.xml
    FileSystemXmlApplicationContext:读取磁盘下的applicationContex.xml
### ApplicaitonContext和BeanFactory关系
    ApplicationContext继承了BeanFactory
    BeanFactory采取延迟加载，第一次getBean时才会初始化bean
    ApplicationContext：加载配置文件时创建bean
### spring的装配Bean(xml)
#### spring创建bean的方式
    1、采用默认无参数的构造器创建
         <bean id="bean1" class="com.spring.demo2.Bean1"></bean>
    2、采用静态工厂实例化
        <bean id="bean2" class="com.spring.demo2.Bean2Factory" factory-method="getBean2"></bean>
    3、采用实例工厂实例化
        <bean id="baen3Factory" class="com.spring.demo2.Baen3Factory"></bean>
        <bean id="bean3" factory-bean="baen3Factory" factory-method="getBean3"></bean>
#### bean的其他配置
    1、id和name配置
    <bean>
        id:必须唯一，而且不能包含特殊字符
        name:没有唯一的要求，而且可以出现一些特殊的字符的
     2、Bean的作用范围
     <bean>
        scope:
            singleton:spring创建一个bean市，使用的是单例
            prototype：spring创建一个bean市，使用的是多例
            request：在web中使用，创建一个bean，将这个bean存到request的作用范围中
            session：在web中使用，创建一个bean，将这个bean存到session的作用范围
            globalSession：web应用中使用，一般用于Porlet应用环境，如果不是porlet环境，globalSession与session一样
        ***在实际开发中使用single通和prototype
      3、bean的生命周期
         通过配置<bean init-method="" destroy-method\">
             init-method :初始化方法
             destroy-method：销毁的方法
                销毁使用条件：对象是单例创建的，必须关闭工厂才可以销毁
          正常bean生命周期总十一步：
            1、instantiate bean对象实例化
            2、populate properties 封装属性
            3、如果bean实现BeanNameAware执行setBeanName
            4、如果bean实现BeanFactoryAware或者ApplicationContextAware设置工厂setBeanFactory或者设置上下文对象setApplicationContext
            5、如果存在类实现BeanPostProcessor（后处理bean），执行postProcessBeforeInitialization
            6、如果Bean实现initializingBean执行afterPropertiesSet
            7、调用<bean init-method="init">指定初始化方法init
            8、如果存在类实现BeanPostProcessor(处理bean)，执行ostProcessAfterInitialization
            9、执行业务处理
            10、如果bean实现DisposableBean执行destroy
            11、调用<bena destroy-method="">执行指定的销毁方法
            
            ***第三步和第四步：让bean了解spring容器
            ***BeanPostProcessor：由spring容器自动调用
                工厂钩子：钩子函数，允许用户扩展bean
#### spring装配bean过程中的属性注入(DI)
      对成员变量注入的方式有：
          1、接口注入
            public interface Injection(){
                public void setName(String name);
            }
            
            public class UserService implements Injection{
                 private String name;
                 public void setName(String name){
                    this.name = name;
                 }
            }
          2、构造器注入
            public class UserService{   
                ptivate String name;
                public UserService(String name){
                    this.name = name;
                }
            }
          3、set方法注入
                public class UserService{
                     private String name;
                     public void setName(String name){
                        this.name = name;
                     }
                }
            
        spring的属性注入方式：
            1、构造器
            2、set方式注入
        spring2.5之后提供p名称空间注入
            1、引入p名称空间
                xmlns:p="http://www.springframework.org/schema/p"
            2、使用p名称
                p:属性=“”
                p:属性-ref=""
         spring3.0中提供SpEL注入
            SpEL：spring expression Language
                #{SpEL}
          集合属性的注入
#### spring开发的分文件的配置
    方式一：
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext2.xml","applicationContext3.xml");
    方式二:在核心配置文件中配置
        <import resource="ApplicaitonContext2.xml">
### spring的装配Bean(注解方式)
#### 基于注解的bean的装配
    @Component("userService")
    在applicationContext.xml中配置<context:component-scan/>
#### Component的衍生注解
    @Component注解
        spring中提供了3个与Component注解功能一致的注解
        @Controller :修饰web层的类
        @Service    :修饰业务的类
        @Repository  :修饰dao的类
#### 属性的注入
    注解的方式属性注入分两类
        普通属性:
            @Value:修饰属性或者是修饰属性的set方法，但是如果修饰属性了，这个属性可以没有set方法
        对象属性
            @Autowired：修饰属性或者是修饰属性的set方法，但是如果修饰属性了，这个属性可以没有set方法
                @Autowired:自动注入，按类型注入
            @Qualifier:按名称注入，但是必须跟@Autowired一起使用
            @Resource:相当于@Autowired和@Qualifier注解效果一致
#### bean的生命周期和作用范围
    生命周期
        1、PostConstruct：初始化的
        2、PreDestroy:销毁
    作用范围：
        @Scope
            singleton
            prototype
#### xml开发和注解开发
    xml：
        结构清晰
    注解：
        属性注入：
    xml和注解的整合开发：
        结合点:bean还是由spring核心配置文件
            属性注入使用注解：<context:annotation-config>:开启属性注入的注解
#### spring3.0基于BeanConfig的管理
    定义一个java类：这个java相当于一个配置文件
#### 总结
    如果一个类不是自定义：来自于框架提供，这中方式的注入需要使用xml不能使用注解
#### spring 整合web项目
    web开发中引入一个jar
        spring-web.jar
            提供一个监听器ContextLoaderListener加载spring的环境
            监听器默认加载web-inf下的applicationContext.xml
     在servlet中获得工厂
#### spring整合Junit单元测试
    1、项目中有junit环境
    2、引入jar的spring-test.jar
    
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextCofiguration("classpath:applicationContext.xml)
 
## Spring的AOP
    AOP可以进行性能监视、事务管理、安全检查和缓存
### spring的传统的AOP
#### AOP的相关术语
    Joinpoint(连接点)：所谓连接点是指那些被拦截到的点。在spring中。这些点指的是方法，因为spring支持方法类型的连接点
    pointcut(切入点)：所谓切入点是指我们要对那些joinpoint进行拦截的定义
    advice(通知/增强):就是增强的代码(方法上的增强)。所谓通知是指拦截到joinpoint之后所要做的事情就是通知，通知分为前置通知、后置通知、异常通知、最后通知和环绕通知
    introduction(引介)：(类上增强)引介是一种特殊的通知在不修改类代码的前提下，introduction可以在运行期为类动态添加一些方法或自字段
    target(目标对象):代理的目标对象
    weaving(织入)：在目标对象上应用增强的过程。是指把增强应用到目标对象来创建新的代理对象的过程
    spring采用动态代理织入，而aspectj采用编译期织入和类装在期织入
    proxy(代理):一类被aop织入增强后，就产生一个结果代理类
    aspect(切面)：是切入点和通知(引介)的结合
#### AOP的底层实现
    aop底层实现就是代理机制
    动态代理：
    JDK动态代理：对实现接口的类产生代理
    CGLib动态代理：对没有实现接口的类产生代理
        cglib生成代理原理：使用底层的字节码技术，对目标类生成子类
### spring的传统的AOP
    spring按照通知advice在目标类方法的连接点的位置
        前置通知；MethodBeforeAdvice
        后置通知 AfterReturningAdvice
        环绕通知：MethodInterceptor
        异常抛出通知:ThrowableAdvice
        引介通知
     spring aop的切面类型
        Advisor：代表一般切面，advice本身就是一个切面，对目标类的所有方法进行拦截(不带切点的切面)
        PointcutAdvisor:代表具有切点的切面，可以指定拦截目标类哪些方法(带有切点的切面)
     自动代理
        基于ProxyFactoryBean的方式为类生成代理的过程，需要为每个类都要进行配置，开发维护比较难
        使用Spring的AOP自动代理
            BeanNameAutoProxyCreator
            DefaultAdvisorAutoProxyCreator
            AnnotationAwareAspectJAutoProxyCretor
      自动代理的原理：
        基于BeanPostProcesser完成代理
      自动代理和ProxyFactoryBean有什么区别
        ProxyFactoryBean：先有目标对象，将目标对象传入到代理对象中，生成代理对象
        自动代理基于BeanPostProcesser代理方式，生成这个bean的时候要执行后处理bean，返回bean就是代理对象
### spring的AspectJ的AOP
    切面的定义：
        @Aspect:在类上使用注解，类是一个切面
    通知的定义:
        @Before
        @AfterReturing
        @Around
        @DeclareParents（引介）
        @AfterThrowing
        @After
     切点表达式语言
        语法：execution(访问修饰符? 方法返回值 方法名(参数))
     在applicationContext.xml开启aspectJ注解<aop:aspectj-autoproxy/>

#### Aspectj通知类型的详解
    @Before 传入的参数JoinPoint
    @AfterReturing(returining="result") 传入的参数JoinPoint，可以获取返回值Object result 
    @Around:阻止目标执行 ProceedingJoinPoint
    @DeclareParents（引介）
    @AfterThrowing(throwing="e)：获取异常信息 Throwable e
    @After:最终通知，总是会执行
#### 切点定义
    切面中包含切入点和通知
    切入点定义
    @Pointcut("ececution=()")
    private void mypointcut(){}
    使用切入点
    @After("MyAspect.mypointcut()")
### Aspectj的xml格式开发
    <aop:config>
        <aop:pointcut expression="" id="mypointcut"/>
        <aop:aspect ref="myAspect">
            <oap:before method="before" pointcut-ref="mypointcut">
        </aop:aspect>
     </aop:config>
### spring的JdbcTemplate
    JDBC JdbcDaoSupport
    hibernate HibernateDaoSupport
    ibatis SqlMapClientDapSupport
    在dao中继承相应Support类就行可以
### spring的事务管理
#### springg管理事务
    spring提供了一组事务管理的api
    PlatformTransactionManager:平台事务管理器
    TransactionDefinition：事务定义信息
    TransactionStatus：事务状态
    
    PlatformTransactionManager:平台事务管理器
        1、commit()
        2、getTransaction()
        3、rollback()
        
     TransactionDefinition：事务定义信息
        ISOLATION_XXX:事务的隔离级别
        PROPAGATION_XXX:事务的传播行为,解决业务层的相互调用
            REQUIRED:支持当前事务，如果不存在，就新建一个
                如A,B，如果A中有事务，那么B就使用A中的事务，如果A没有事务，那么B就会创建一个事务，（A,B在同一个事务中）
            SUPPORTS：支持当前事务，如果不存在，就不使用事务
            MANDATORY：支持当前事务，如果不存在，抛出异常
            
            REQUIRED_NEW：如果事务存在，挂起当前事务，创建一个新的事务
                A,B。如果A中有事务，B将A的事务挂起，创建一个新的事务。如果A没有事务，创建一个新的事务运行B(A,B事务不在同一个事务)
            NOT_SUPPORTED
            NEVER
            
            NESTED:如果当前事务存在，则嵌套事务执行
      
      TransactionStatus：事务状态
      
#### 编程式的事务
     配置事务管理器
        DataSourceTransactionManager
     配置事务管理的模板
        TransactionTemplate
#### 声明式的事务
    实际是：aop思想
    配置事务管理器
          