package de.jdufner.experiments.proxypatterns.javassistdecorator;

import org.junit.Assert;
import org.junit.Test;

public class DekoriererTest {

  @Test
  public void test() throws Exception {
    Dekorierer bar = Dekorierer.build(new Implementierung("def"));
    Assert.assertEquals(">>>foo(def)<<<", bar.foo());
    Assert.assertEquals(">>>bar(def)<<<", bar.bar());
  }

}
