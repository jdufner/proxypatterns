package de.jdufner.experiments.proxypatterns.javassistdecorator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

public class Bar extends Foo {

  private Foo foo;

  public Bar(final Foo foo) {
    this.foo = foo;
  }

  public String m2() {
    String result = foo.getName() + ":m2";
    System.out.println(result);
    return result;
  }

  public static Bar build(final Foo foo) throws NoSuchMethodException, IllegalArgumentException, InstantiationException,
      IllegalAccessException, InvocationTargetException {

    final ProxyFactory factory = new ProxyFactory();
    factory.setSuperclass(Bar.class);
    factory.setFilter(new MethodFilter() {
      @Override
      public boolean isHandled(final Method method) {
        return method.getDeclaringClass().equals(Foo.class);
      }
    });

    final MethodHandler handler = new MethodHandler() {
      @Override
      public Object invoke(final Object self, final Method thisMethod, final Method proceed, final Object[] args) throws Throwable {
        return thisMethod.invoke(foo, args);
      }
    };

    return (Bar) factory.create(new Class<?>[] { Foo.class }, new Object[] { foo }, handler);
  }

}
