package com.xi.notification.netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>将字符串通过buffer，channel写入文本文件
 *
 * @Author xihuimin
 * @Date 2021/3/11
 */
public class NioChannel01 {

    public static void main(String[] args) throws Exception {

        //字符串
        String str = "hello,中国！";
        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\str.txt");
        //获取channel
        FileChannel channel = fileOutputStream.getChannel();
        //创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        //将缓冲区数据 写入 channel
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
