package com.zgb.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by admin on 2018/5/8.
 */
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取输入流
        String path = getServletContext().getRealPath("/img/草地.jpg");
        InputStream inputStream = new FileInputStream(path);

        String filename= "";
        if(path.lastIndexOf("\\") != -1){
            filename = path.substring(path.lastIndexOf("\\") + 1);
        }

        System.out.println(filename);

        if(filename != ""){
            String agent = req.getHeader("user-agent");
//            if(agent.contains("MSIE")){
//                filename = URLEncoder.encode(filename, "utf-8");
//            }
            //设置头信息
            resp.setHeader("Content-Disposition", "attachment;filename=" + filename);

            //获取输出流
            OutputStream outputStream = resp.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, len);
            }

        }
        inputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
