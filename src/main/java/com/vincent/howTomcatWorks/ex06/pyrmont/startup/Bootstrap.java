package com.vincent.howTomcatWorks.ex06.pyrmont.startup;


import com.vincent.howTomcatWorks.catalina.Connector;
import com.vincent.howTomcatWorks.catalina.Context;
import com.vincent.howTomcatWorks.catalina.Lifecycle;
import com.vincent.howTomcatWorks.catalina.LifecycleListener;
import com.vincent.howTomcatWorks.catalina.Loader;
import com.vincent.howTomcatWorks.catalina.Mapper;
import com.vincent.howTomcatWorks.catalina.Wrapper;
import com.vincent.howTomcatWorks.catalina.connector.http.HttpConnector;
import com.vincent.howTomcatWorks.ex06.pyrmont.core.SimpleContext;
import com.vincent.howTomcatWorks.ex06.pyrmont.core.SimpleContextLifecycleListener;
import com.vincent.howTomcatWorks.ex06.pyrmont.core.SimpleContextMapper;
import com.vincent.howTomcatWorks.ex06.pyrmont.core.SimpleLoader;
import com.vincent.howTomcatWorks.ex06.pyrmont.core.SimpleWrapper;

public final class Bootstrap {
  public static void main(String[] args) {
    Connector connector = new HttpConnector();
    Wrapper wrapper1 = new SimpleWrapper();
    wrapper1.setName("Primitive");
    wrapper1.setServletClass("PrimitiveServlet");
    Wrapper wrapper2 = new SimpleWrapper();
    wrapper2.setName("Modern");
    wrapper2.setServletClass("ModernServlet");

    Context context = new SimpleContext();
    context.addChild(wrapper1);
    context.addChild(wrapper2);

    Mapper mapper = new SimpleContextMapper();
    mapper.setProtocol("http");
    LifecycleListener listener = new SimpleContextLifecycleListener();
    ((Lifecycle) context).addLifecycleListener(listener);
    context.addMapper(mapper);
    Loader loader = new SimpleLoader();
    context.setLoader(loader);
    // context.addServletMapping(pattern, name);
    context.addServletMapping("/Primitive", "Primitive");
    context.addServletMapping("/Modern", "Modern");
    connector.setContainer(context);
    try {
      connector.initialize();
      ((Lifecycle) connector).start();
      ((Lifecycle) context).start();

      // make the application wait until we press a key.
      System.in.read();
      ((Lifecycle) context).stop();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}