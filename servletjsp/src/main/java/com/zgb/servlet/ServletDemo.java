package com.zgb.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by admin on 2018/5/8.
 */
public class ServletDemo implements Servlet {
    /**
     * servlet什么是是时候创建
     * 在第一次访问时创建
     * 该方法调用几次
     * 该方法只调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("=====init=====");
    }
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //获取请求数据
        System.out.println("进入了");
        //处理业务逻辑

        //对客户端做出响应
//        response.getWriter().write("hello servlet----");
    }


    /**
     * 该方法子服务器关闭是销毁
     */
    @Override
    public void destroy() {
        System.out.println("----destroy--");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

}
