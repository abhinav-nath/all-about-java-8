*Notes taken from Java Brains YouTube channel
"Java 8 Lambda Basics"
https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3

------------------
Function as values
------------------

+ Let's take a relation from Inline Values.

  Consider below syntax:

  String name = "foo"; double pi = 3.14;

  We can define the values to the literals inline.
  "foo" is a value which we assigned to a variable named "name".

  So it is pretty clear that data acts as a value and we can assign it to different types. Objects can also be assigned to references as values.

+ The question is : Can we assign a block of code to a variable as a value?
+ So now the value is not execution of the block of code but the block of code itself.

+ Can we do something like this ?

  aBlockOfCode = { ... ... }

+ What is the standard way of writing a block of code in Java (prior to Java 8) ? It is the method !!

+ Let's say we have this perform() method

  public void perform() { System.out.println("Hello World"); }

+ Let's say if we want to assign this method to a variable

  aBlockOfCode = public void perform() { System.out.println("Hello World"); }

+ This is possible in Java 8 using Lambda. We can write a Lambda expression which does just this.

+ Let's see how to write this lambda expression

+ The above code has a lot of extra things which we don't need.

+ Does this function need to be public ? Off-course not! We need to specify the visibility of the method when it is inside/part of a class. Makes no sense to specify the visibility of the function. A
  function is accessible to whoever has it. So let's get rid of the access specifier:

  aBlockOfCode = void perform() { System.out.println("Hello World"); }

+ Does this function need a name ? NO. When we saw the example of inline values, we assigned the value "foo" to a String named "name". So, the value is accessible by using the name of the variable to
  which it is assigned to. Similarly this function would be accessible by the name of the variable it is assigned to, and hence does not need a name for itself. Let's remove the name as well:

  aBlockOfCode = void        () { System.out.println("Hello World"); }

+ The creators of the language would have stopped here and could have said that this is a lambda expression. But, they went a step further.

+ Can you tell me what is the return type of this function by looking at the code? You don't actually need to look at the "void", you can look at the code and tell that this function returns nothing.
  So basically we can figure out the return type of the function by looking at the type of value being returned. Java compiler is smart enough to do just that!
  It says if you are writing a Lambda expression, don't tell me what the return type is. I can figure it out by looking at the code.

  So, let's remove the return type as well:

  aBlockOfCode =                    () { System.out.println("Hello World"); }

+ So this is what is left. These are the elements that you need to provide in order to write a lambda expression. The syntax is pretty much this for a lambda expression except for one small addition
  i.e. the -> operator

+ This is now a perfect lambda expression :

  aBlockOfCode = () -> { System.out.println("Hello World"); }

+ So, if you know how to write a method in Java, you can write Lambda Expressions.

+ Recipe to create a lambda expression :
  1. Take a method
  2. Remove it's access specifier
  3. Remove it's return type
  4. Remove it's name
  5. Add the -> operator between the method arguments and the method body

+ There is one more thing that we can do, if you have a single line method body then you can even remove the curly braces {}

---------------------------------------------------------
aBlockOfCode = () -> System.out.println("Hello World");
---------------------------------------------------------

** We have not yet mentioned the type of the LHS (aBlockOfCode), we will cover this soon.

+ But till then let us practice writing few more simple lambda expressions:

  Ex :
  greetingFunction = () -> System.out.println("Hello World");

  Ex :
  doubleTheNumberFunction = (int a) -> return a * 2;

+ One more optimization, if there is a single line function body then no need to write "return" keyword as well:

  doubleTheNumberFunction = (int a) -> a * 2;

  Ex :
  addFunction = (int a, int b) -> a + b;

  Ex (with body) :
  safeDivideFunction = (int a, int b)  -> { if(b==0) return 0; return a/b; };

  Ex :
  stringLengthCountFunction = (String s) -> s.length();

*******************************************************
| Now let's move on to answer the Pending Questions | | 1. What is the type of the LHS holding the L.E. ? | | 2. Given a variable that holds the L.E., how do | | execute the function ? |
*******************************************************

We have been looking at below code till now:

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

We had a Greeting interface and it's implementation class HelloWorldGreeting. The implementation is passed in to the greet() method and it executes the implementation of the perform() method.

We want to change it to a Lambda Expression.

myLambdaFunction = () -> System.out.println("Hello World"); // this will give error because myLambdaFunction must have a type

Imagine we have a type called FunctionType:

FunctionType myLambdaFunction = () -> System.out.println("Hello World");

+ So the FunctionType (if it existed) would have had all the inputs for what this function would be like. FunctionType would tell us:
  1. What are the input arguments to this functions
  2. What is the return type of this function

+ Some imaginary syntax like this :

  FunctionType<void, void> myLambdaFunction = () -> System.out.println("Hello World");

+ But the Java designers did not create a separate new type called FunctionType, instead they said that they have this really nice system in Java to declare functions (or methods) and that is the
  Interface. So they re-used the same construct for declaring Lambda Expressions as well.

+ So here is what we need to do in order to declare a lambda expression:

  Step 1. Create a new Interface

            public class Greeter {

                public void greet(Greeting greeting) {
                    greeting.perform();
                }

                public static void main(String[] args) {
                    Greeter greeter = new Greeter();
                    Greeting greeting = new HelloWorldGreeting();
                    greeter.greet(greeting); // passing a behavior to the greet() method

                    MyLambda myLambdaFunction = () -> System.out.println("Hello World"); // now the compiler is Happy!
                }
            }

            interface MyLambda {
                void foo();
            }

          MyLambda interface enables Java to do the type checking of the lambda expression that we have created.

              Another small example :

              interface MyAddition {
                  int add(int x, int y);
              }

              MyAddition addFunction = (int a, int b) -> a + b;

        + Notice that the Greeting interface is exactly similar to the MyLambda interface

            interface MyLambda { void foo(); }                  interface Greeting { void perform(); }

          Both has one method which takes no arguments and does not return any value.

        * All that matters is to have an Interface which has a method matching the signature of our lambda expression *

          So, it turns out that we can use the Greeting interface to declare our lambda expression

          public class Greeter {

              public void greet(Greeting greeting) {
                  greeting.perform();
              }

              public static void main(String[] args) {
                  Greeter greeter = new Greeter();
                  Greeting greeting = new HelloWorldGreeting();
                  greeter.greet(greeting); // passing a behavior to the greet() method

                  Greeting myLambdaFunction = () -> System.out.println("Hello World");
              }
          }

+ So now we figured out how to declare our lambda expressions.

+ Here is the biggest question:

  How is this Greeting helloWorldGreeting = new HelloWorldGreeting(); different from Greeting lambdaGreeting = () -> System.out.println("Hello World");

  Greeting helloWorldGreeting = new HelloWorldGreeting(); -> Here we are creating an instance of a specific implementation of Greeting interface.

  Greeting lambdaGreeting = () -> System.out.println("Hello World"); -> Here we are creating a lambda expression which is in a way implementing the only method in the Greeting interface.

+ Notice that helloWorldGreeting.perform(); // prints "Hello World"
  lambdaGreeting.perform(); // also prints "Hello World"

+ The lambda function () -> System.out.println("Hello World"); is behaving like an implementation of the Greeting interface. So in a way we are implementing an interface by just implementing the
  function without writing a class.

  However there are certain things which make lambdaGreeting different from the helloWorldGreeting. We will look at these differences later.

+ We can create an anonymous inner class

  Greeting innerClassGreeting = new Greeting() { public void perform() { System.out.println("Hello World"); } };

+ This is not going to create a new instance of another class, instead it will create an inline instance of the Greeting interface with the implementation being inline.

+ Since it is a class that we are defining inside another class hence it is an inner class. And it doesn't have a name so it is known as an Anonymous Inner Class.

+ So this would work as well:
  innerClassGreeting.perform(); // would print "Hello World"

+ So basically we don't really need this:
  Greeting helloWorldGreeting = new HelloWorldGreeting();

+ We can create an anonymous inner class instead. Why to create a new Class HelloWorldGreeting!?

+ Now our comparison is between Greeting lambdaGreeting = () -> System.out.println("Hello World"); and Greeting innerClassGreeting = new Greeting() { public void perform() { System.out.println("Hello
  World"); } };

+ It is very tempting to say "What we are doing with lambda expression is basically just syntactical sugar!"
  Lambda expressions are just some fancy ways of creating anonymous inner classes in Java 8.

+ This is wrong !!

+ For the most purposes, you can think of lambda expressions as a shortcut for creating anonymous inner classes but it is not exactly true.

+ Lambda expressions DO NOT create anonymous inner classes.

+ both of these will work fine and print "Hello World"
  greeter.greet(lambdaGreeting); greeter.greet(innerClassGreeting);