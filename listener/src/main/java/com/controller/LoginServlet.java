package com.controller;

import com.domain.User;
import com.util.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2018/5/18.
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = UserDB.find(username, password);
        if(u == null){
            resp.getWriter().write("用户名或密码错误，1秒钟之后将跳转到登录界面");
            resp.addHeader("Refresh","1;URL=" + req.getContextPath() + "/login.jsp");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", u);//记住登录信息
        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
