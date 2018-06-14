package com.vincent.howTomcatWorks.ex05.pyrmont.startup;


import com.vincent.howTomcatWorks.catalina.Context;
import com.vincent.howTomcatWorks.catalina.Loader;
import com.vincent.howTomcatWorks.catalina.Mapper;
import com.vincent.howTomcatWorks.catalina.Pipeline;
import com.vincent.howTomcatWorks.catalina.Valve;
import com.vincent.howTomcatWorks.catalina.Wrapper;
import com.vincent.howTomcatWorks.catalina.connector.http.HttpConnector;
import com.vincent.howTomcatWorks.ex05.pyrmont.core.SimpleContext;
import com.vincent.howTomcatWorks.ex05.pyrmont.core.SimpleContextMapper;
import com.vincent.howTomcatWorks.ex05.pyrmont.core.SimpleLoader;
import com.vincent.howTomcatWorks.ex05.pyrmont.core.SimpleWrapper;
import com.vincent.howTomcatWorks.ex05.pyrmont.valves.ClientIPLoggerValve;
import com.vincent.howTomcatWorks.ex05.pyrmont.valves.HeaderLoggerValve;

public final class Bootstrap2 {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    Wrapper wrapper1 = new SimpleWrapper();
    wrapper1.setName("Primitive");
    wrapper1.setServletClass("PrimitiveServlet");
    Wrapper wrapper2 = new SimpleWrapper();
    wrapper2.setName("Modern");
    wrapper2.setServletClass("ModernServlet");

    Context context = new SimpleContext();
    context.addChild(wrapper1);
    context.addChild(wrapper2);

    Valve valve1 = new HeaderLoggerValve();
    Valve valve2 = new ClientIPLoggerValve();

    ((Pipeline) context).addValve(valve1);
    ((Pipeline) context).addValve(valve2);

    Mapper mapper = new SimpleContextMapper();
    mapper.setProtocol("http");
    context.addMapper(mapper);
    Loader loader = new SimpleLoader();
    context.setLoader(loader);
    // context.addServletMapping(pattern, name);
    context.addServletMapping("/Primitive", "Primitive");
    context.addServletMapping("/Modern", "Modern");
    connector.setContainer(context);
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