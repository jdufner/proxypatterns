package de.jdufner.experiments.proxypatterns.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dekorierer implements InvocationHandler {

  private Schnittstelle implementierung;

  public Dekorierer(final Schnittstelle implementierung) {
    this.implementierung = implementierung;
  }

  public String m2() {
    String result = ((Implementierung) implementierung).getName() + ":m2";
    System.out.println(result);
    return result;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
    return method.invoke(implementierung, args);
  }

  public static Schnittstelle buildProxy(final Schnittstelle schnittstelle) {
    return (Schnittstelle) Proxy.newProxyInstance(schnittstelle.getClass().getClassLoader(), new Class<?>[] { Schnittstelle.class },
        new Dekorierer(schnittstelle));
  }
}
