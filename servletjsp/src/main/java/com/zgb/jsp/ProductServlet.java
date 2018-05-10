package com.zgb.jsp;

import com.zgb.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2018/5/9.
 */
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtil.getCookieByName(cookies, "product");
        if(cookie == null){
            //第一次访问
            Cookie c = new Cookie("product", id);
            //设置有效时间
            cookie.setMaxAge(24*60*60);
            resp.addCookie(c);
        }else{
            String product = cookie.getValue();
            String[] products = product.split(",");
            if(!isId(products, id)){
                cookie.setValue(product + "," + id);
                //设置有效时间
                cookie.setMaxAge(24*60*60);
                resp.addCookie(cookie);
            }
        }

        //重定向到
        resp.sendRedirect("/cookie/productList.jsp");
    }

    public boolean isId(String[] products, String id){
        for(String s : products){
            if(s.equals(id)){
                return  true;
            }
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
