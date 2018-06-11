package com.vincent.howTomcatWorks.ex03;


import com.vincent.howTomcatWorks.ex03.connect.http.HttpRequest;
import com.vincent.howTomcatWorks.ex03.connect.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
