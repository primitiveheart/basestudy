package com.zgb.nio;

import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo4 {
    public static void main(String[] args) throws Exception{
        FileChannel in = FileChannel.open(Paths.get("E:\\intellij\\basestudy\\javabase\\src\\main\\java\\1.txt"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("E:\\intellij\\basestudy\\javabase\\src\\main\\java\\2.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE);
        in.transferTo(0, in.size(), out);
        in.close();
        out.close();
    }
}
