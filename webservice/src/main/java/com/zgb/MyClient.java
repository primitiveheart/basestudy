package com.zgb;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by admin on 2018/6/4.
 */
public class MyClient {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("localhost",8088);
        OutputStream out = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write("你好，我是客户端");
        writer.close();
        out.close();
        socket.close();
    }
}
