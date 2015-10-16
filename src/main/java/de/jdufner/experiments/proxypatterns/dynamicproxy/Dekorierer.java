package de.jdufner.experiments.proxypatterns.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Der Dekorierer ergänzt die Funktionalität der vorhandenen Methoden der
 * Implementierung und kann beliebige weitere Methoden hinzufügen ohne
 * Vererbung.
 *
 * Der Vorteil des {@link InvocationHandler} ist, das alle Methoden, die im
 * Interface {@link Schnittstelle} enthalten sind mit einer Methode
 * {@link #invoke(Object, Method, Object[])} überschrieben werden. Voraussetzung
 * ist allerdings, dass die Methoden in einem Interface enthalten sein müssen.
 *
 * @author Jürgen
 */
public class Dekorierer implements InvocationHandler {

  private Implementierung implementierung;

  public Dekorierer(final Implementierung implementierung) {
    this.implementierung = implementierung;
  }

  /**
   * Ergänzt die vorhandene Funktionalität der Implementierung.
   *
   * Hier können beliebige Dinge gemacht werden, z.B. jeder Methodenaufruf kann
   * protokolliert werden, es kann die Dauer jedes Methodenaufrufs gemessen
   * werden etc.
   */
  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
    return ">>>" + (String) method.invoke(implementierung, args) + "<<<";
  }

  /**
   * Fügt eine neue Methode zum Dekorierer hinzu.
   */
  public String bar() {
    return ">>>bar(" + implementierung.getName() + ")<<<";
  }

  /**
   * Factorymethode um diesen Dekorierer zu erzeugen.
   *
   * @param implementierung
   * @return
   */
  public static Schnittstelle buildProxy(final Implementierung implementierung) {
    return (Schnittstelle) Proxy.newProxyInstance(implementierung.getClass().getClassLoader(),
        new Class<?>[] { Schnittstelle.class }, new Dekorierer(implementierung));
  }

}
