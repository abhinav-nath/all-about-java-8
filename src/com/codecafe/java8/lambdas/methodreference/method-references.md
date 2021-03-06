# Method References

- The sole purpose of Method Reference is to simplify the implementation of Functional Interface
- But we already did that by using Lambdas !
- Lambdas helped us to move away from creating Anonymous Inner Classes
- Now Method References are used to simplify the Lambda Expression itself

It is also known as a **Shortcut** for writing Lambda Expressions

> From its name it is clear that it is used to refer a method in a class


## Syntax

```java
Instance::methodName
ClassName::instance-methodName
ClassName::static-methodName
ClassName::new
```

## Where to use Method Reference?

When we are taking an input in a Lambda Expression and directly passing it to a method without doing anything else on the input parameter.

Example:

Using Lambda:

```java
Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();
```

Using Method Reference:

```java
Function<String, String> toUpperCaseLambda = String::toUpperCase;
```