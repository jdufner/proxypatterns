package de.jdufner.experiments.proxypatterns.dynamicproxy;

import org.junit.Test;

public class DekoriererTest {

  @Test
  public void test() {
    Schnittstelle implementierung = new Implementierung("test");
    Schnittstelle dekorierer = Dekorierer.buildProxy(implementierung);
    dekorierer.m1("bla");
    ((Dekorierer) dekorierer).m2();
  }

}
