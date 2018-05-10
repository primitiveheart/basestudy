package com.zgb.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/5/10.
 */
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String[] names = new String[]{"计算机网络", "计算机操作系统", "java编程思想", "mysql数据库"};
        Integer index = Integer.parseInt(id);
        String productName = names[index - 1];
        HttpSession session = req.getSession();
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        if(cart == null){
            cart = new HashMap<String, Integer>();
            cart.put(productName, 1);
            session.setAttribute("cart", cart);
        }else {
            if (cart.containsKey(productName)){
                Integer count = cart.get(productName);
                count++;
                cart.put(productName, count);
                session.setAttribute("cart", cart);
            }else {
                cart.put(productName , 1);
                session.setAttribute("cart", cart);
            }
        }

        //重定向
        resp.sendRedirect("/session/goPay.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
