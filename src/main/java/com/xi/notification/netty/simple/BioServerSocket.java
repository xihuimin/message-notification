package com.xi.notification.netty.simple;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>同步阻塞IO(BIO)
 *
 * @Author xihuimin
 * @Date 2021/3/10
 */
public class BioServerSocket {

    public static void main(String[] args) throws IOException {

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true) {

            System.out.println("等待连接.....");
            final Socket socket = serverSocket.accept();

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }
    
    public static void handler(Socket socket) {
        System.out.println("连接到客户端" + Thread.currentThread().getName());
        byte[] bytes = new byte[1024];
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
