package com.vincent.howTomcatWorks.ex05.pyrmont.startup;

import com.vincent.howTomcatWorks.catalina.Loader;
import com.vincent.howTomcatWorks.catalina.Pipeline;
import com.vincent.howTomcatWorks.catalina.Valve;
import com.vincent.howTomcatWorks.catalina.Wrapper;
import com.vincent.howTomcatWorks.catalina.connector.http.HttpConnector;
import com.vincent.howTomcatWorks.ex05.pyrmont.core.SimpleLoader;
import com.vincent.howTomcatWorks.ex05.pyrmont.core.SimpleWrapper;
import com.vincent.howTomcatWorks.ex05.pyrmont.valves.ClientIPLoggerValve;
import com.vincent.howTomcatWorks.ex05.pyrmont.valves.HeaderLoggerValve;

public final class Bootstrap1 {
  public static void main(String[] args) {

/* call by using http://localhost:8080/ModernServlet,
   but could be invoked by any name */

    HttpConnector connector = new HttpConnector();
    Wrapper wrapper = new SimpleWrapper();
    wrapper.setServletClass("ModernServlet");
    Loader loader = new SimpleLoader();
    Valve valve1 = new HeaderLoggerValve();
    Valve valve2 = new ClientIPLoggerValve();

    wrapper.setLoader(loader);
    ((Pipeline) wrapper).addValve(valve1);
    ((Pipeline) wrapper).addValve(valve2);

    connector.setContainer(wrapper);

    try {
      connector.initialize();
      connector.start();

      // make the application wait until we press a key.
      System.in.read();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}