package de.jdufner.experiments.proxypatterns.dynamicproxy;

import java.lang.reflect.Proxy;

import org.junit.Assert;
import org.junit.Test;

public class DekoriererTest {

  @Test
  public void test() {
    Implementierung implementierung = new Implementierung("def");
    Schnittstelle dekorierer = Dekorierer.buildProxy(implementierung);
    Assert.assertEquals(">>>foo1(def)<<<", dekorierer.foo1());
    Assert.assertEquals(">>>foo2(def)<<<", dekorierer.foo2());
    //((Dekorierer) dekorierer).m2();
    Assert.assertEquals(">>>bar(def)<<<", ((Dekorierer) Proxy.getInvocationHandler(dekorierer)).bar());
  }

}
