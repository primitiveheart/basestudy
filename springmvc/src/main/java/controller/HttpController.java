package controller;


import domain.User;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2018/5/21.
 */

public class HttpController implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        User user = new User();
        user.setAge(12);
        user.setUsername("zhangsan");

        //设置模型
        httpServletRequest.setAttribute("user", user);
        //设置逻辑视图名
        httpServletRequest.getRequestDispatcher("/WEB-INF/page/http.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
