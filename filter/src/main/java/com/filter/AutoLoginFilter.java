package com.filter;

import com.service.UserService;
import com.serviceimpl.UserServiceImpl;
import com.util.MD5Utils;
import com.vo.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2018/5/17.
 */
public class AutoLoginFilter implements Filter {

    private UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
        if(user == null){
            Cookie[] cookies = request.getCookies();
            for(int i=0;cookies[i].getName() != null &&  i<cookies.length; i++){
                if(cookies[i].getName().equals("logininfo")){
                    String value = cookies[i].getValue();
                    String username = MD5Utils.base64Decoder(value.split("\\_")[0]);
                    String password = MD5Utils.base64Decoder(value.split("\\_")[1]);
                    User u = userService.login(username, password);
                    if(u != null){
                        session.setAttribute("user" ,u);
                    }
                    break;
                }

            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
