/* explains Tomcat's default container */
package com.vincent.howTomcatWorks.ex04.pyrmont.startup;


import com.vincent.howTomcatWorks.catalina.connector.http.HttpConnector;
import com.vincent.howTomcatWorks.ex04.pyrmont.core.SimpleContainer;

public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    SimpleContainer container = new SimpleContainer();
    connector.setContainer(container);
    try {
      connector.initialize();
      connector.start();

      // make the application wait until we press any key.
      System.in.read();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}