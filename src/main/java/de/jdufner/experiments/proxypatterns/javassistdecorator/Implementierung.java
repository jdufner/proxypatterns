package de.jdufner.experiments.proxypatterns.javassistdecorator;

/**
 * Eine einfache Implementierung mit einer Methode.
 *
 * @author Jürgen
 */
public class Implementierung {

  private String name;

  public Implementierung() {
  }

  public Implementierung(final String name) {
    this.name = name;
  }

  public String foo() {
    return "foo(" + name + ")";
  }

  protected String getName() {
    return name;
  }

}
