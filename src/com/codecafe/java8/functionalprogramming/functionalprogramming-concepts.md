# Functional Programming Concepts

## Functions as first class citizens

In OOP, objects/data are the first class citizens.

```java
int result=myFunction(int a);  // OOP
```

In Functional Programming, functions are considered as first class citizens. i.e. functions/behavior can be passed around just like objects/data.

```java
Function aFun=myFunction(Function fun); // Functional Programming
```

## Pure functions

There are 2 characteristics which decide whether a function is a pure function or not:

1. The output of a pure function depends only on

- its input parameters
- its internal algorithm


2. A pure function has no side effects

- A side effect can be anything that a method does beside computing and returning a value.
- Any change of instance or class field value is a side effect.
- Pure functions always return the same result with the same input.
- They do not modify the arguments which are passed to them.

   ```java
   // Pure Function
   public int sum(int a, int b) {
      return a + b;
   }
   ```

   ```java
   // Impure Function
   public class ImpureFunction {
      private int value = 0;

      public int add(int nextValue) {
         this.value += nextValue;
         return this.value;
      }
   }
   ```

`accept()` method in `java.util.Consumer` is an impure function, because it takes one input parameter but returns nothing.

   ```java
   void accept(T t);
   ```

**Java doc also says the same:**

**Consumer** -> Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.

- Benefits of Pure Functions:
  - Clarity of thought
  - Easy to reason about
  - Can be used fearlessly as they never modify the shared state or variables

## Higher order functions

Higher order functions are the functions which either take functions as arguments or return them as output or do both.

```java
..higherOrderFunction(Function one,Function orMore)

  OR

  Function higherOrderFunction(..)

  OR

  Function higherOrderFunction(Function func)
```

In Java we implement functions using **Lambda**.

**_So we can say that a Higher order function is a function which either take lambda as input argument or return a lambda or does both._**

## No side effects

## Referential Transparency

- Referential Transparency is a property of a function, variable, or expression whereby _the expression can be replaced by its (evaluated) value without affecting the behavior of the program_.

- You should read "Transparent" as "Doesn't make a difference".

- You could determine the result of applying the function only by looking at the values of its arguments.

- **Pure functions are always Referentially Transparent however a referentially transparent function may not be a pure function.**