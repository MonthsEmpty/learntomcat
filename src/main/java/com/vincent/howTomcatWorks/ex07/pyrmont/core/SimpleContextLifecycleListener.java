package com.vincent.howTomcatWorks.ex07.pyrmont.core;


import com.vincent.howTomcatWorks.catalina.Lifecycle;
import com.vincent.howTomcatWorks.catalina.LifecycleEvent;
import com.vincent.howTomcatWorks.catalina.LifecycleListener;

public class SimpleContextLifecycleListener implements LifecycleListener {

  public void lifecycleEvent(LifecycleEvent event) {
    Lifecycle lifecycle = event.getLifecycle();
    System.out.println("SimpleContextLifecycleListener's event " +
      event.getType().toString());
    if (Lifecycle.START_EVENT.equals(event.getType())) {
      System.out.println("Starting context.");
    }
    else if (Lifecycle.STOP_EVENT.equals(event.getType())) {
      System.out.println("Starting context.");
    }
  }
}