# Lambda Function Body

- The body of a lambda expression, and thus the body of the function / method it represents, is specified to the right of the `->` in the lambda declaration

  Here is an example:
  ```java
  (oldState, newState) -> System.out.println("State changed");
  ```


- If your lambda expression needs to consist of multiple lines, you can enclose the lambda function body inside the `{ }` bracket which Java also requires when declaring methods elsewhere.

  Here is an example:

  ```java
  (oldState, newState) -> {
     System.out.println("Old state: " + oldState);
     System.out.println("New state: " + newState);
   }
  ```