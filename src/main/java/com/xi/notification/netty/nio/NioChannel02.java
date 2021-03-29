package com.xi.notification.netty.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>通过buffer，channel读取文本数据，并打印到控制台
 *
 * @Author xihuimin
 * @Date 2021/3/11
 */
public class NioChannel02 {

    public static void main(String[] args) throws Exception {

        //创建文件输入流
        FileInputStream fileInputStream = new FileInputStream("d:\\str.txt");
        //获取channel
        FileChannel channel = fileInputStream.getChannel();
        //创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        //将channel中的数据 读取到 缓冲区
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
