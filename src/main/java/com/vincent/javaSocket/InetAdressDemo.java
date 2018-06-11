package com.vincent.javaSocket;

import java.io.IOException;
import java.net.InetAddress;

public class InetAdressDemo {

    public static void main(String[] args) throws IOException {
        InetAddress locAdd = null;
        InetAddress remAdd = null;
        locAdd = InetAddress.getLocalHost();
        remAdd = InetAddress.getByName("www.baidu.com");
        System.out.println("本机IP地址：" + locAdd.getHostAddress());
        System.out.println("百度ip地址:" + remAdd.getAddress());
        System.out.println("本机是否可达: " + locAdd.isReachable(5000));
    }
}
