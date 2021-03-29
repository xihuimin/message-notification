package com.xi.notification.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2021/3/15
 */
public class NioClient {
    public static void main(String[] args) throws Exception {

        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //提供服务器端的ip 和 端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {

            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其它工作..");
            }
        }
        Scanner scanner = new Scanner(System.in);
        //...如果连接成功，就发送数据
        while (true) {
            String str = scanner.next();
            if (str.isEmpty()) {
                Thread.sleep(1000);
                continue;
            }
            //发送数据，将 buffer 数据写入 channel
            socketChannel.write(ByteBuffer.wrap(str.getBytes()));
            System.in.read();
        }
    }
}
