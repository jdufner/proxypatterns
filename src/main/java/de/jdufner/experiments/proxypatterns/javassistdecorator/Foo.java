package de.jdufner.experiments.proxypatterns.javassistdecorator;

public class Foo {

  private String name;

  public Foo() {
  }

  public Foo(final String name) {
    this.name = name;
  }

  public String m1(final String s) {
    String result = name + ":m1:" + s;
    System.out.println(result);
    return result;
  }

  protected String getName() {
    return name;
  }

}
