package com.zgb.controller;

import com.zgb.entity.User;
import com.zgb.service.UserService;
import com.zgb.utils.Constans;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by admin on 2018/5/10.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String code = req.getParameter("code");
        String checkCode = (String) req.getSession().getAttribute("sessionCode");
        if(code == null || !checkCode.equals(code)){
            req.setAttribute("msg", "验证码不正确");
            req.getRequestDispatcher("/jsp/reg.jsp").forward(req, resp);
        }

        //获取参数
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();

        try {
            //进行封装
            BeanUtils.populate(user, map);
            //存入数据库中
            UserService userService = new UserService();
            int flag = userService.regUser(user);
            //返回到相应的页面
            if(flag == Constans.SUCCESSS){
                resp.sendRedirect("/jsp/login.jsp");
            }else if(flag == Constans.NAMEEXIST){
                req.setAttribute("msg", "用户名已经存在");
                req.getRequestDispatcher("/jsp/reg.jsp").forward(req, resp);
            }else if(flag == Constans.EMAILEXIST){
                req.setAttribute("msg", "邮箱已经存在");
                req.getRequestDispatcher("/jsp/reg.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
