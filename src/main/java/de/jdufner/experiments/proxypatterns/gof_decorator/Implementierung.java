package de.jdufner.experiments.proxypatterns.gof_decorator;

/**
 * Eine einfache Implementierung der Schnittstelle. Die Implementierung ist
 * final deklariert, damit keine Subklassen erzeugt werden können.
 *
 * @author Jürgen
 */
public final class Implementierung implements Schnittstelle {

  private String name;

  public Implementierung(final String name) {
    this.name = name;
  }

  @Override
  public String foo() {
    return "foo(" + name + ")";
  }

  String getName() {
    return name;
  }

}
