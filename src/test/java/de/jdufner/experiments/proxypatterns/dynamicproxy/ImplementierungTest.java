package de.jdufner.experiments.proxypatterns.dynamicproxy;

import org.junit.Assert;
import org.junit.Test;

public class ImplementierungTest {

  @Test
  public void test() {
    Implementierung implementierung = new Implementierung("abc");
    Assert.assertEquals("foo1(abc)", implementierung.foo1());
    Assert.assertEquals("foo2(abc)", implementierung.foo2());
  }

}
