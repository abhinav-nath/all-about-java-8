# Lambdas as Objects

A Java lambda expression is essentially an object.
You can assign a lambda expression to a variable and pass it around, like you do with any other object.

Here is an example:

This shows the interface which the lambda expression implements:

```java
public interface MyComparator {
	 public boolean compare(int a1, int a2);
}
```

And this shows the definition of the lambda expression,
how the lambda expression is assigned to variable, and finally how the lambda expression is invoked by invoking the interface method it implements:

```java
MyComparator myComparator = (a1, a2) -> return a1 > a2;

boolean result = myComparator.compare(2, 5);
```