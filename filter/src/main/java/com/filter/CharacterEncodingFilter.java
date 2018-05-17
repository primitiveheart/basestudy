package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 2018/5/16.
 */
public class CharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = filterConfig.getInitParameter("encoding");
        if(encoding == null){
            encoding = "utf-8";
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //解决post请求
        request.setCharacterEncoding(encoding);
        //解决字节流的乱码，设置页面的输出编码
        response.setCharacterEncoding(encoding);
        //解决字符流的乱码，设置response缓存区的编码，设置页面的输出编码
        response.setContentType("text/html;charset=" + encoding);

        MyHttpSerlvetRequest mRequest = new MyHttpSerlvetRequest(request);

        filterChain.doFilter(mRequest, response);

    }

    @Override
    public void destroy() {

    }
}

class MyHttpSerlvetRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request; //服务器的request
    public MyHttpSerlvetRequest(HttpServletRequest request){
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        if(value == null){
            return null;
        }
        //判断请求方式
        if("get".equalsIgnoreCase(request.getMethod())){
            try {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        return value;
    }
}
