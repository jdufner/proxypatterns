package de.jdufner.experiments.proxypatterns.gof_decorator;

/**
 * Der Dekorierer ergänzt die Funktionalität der vorhandenen Methoden der
 * Implementierung und kann beliebige weitere Methoden hinzufügen ohne
 * Vererbung.
 *
 * @author Jürgen
 */
public class Dekorierer implements Schnittstelle {

  private final Implementierung implementierung;

  /**
   * Der Dekorierer benötigt die Implementierung, die ergänzt werden soll.
   *
   * @param implementierung
   */
  public Dekorierer(final Implementierung implementierung) {
    this.implementierung = implementierung;
  }

  /**
   * Ergänzt die vorhandene Funktionalität der Implementierung.
   */
  @Override
  public String foo() {
    return ">>>" + implementierung.foo() + "<<<";
  }

  /**
   * Fügt eine neue Methode zum Dekorierer hinzu.
   */
  public String bar() {
    return ">>>bar(" + implementierung.getName() + ")<<<";
  }

}
