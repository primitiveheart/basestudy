package controller;


import domain.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2018/5/21.
 */

public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
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
