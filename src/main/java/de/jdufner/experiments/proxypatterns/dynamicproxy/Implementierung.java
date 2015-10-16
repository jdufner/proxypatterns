package de.jdufner.experiments.proxypatterns.dynamicproxy;

/**
 * Eine einfache Implementierung der Schnittstelle. Die Implementierung ist
 * final deklariert, damit keine Subklassen erzeugt werden können.
 *
 * @author Jürgen
 */
public final class Implementierung implements Schnittstelle {

  private String name;

  public Implementierung() {
  }

  public Implementierung(final String name) {
    this.name = name;
  }

  @Override
  public String foo1() {
    return "foo1(" + name + ")";
  }

  @Override
  public String foo2() {
    return "foo2(" + name + ")";
  }

  protected String getName() {
    return name;
  }

}
