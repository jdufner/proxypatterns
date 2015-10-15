package de.jdufner.experiments.proxypatterns.dynamicproxy;

public class Implementierung implements Schnittstelle {

  private String name;

  public Implementierung() {
  }

  public Implementierung(final String name) {
    this.name = name;
  }

  @Override
  public String m1(final String s) {
    String result = name + ":m1:" + s;
    System.out.println(result);
    return result;
  }

  protected String getName() {
    return name;
  }
}
