package com.controller;

import com.service.UserService;
import com.serviceimpl.UserServiceImpl;
import com.sun.net.httpserver.HttpsServer;
import com.util.MD5Utils;
import com.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by admin on 2018/5/16.
 */
public class ControllerServlet extends HttpServlet{

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String op = req.getParameter("op");
        if("login".equals(op)){
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password"); //明文

        password = MD5Utils.md5(password); //密文

        User user = userService.login(username, password);
        String auto = req.getParameter("auto");

        if(user == null){
            resp.getWriter().write("用户名或密码错误，1秒钟之后跳转登录界面");
            resp.setHeader("Refresh", "1;URL=" + req.getContextPath() + "/page/login.jsp");
            return;
        }

        if(null != auto){
            Cookie cookie = new Cookie("logininfo", MD5Utils.base64Encoder(username) + "_" + MD5Utils.base64Encoder(password));
            cookie.setMaxAge(10*24*60*60);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.getWriter().write("登录成功，1秒钟之后进行跳转到主页");
        resp.setHeader("Refresh", "1;URL=" + req.getContextPath() + "/page/index.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
