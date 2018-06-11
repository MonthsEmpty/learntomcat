package com.vincent.javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {

    public static void main(String[] args) throws IOException {
        Socket client = null;
        client = new Socket("localhost", 8888);
        BufferedReader buf = null;
        buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = buf.readLine();
        System.out.println("服务器端输出内容： " + str);
        client.close();
        buf.close();
    }
}
