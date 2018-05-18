package com.zgb.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo2 {
    public static void main(String[] args){
        FileOutputStream out = null;
        FileInputStream in = null;

        FileChannel inFileChannel = null;
        FileChannel outFileChannel = null;
        try{
            out = new FileOutputStream("E:\\intellij\\basestudy\\javabase\\src\\main\\java\\2.txt");
            in = new FileInputStream("E:\\intellij\\basestudy\\javabase\\src\\main\\java\\1.txt");

            inFileChannel = in.getChannel();
            outFileChannel = out.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (inFileChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                outFileChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
