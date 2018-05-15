# jdbc 基本知识
 java database connectivity java语言操作数据库
## 最原生的java操作数据库
### DriverManager
     1、注册驱动 DriverManager.register（new Driver）注册了两次，一般使用Class.forName（"数据库驱动"）
     2、获取数据库的链接
### Connection
     1、创建执行SQL语句对象
        connection.createStatement()
        connection.prepareedStatement(Sting sql) 支持sql预编译(防止sql注入)
        connection.preparedCall(String sql) 执行数据库存储过程
     2、管理事务
        setAutoCommit
        commit();
        rollback()
### Statement:执行sql语句
    1、执行sql语句
        ResultSet executeQuery(String sql); select
        int executeUpdate(String sql); insert、update、delete int 影响的函数
        execute(String sql); selectt返回true与inser、update和delete返回false
    2、执行批处理
        addBatch(String sq;)
        executeBatch()
        clearBatch()
    
### ResultSet
      封装返回的是查询的结果，类似于表格的形式
      
### 释放资源
    if(connetion != null){
        try{
            //释放资源
            connection.close();
        }catch(Exception e){
            
        }
        conneciotn = null;//尽早让垃圾收集器回收
    }

### DAO的模式(封装数据源和单个操作)
       servlet + jsp + javabean + JDBC。比较底层
       SSH(Structs2 + spring + hibernate)
       SSM(SpringMVC + Spring + Mybatis)
       
### 批处理
       addBatch(String sq;)
       executeBatch()
       clearBatch()
### 数据库事务
        第一种方式：
            开启事务
            start transaction
            sql
            rollback或commit
        第二种方式
            MYSQL数据库事务默认是提交，设置不让自动提交
#### 设置事务的回滚点(保存点)  
        设置保存点
        sp = connection.setSavePoint()
        rollback(sp)//回滚到保存点
#### 事务的特性
    1、原子性
    2、一致性：事务前后数据的完整性必须保持一致
    3、隔离性：多个用户并发访问数据库时，一个用户的事务不能被其它用户的事务所干扰，多个并发事务之间数据要相互隔离
    4、持久性:一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有影响
##### 隔离性引发的问题
    1、忽略了事务的隔离性，容易产生的一些问题：两个不同的事务
    2、脏读：在一个事务中读取到另一个事务未提交的数据
    3、不可重复读：在一个事务中读取到了另一个事务提交的数据(update)。一个事务中两次查询结果不一致
    4、虚读(幻读)：在一个事务中读取到了另一个事务提交的数据(insert)。导致两次查询结果不一致
  
##### 隔离性的解决方案：隔离级别
    1、read uncommitted(未提交读):脏读、不可重读和虚读都有可能发生
    2、read committed(提交读)：脏读不可能发生，不可重读和虚读都可能发生
    3、repeatable read(可重读)：脏读、不可重读不可能发生，虚读可能发生
    4、serializable(串行)：脏读、不可重读和虚读都不可能发生
    安全性:read uncommitted < read committed < repeatable read < serializable
    效率：read uncommitted > read committed > repeatable read > serializable
    几个数据库的默认级别：
    mysql的默认值：repeatable read
    oracle的默认值：read uncommitted
#### 事务的丢失更新问题
     两个或多个事务更新同一行，但是这些事务彼此之间不知道其它事务进行的修改，因此第二个更改覆盖了第一次的更
     第一类丢失更新问题:A事务回滚时，把已经提交的B事务数据覆盖了
     第二类丢失更新问题:A事务提交时，把已经提交的B事务的数据覆盖了
##### 解决事务的丢失更新
     1、悲观锁：如果丢失更新一直存在，就是使用数据库锁机制(排它锁)
     2、乐观锁：如果丢失更新不一定存在，在数据库表中添加一个字段
### 数据库的连接池
    连接池中连接释放与销毁
#### 自定义连接池
    DataSource接口：代表连接池
    自定义就是实现该接口
    增强一个类中的某一个方法
    1、继承
    2、装饰者模式
        增强的类与被增强的类必须实现同一个接口
        增强的类中获取被增强的类的引用
    3、动态代理
#### DBCP连接池
     commons-pool.jar
     commons-dbcp.jar
#### C3P0连接池
    c3p0

## 利用web服务器(tomcat的JNDI管理数据源(DataSource)
    JNDI：java naming and directory interface java命名和目录接口
    JNDI是一个May容器：naming+directort-->datasource
## 数据库元数据的获取(编写JDBC框架用的)
    1、什么是数据库元数据
        元数据就是数据库 、参数、表和记录等信息
     2、常用的元信息
     DatabaseMetaData、ParameterMetaData和ResultSEtMetaData
## 编写自己的JDBC框架
     抽象策略设计模式
## 一个开源的JDBC框架:DBUtil
      commons-dbutils
      1、核心类QueryRunner
      int[] batch(String sql, Object[][] params);
      2、ThreadLocal 线程的局部变量