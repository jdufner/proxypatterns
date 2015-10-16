package de.jdufner.experiments.proxypatterns.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dekorierer implements InvocationHandler {

  private Implementierung implementierung;

  public Dekorierer(final Implementierung implementierung) {
    this.implementierung = implementierung;
  }

  public String bar() {
    return ">>>bar(" + implementierung.getName() + ")<<<";
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
    return ">>>" + (String) method.invoke(implementierung, args) + "<<<";
  }

  public static Schnittstelle buildProxy(final Implementierung implementierung) {
    return (Schnittstelle) Proxy.newProxyInstance(implementierung.getClass().getClassLoader(),
        new Class<?>[] { Schnittstelle.class }, new Dekorierer(implementierung));
  }
}
