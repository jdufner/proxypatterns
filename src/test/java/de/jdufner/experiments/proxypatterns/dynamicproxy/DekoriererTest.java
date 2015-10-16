package de.jdufner.experiments.proxypatterns.dynamicproxy;

import java.lang.reflect.Proxy;

import org.junit.Assert;
import org.junit.Test;

public class DekoriererTest {

  @Test
  public void test() {
    Implementierung implementierung = new Implementierung("def");
    Schnittstelle dekorierer = Dekorierer.buildProxy(implementierung);
    // Der Dekorierer kennt nur die Methoden aus dem Interface,
    Assert.assertEquals(">>>foo1(def)<<<", dekorierer.foo1());
    Assert.assertEquals(">>>foo2(def)<<<", dekorierer.foo2());
    // ((Dekorierer) dekorierer).m2() funktioniert daher nicht, mann muss sich den InvocationHandler holen:
    Assert.assertEquals(">>>bar(def)<<<", ((Dekorierer) Proxy.getInvocationHandler(dekorierer)).bar());
  }

}
