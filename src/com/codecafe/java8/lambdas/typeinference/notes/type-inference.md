# Type Infererence

With lambdas, Java compiler is doing something called as Type Inference which is very important to figure out what type of your lambda is and  what type of data it deals with.

## Matching Lambdas to Interfaces

- A single method interface is also sometimes referred to as a functional interface
- Matching a Java lambda expression against a functional interface is divided into these steps:

  1. Does the interface have only one abstract (unimplemented) method?
  2. Does the parameters of the lambda expression match the parameters of the single method?
  3. Does the return type of the lambda expression match the return type of the single method?

If the answer is yes to these three questions, then the given lambda expression is matched successfully against the interface!