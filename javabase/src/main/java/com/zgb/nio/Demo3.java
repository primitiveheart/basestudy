package com.zgb.nio;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo3 {
    public static void main(String[] args)throws Exception{
        FileChannel in = FileChannel.open(Paths.get("E:\\intellij\\basestudy\\javabase\\src\\main\\java\\1.txt"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("E:\\intellij\\basestudy\\javabase\\src\\main\\java\\2.txt"),StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.READ);

        MappedByteBuffer inMapped = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
        MappedByteBuffer outMapped = out.map(FileChannel.MapMode.READ_WRITE, 0, in.size());

        byte[] bytes = new byte[inMapped.limit()];
        inMapped.get(bytes);
        outMapped.put(bytes);
    }

}
