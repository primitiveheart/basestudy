package com.zgb.jsp;

import com.zgb.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/5/9.
 */
public class LastVisitedTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtil.getCookieByName(cookies, "last");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(d);
        if(cookie == null){
            //说明用户第一次访问该网站
            resp.getWriter().write("<h2>欢迎您的到来</h2>");
            Cookie c = new Cookie("last", sd);
            resp.addCookie(c);
        }else{
            String s = cookie.getValue();
            resp.getWriter().write("<h2>您上次访问的时间是:" + s+ "<h2>");
            cookie.setValue(sdf.format(new Date()));
            resp.addCookie(cookie);
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
