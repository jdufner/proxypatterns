package de.jdufner.experiments.proxypatterns.gof_decorator;

import org.junit.Assert;
import org.junit.Test;

public class ImplementierungTest {

  @Test
  public void testImplementierung() {
    Implementierung implementierung = new Implementierung("abc");
    Assert.assertEquals("foo(abc)", implementierung.foo());
    // Methode bar() existiert in der Implementierung nicht
  }

}
