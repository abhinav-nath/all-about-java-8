# Lambda Parameters

## Zero Parameters

If the method you are matching your lambda expression against takes no parameters, then you can write your lambda expression like this:

```java
()->System.out.println("Zero parameter lambda");
```

Notice how the parentheses have no content in between. That is to signal that the lambda takes no parameters.

## One Parameter

If the method you are matching your Java lambda expression against takes one parameter, you can write the lambda expression like this:

```java
(param)->System.out.println("One parameter: "+param);
```

Notice the parameter is listed inside the parentheses.

When a lambda expression takes a single parameter, you can also omit the parentheses, like this:

```java
param->System.out.println("One parameter: "+param);
```

## Multiple Parameters

If the method you match your Java lambda expression against takes multiple parameters, the parameters need to be listed inside parentheses.

Here is how that looks in Java code:

```java
(p1,p2)->System.out.println("Multiple parameters: "+p1+", "+p2);
```

Only when the method takes a single parameter can the parentheses be omitted.

## Parameter Types

Specifying parameter types for a lambda expression may sometimes be necessary if the compiler cannot infer the parameter types from the functional interface method the lambda is matching.

Don't worry, the compiler will tell you when that is the case.

Here is a Java lambda parameter type example:

```java
(Car car)->System.out.println("The car is: "+car.getName());
```