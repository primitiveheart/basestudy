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
### 数据库的连接池