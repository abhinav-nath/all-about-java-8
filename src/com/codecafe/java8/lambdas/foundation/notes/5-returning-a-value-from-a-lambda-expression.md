# Returning a Value From a Lambda Expression

You can return values from Java lambda expressions, just like you can from a method.
You just add a return statement to the lambda function body, like this:

```java
(param) -> {
   System.out.println("param: " + param);
   return "return value";
}
```

In case all your lambda expression is doing is to calculate a return value and return it, you can specify the return value in a shorter way.

Instead of this:

```java
(a1, a2) -> { return a1 > a2; }
```

You can write:

```java
(a1, a2) -> a1 > a2;
```

The compiler then figures out that the expression `a1 > a2` is the return value of the lambda expression
 (hence the name `lambda expressions` - as expressions return a value of some kind)