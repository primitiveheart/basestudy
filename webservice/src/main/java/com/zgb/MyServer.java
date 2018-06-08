package com.zgb;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 2018/6/4.
 */
public class MyServer {
    public static void main(String[] args)throws Exception{
        ServerSocket serverSocket = new ServerSocket(8088);
        while (true){
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            System.out.println("从客户端发送过来的：" + line);
            reader.close();
            in.close();
        }
    }
}
