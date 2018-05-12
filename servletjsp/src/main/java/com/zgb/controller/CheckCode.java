package com.zgb.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成验证码
 * Created by admin on 2018/5/11.
 */
public class CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 200;
        int height = 30;
        //生成画布
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //获得画笔
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

        //设置颜色
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setColor(Color.blue);
        graphics2D.drawRect(0, 0, width-1, height-1);

        graphics2D.setColor(Color.red);
        graphics2D.setFont(new Font("宋体", Font.BOLD, 20));

        String dataSource = "abcdefghijk0123456789";
        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<4; i++){
            char s = dataSource.charAt(random.nextInt(10));
            graphics2D.setColor(Color.red);
            graphics2D.drawString(s+"", (i+1)*20, 15);
            sb.append(s);
        }

        req.getSession().setAttribute("sessionCode" ,sb.toString());

        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
