package de.jdufner.experiments.javassistdecorator;

import org.junit.Assert;
import org.junit.Test;

public class BarTest {

  @Test
  public void test() throws Exception {
    Bar bar = Bar.build(new Foo("test"));
    Assert.assertEquals("test:m1:bla", bar.m1("bla"));
    Assert.assertEquals("test:m2", bar.m2());
  }

}
