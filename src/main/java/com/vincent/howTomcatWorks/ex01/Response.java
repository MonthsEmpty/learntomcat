package com.vincent.howTomcatWorks.ex01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource1() {
        PrintWriter out = new PrintWriter(output);
        out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
        out.println("Content-Type:text/html;charset=" + "GBK");
        out.println();// 根据 HTTP 协议, 空行将结束头信息
        out.println("<h1> Hello Http Server</h1>");
        out.close();
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        PrintWriter out = new PrintWriter(output);
        ;
        BufferedReader reader = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
                out.println("Content-Type:text/html;charset=" + "GBK");
                out.println();// 根据 HTTP 协议, 空行将结束头信息
                reader = new BufferedReader(new FileReader(file));
                String tempString = null;
                while ((tempString = reader.readLine()) != null) {
                    out.println(tempString);
                }
            } else {
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
            if (out != null)
                out.close();
        }
    }
}