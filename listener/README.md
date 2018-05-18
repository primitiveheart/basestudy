# 监听器的学习
## 事件源、事件和监听器(观察者设计模式的应用)
    事件源：发生事件的那个对象
    监听器: 监听事件源上发生的动作行为(方法)
    事件：封装事件源，在发生事件时，方便监听器某个方法的获得事件源的引用
## servlet提供的8个监听器
### 监听ServletContext、HttpSession和ServletRequest的对象创建和销毁
    SerlvetlContextListener
        作用:contextInitinalized :应用启动时就执行。执行一次，把整个应用的系统初始化写在此处
    HttpSessionListener
        sessionCreated
        第一次执行request.getSession时创建
        sessionDestroyed
        关闭浏览器不会导致session的销毁，超时和调用invalidate，进行销毁
    ServletRequestListener
### Servlet规范中三个监听属性变化的监听器
    监听ServletContext、HttpSession和Servlet域对象中属性变化的监听器
    ServletContextAttributeListener
    HttpSessionAttributeListener
    ServletRequestAttributeListener
### 感知型监听器
    不需要注册监听
    HttpSession的钝化和激活
    HttpSessionBindingListener：能够监测到何时被加入到session域中，何时被移除
    HttpSessionActivationListener;能够检测到何时被钝化和激活
## 案例
### 统计在线用户，并踢人
