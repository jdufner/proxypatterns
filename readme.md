# Proxy-Patterns

## Gang of Four Decorator-Pattern
Der [Decorator](https://de.wikipedia.org/wiki/Decorator) ist ein Entwurfsmuster um eine Klasse um zusätzliche Funktionalistät zu erweitern. Im Paket `de.jdufner.experiments.proxypatterns.gof_decorator` ist das Entwurfsmuster implementiert.

Vorteile der GoF-Implementierung:
* Eine Klasse kann um zusätzliche Funktionalität erweitert werden, ohne eine Subklasse zu erzeugen und damit die Klassenhierarchie zu verschmutzen.
* Es können neue Methoden und neue Attribute hinzugefügt werden.
* Es kann vor und / oder nach Aufruf der gekapselten Klassen der Aufruf geändert werden.

Nachteile der GoF-Implementierung:
* Der Dekorierer muss alle Methoden des implementierenden Interface implementieren, auch wenn in diesen Methoden keine Funktionalität zugefügt wird.

## Java Dynamic Proxy
Der [Java Dynamic Proxy](http://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Proxy.html) oder [Invocation Handler](http://docs.oracle.com/javase/7/docs/api/java/lang/reflect/InvocationHandler.html) erzeugt mittels eines Interface einen Proxy einer Instanz. Der Proxy verfügt über eine einzige Methode `invoke`, die alle Aufrufe an die Instanz weiterleitet. Mittels dieser Methode kann die Funktionalität der vorhandenen Methoden ergänzt werden. Im Pakte `de.jdufner.experiments.proxypatterns.dynamicproxy` ist ein Beispiel implementiert.

Vorteile eines Dynamic Proxy
* Es kann auf einfache Weise Funktionalität bestehender Methoden geändert werden.
* Es kann, weil im Proxy nur eine Methode existiert, mit einem Proxy ein [Aspekt](https://de.wikipedia.org/wiki/Aspektorientierte_Programmierung) implementiert werden.

Nachteile eines Dynamix Proxy
* Es wird umbedingt ein Interface benötigt. Es kann kein Proxy einer Klasse erzeugt werden, wenn kein Interface vorhanden ist.
* Es können keine zusätzlichen Methoden oder Attribute hinzugefügt werden.

## Javaassist
[Javaassist](http://jboss-javassist.github.io/javassist/) ist eine Bibliothek zur Bytecode-Manipulation. Mit Javassist kann ein Proxy einer Klasse ohne ein Interface angelegt werden. Im Paket `de.jdufner.experiments.proxypatterns.javassistdecorator` ist ein Beispiel implementiert.

Vorteile von Javassist
* Eine Klasse kann um zusätzliche Funktionalität erweitert werden, ohne eine Subklasse zu erzeugen und damit die Klassenhierarchie zu verschmutzen.
* Es können bestehende Methoden um neue Funktionalität erweitern und neue Methoden und neue Attribute hinzufügt werden.
* Es existiert nur eine Methode im Proxy, damit kann auch ein Aspekt implementiert werden kann. 

Nachteile von Javassist
* Der erzeugte Bytecode ist langsamer als die anderen Varianten.

---

# Anmerkung zu Implementierung
Im Beispiel zu Javassist in `de.jdufner.experiments.proxypatterns.javassistdecorator` ist der `Dekorierer` eine Subklasse von `Implementierung`. Das vereinfacht die Verwendung im Javacode.

