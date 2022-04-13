# GOF Patterns
## "Design Patterns: Elements of Reusable Object-Oriented Software"

### Creational Design Patterns
#### Abstract Factory:
Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
#### Builder
Separate the construction of a complex object from its representation so that the same construction process can create different representations.
#### Factory Method
Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
#### Prototype
Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.
#### Singleton
Ensure a class only has one instance, and provide a global point of access to it.

### Structural Design Patterns
#### Adapter
Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
#### Bridge
Decouple an abstraction from its implementation so that the two can vary independently.
#### Composite
Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
#### Decorator
Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
#### Facade
Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
#### Flyweight
Use sharing to support large numbers of fine-grained objects efficiently.
#### Proxy
Provide a surrogate or placeholder for another object to control access to it.

### Behavior Design Patterns
#### Chain Of Responsibility
delegates commands to a chain of processing objects.
#### Command
creates objects that encapsulate actions and parameters.
#### Interpreter
implements a specialized language.
#### Iterator
accesses the elements of an object sequentially without exposing its underlying representation.
#### Mediator
#### Memento
provides the ability to restore an object to its previous state (undo).
#### Observer
is a publish/subscribe pattern, which allows a number of observer objects to see an event.
#### State
allows an object to alter its behavior when its internal state changes.
#### Strategy
allows one of a family of algorithms to be selected on-the-fly at runtime.
#### Template Method
defines the skeleton of an algorithm as an abstract class, allowing its subclasses to provide concrete behavior.
#### Visitor
separates an algorithm from an object structure by moving the hierarchy of methods into one object.
