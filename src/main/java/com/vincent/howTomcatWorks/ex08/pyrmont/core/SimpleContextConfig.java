package com.vincent.howTomcatWorks.ex08.pyrmont.core;


import com.vincent.howTomcatWorks.catalina.Context;
import com.vincent.howTomcatWorks.catalina.Lifecycle;
import com.vincent.howTomcatWorks.catalina.LifecycleEvent;
import com.vincent.howTomcatWorks.catalina.LifecycleListener;

public class SimpleContextConfig implements LifecycleListener {

  public void lifecycleEvent(LifecycleEvent event) {
    if (Lifecycle.START_EVENT.equals(event.getType())) {
      Context context = (Context) event.getLifecycle();
      context.setConfigured(true);
    }
  }
}