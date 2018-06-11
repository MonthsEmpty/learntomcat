package com.vincent.javaSocket;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket client = null;
        PrintWriter out = null;
//        PrintStream out = null;
        serverSocket = new ServerSocket(8888);
//        serverSocket = new ServerSocket(8888, 1, InetAddress.getByName("127.0.0.1"));
        System.out.println("服务器运行，等待客户端连接");
        client = serverSocket.accept();
        String str = "hello world !!!";
        System.out.println(str);
        out = new PrintWriter(client.getOutputStream());
        out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
        out.println("Content-Type:text/html;charset=" + "GBK");
        out.println();// 根据 HTTP 协议, 空行将结束头信息

        out.println("<h1> Hello Http Server</h1>");
//        out.print(str);
        out.close();
        client.close();
        serverSocket.close();
    }
}
