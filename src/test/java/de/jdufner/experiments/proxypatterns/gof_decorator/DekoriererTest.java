package de.jdufner.experiments.proxypatterns.gof_decorator;

import org.junit.Assert;
import org.junit.Test;

public class DekoriererTest {

  @Test
  public void testDekorierer() {
    Dekorierer dekorierer = new Dekorierer(new Implementierung("def"));
    Assert.assertEquals(">>>foo(def)<<<", dekorierer.foo());
    Assert.assertEquals(">>>bar(def)<<<", dekorierer.bar());
  }

}
