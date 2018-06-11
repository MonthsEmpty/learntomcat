package com.vincent.howTomcatWorks.ex03.startup;


import com.vincent.howTomcatWorks.ex03.connect.http.HttpConnector;

public final class Bootstrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}