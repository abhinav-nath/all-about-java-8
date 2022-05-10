> Notes taken from Java Brains YouTube channel. Link - [Java 8 Lambda Basics](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3 "Java 8 Lambda Basics")

## What are the Problems in OOP and constructs available till Java 7 and how Java 8 tries to solve them ?

- In OOP everything is an object
- You cannot have a piece of logic that exists in isolation. It has to be a part of a class/object.
- All code blocks are "associated" with classes and objects.
- This is most of the times not a problem but it can be a problem sometimes.
- A Java developer has to think in terms of things and nouns instead of actions and verbs. It is always a thing!

For example:

- If you want to have a simple method that just writes `Hello World` to the console, you cannot write a function on its own.
- You have to make it a part of a class (Greeter) which contains that one function. You cannot have a function just in isolation.
- What if you don't want a class, you just need this one piece of logic?
- You cannot do this in Java 7.

```java
public class Greeter {

    public void greet() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet();
    }
}
```

Notice this `greet()` method is always printing `Hello World` to the console.

What if you don't want this `greet()` method to not print `Hello World` all the time but take an input and do different things based on this input?

How to do this in classic Java?

```java
public void greet(_____){
  _____________;
  }
```

One way to do this is to have `greet()` method contain all the possible combinations of all it can do and have the input argument be a switch. If input is this then perform that.

This is not an elegant design.

What we actually want to do is to have the behaviour itself to be passed as an argument to the `greet()` method.

The `greet()` method will not contain any behaviour, it will just take the behaviour and it will perform/execute it.

This can be done in Java 7 by creating an Interface name `Greeting` which has a `perform()` method.

And you pass to the `greet()` method an instance of the `Greeting` interface.

```java
public interface Greeting {
  public void perform();
}
```

```java
class Greeter {
    public void greet(Greeting greeting) {
        greeting.perform();
    }
}
```

You can now create different implementations of the `perform()` method and pass those implementations to the `greet()` method.

The `greet()` method takes the behaviour of the implemented perform() method and executes it.

```java
public class HelloWorldGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello World");
    }
}
```

```java
public class Greeter {

  public void greet(Greeting greeting) {
    greeting.perform();
  }

  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    Greeting greeting = new HelloWorldGreeting();
    greeter.greet(greeting); // passing a behavior to the greet() method
  }
}
```

**This is classic OOP. Polymorphism in action!**

But does this solve our problem?

`It kind of does but there is an extra work that we are doing over here.`

We wanted to pass a behaviour and execute that behaviour.

Looking closely, we are not just passing in a behaviour, we are passing a thing that has a behaviour.

We are not passing in the `perform()` method directly, we are passing a `Greeting` which has a `perform()` method.

**Wouldn't it be cool if we had just an action being passed in rather a class that implements an action!**

Something like this (we could pass the action in and the greet method executes the action):

  ```java
  public void greet(action){
  action();
  }
  ```

Lambdas are built to provide this functionality.

Lambda Expressions are functions which do not belong to a class. They are just functions which exist in isolation.

And here is the best part: these functions can be treated as values!

This is very confusing for someone who is totally used to OOP and haven't done Functional Programming before.


-------------------------------------------------
[Read Next](2-introducing-lambda-expressions.md)