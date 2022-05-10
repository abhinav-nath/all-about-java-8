# Closures

> A closure is a block of code that can be referenced (and passed around) with access to the variables of the enclosing scope.

Since Java 1.1, `anonymous inner classes` have provided this facility in a highly verbose manner. They also have a restriction of only being able to use `final` (and definitely assigned) local
variables.
(Note, even non-final local variables are in scope, but cannot be used.)

Java SE 8 is intended to have a more concise version of this for single-method interfaces, called "lambdas". Lambdas have much the same restrictions as anonymous inner classes, although some details
vary randomly.

Consider `ClosuresExample_1.java`, here we can see that Anonymous Inner Classes resemble closures.

Notice the anonymous inner class that is passed to the `doProcess()` method.

Notice that the implemented `process()` method executes inside the `doProcess()` method. And `doProcess()` method has no visibility of the variable `b`. So how does it work?

Java Runtime keeps track of the value of `b` and it knows that it has the value of 20.

So it knows exactly what to use when `b` is accessed from the `doProcess()` method.

But what if we try to modify the value of `b` inside the implemented `process()` method?

We immediately get an error :

      "Local variable b defined in an enclosing scope must be final or effectively final"

Before Java 8, we would have to declare the variable `b` as `final` which means that we don't intend to change the value of `b`.

But with Java 8, we don't have to declare this variable as `final`.

The variable `b` is considered to be effectively `final` which means, that the compiler says that you don't have to declare it as a `final` but I am going to trust you that you are not going to change
the value of this variable. However, I am still keeping an eye and if you change the value of that variable, **I'll complain!!**

So basically the compiler trusts us to do the right thing but it immediately catches us if we try to do the wrong thing.

**Bottom Line :** We cannot change the variable `b` but we can read its value from the anonymous inner class and when the instance of the inner class gets passed around, the value of the variable `b`
is also passed around.

This is why we are able to get the value of variable `b` inside the `doProcess()` method (its value came in bundled with the instance of the inner class)

Notice that the variable itself is not passed around rather it's frozen value is passed around.

This is something which is very close to the concept of Closures.

---

> Consider ClosuresExample_2.java

As soon as the Java compiler sees that a lambda expression is using a variable `b` that is not in its scope, it freezes the value of `b` and kind of hard-codes the value inside the lambda expression.

So where ever this lambda expression is passed around, it takes the value of `b` as well with it.