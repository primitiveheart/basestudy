package controller;


import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2018/5/21.
 */
@Controller
public class AnnotationController{

    @RequestMapping("controller")
    public ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView();

        User user = new User();
        user.setAge(12);
        user.setUsername("zhangsan");

        //设置模型
        modelAndView.addObject("user", user);
        //设置逻辑视图名
        modelAndView.setViewName("simple");

        return modelAndView;
    }
}
