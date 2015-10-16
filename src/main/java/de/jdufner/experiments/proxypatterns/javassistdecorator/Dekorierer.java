package de.jdufner.experiments.proxypatterns.javassistdecorator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

/**
 * Der Dekorierer ergänzt die Funktionalität der vorhandenen Methoden der
 * Implementierung und kann beliebige weitere Methoden hinzufügen.
 *
 * In dieser Klasse erbt der Dekorierer zwar von der Implementierung, aber die
 * KEINE der geerbten Methoden wird überschrieben, sondern mittels Proxy an im
 * Konstruktor {@link #Dekorierer(Implementierung)} übergebene Instanz
 * weitergeleitet. Das ganz funktioniert aber nur, wenn die
 * {@link #build(Implementierung)} Methode zur Erzeugung des Dekorierers
 * verwendet wird, sonst ist es eine Vererbung im gewöhnlichen Sinne.
 *
 * @author Jürgen
 */
public class Dekorierer extends Implementierung {

  private Implementierung foo;

  /**
   *
   * @param implementierung
   */
  public Dekorierer(final Implementierung implementierung) {
    this.foo = implementierung;
  }

  /**
   * Ergänzt die vorhandene Funktionalität der Implementierung.
   */
  public String bar() {
    return ">>>bar(" + foo.getName() + ")<<<";
  }

  /**
   * Factory-Methode zur Erzeugung des Dekorierers, der alle geerbten Methoden
   * an die Instanz der Superklasse weiterleitet.
   *
   * @param implementierung
   * @return
   */
  public static Dekorierer build(final Implementierung implementierung) throws NoSuchMethodException, IllegalArgumentException,
      InstantiationException, IllegalAccessException, InvocationTargetException {

    final ProxyFactory factory = new ProxyFactory();
    factory.setSuperclass(Dekorierer.class);
    factory.setFilter(new MethodFilter() {
      @Override
      public boolean isHandled(final Method method) {
        return method.getDeclaringClass().equals(Implementierung.class);
      }
    });

    final MethodHandler handler = new MethodHandler() {
      @Override
      public Object invoke(final Object self, final Method thisMethod, final Method proceed, final Object[] args) throws Throwable {
        return ">>>" + (String) thisMethod.invoke(implementierung, args) + "<<<";
      }
    };

    return (Dekorierer) factory.create(new Class<?>[] { Implementierung.class }, new Object[] { implementierung }, handler);
  }

}
