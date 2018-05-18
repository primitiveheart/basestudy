package com.zgb.nio;

import java.nio.ByteBuffer;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo {
    public static void main(String[] args){
        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //四个属性
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上限：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记:" + byteBuffer.mark());

        String s = "sdsdfsfd";
        byteBuffer.put(s.getBytes());

        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上限：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记:" + byteBuffer.mark());

        byteBuffer.flip();
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上限：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记:" + byteBuffer.mark());

        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));

        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上限：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记:" + byteBuffer.mark());

        byteBuffer.clear();
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上限：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记:" + byteBuffer.mark());
    }
}
