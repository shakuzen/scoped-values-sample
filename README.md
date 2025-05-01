# Java Scoped Values sample

Using JDK 25, this writes some semi-realistic sample code using Scoped Values to demonstrate its usage and limitations. See [JEP 506](https://openjdk.org/jeps/506).

## Framework code

The [framework package](src/main/java/com/example/demo/framework) contains simplified framework code that is to be used as a library by application code. It encapsulates behavior about determining the user role attached to a request served by the framework to the application code. It checks an appropriate role is currently associated when the Framework `readKey` method is called.

## Application code

The other packages contain different versions of application code that should functionally be the same. They each call `readKey` for `a` and `b` and use the results of that.

The [serial package](src/main/java/com/example/demo/serial) does the work on the main application thread in serial.

The [structured package](src/main/java/com/example/demo/structured) does the work in parallel using Structured Concurrency. That depends on [JEP 505](https://openjdk.org/jeps/505), which is currently planned to be a Preview Feature in Java 25.

The [unstructured package](src/main/java/com/example/demo/unstructured) does the work in parallel using an `ExecutorService` with virtual threads. This does not depend on any Preview Feature in the current builds of JDK 25, but it also does not work. The child threads do not inherit the scoped value containing the `Role` that will be checked by the framework. See the ["Inheriting scoped values" section](https://openjdk.org/jeps/506#Inheriting-scoped-values) of the JEP.
