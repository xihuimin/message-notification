package com.xi.notification.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * <p>通过buffer，channel完成文本的拷贝
 *
 * @Author xihuimin
 * @Date 2021/3/11
 */
public class NioChannel03 {

    public static void main(String[] args) throws Exception {

        //创建文件输入流
        FileInputStream fileInputStream = new FileInputStream("d:\\str.txt");
        //获取channel
        FileChannel channel = fileInputStream.getChannel();

        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\str1.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        channel.transferTo(channel.position(), channel.size(), fileChannel);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
