# Ceremony

> Notes taken from Venkat Subramaniam Sir's conference : "Get a Taste of Lambdas and Get Addicted to Streams"

Lambdas are cute little Anonymous Functions!

- Prior to Java 8, Anonymous Inner classes were used. But they can be called as a **MISSED OPPORTUNITY**. Because instead of creating Anonymous Inner Classes, the Java language designer should have
  create Lambda Expressions back then.


- As you can see in `HighCeremony.java`, there is a lot of ceremony and a lot of noise. The intention of this code is to run just that one line of code (sysout) in another thread!


- Rather than just saying, go run that one line of code, we took that one line of code, wrapped it into a function with a name `run()`
  and then wrapped that function into an Anonymous Inner Class. **That's a lot of work!**


- It is as if we have been treating functions like _Kinder-garden children_.

  ```java
  System.out.println("In another thread");
  ```

- This little code comes to you asks _"could I please go to the neighbourhood park, Please?"_
  And you say, _"No sweetie you cannot go alone, let me send an adult with you!"_ :D


- With Java 8, this little code finally got its freedom to be on its own and walk around.


- When we talk about Functions, a function typically has these 4 things:

  1. Name
  2. Parameter list
  3. Body
  4. Return type


- Now what are the most important parts of the function?

  `Parameter list and Body`


- So a lambda expression has only these two things:

  1. A Parameter list
  2. Body


- In `NoCeremony.java`, we removed the unnecessary parts and we nicely distilled it to a lambda expression :

  ```java
  Thread th = new Thread( () -> System.out.println("In another thread") );
  ```