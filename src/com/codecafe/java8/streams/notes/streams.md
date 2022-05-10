# Streams

> "Lambdas are the gateway drug. Streams are the real addiction." - Venkat Subramaniam on Streams


Streams are Monads.

In functional programming, a monad is a structure that represents computations defined as sequences of steps. A type with a monad structure defines what it means to chain operations, or nest functions
of that type together.

## How do streams work?

```java
List<String> myList=Arrays.asList("a1","a2","b1","c2","c1");

  myList.stream()
  .filter(s->s.startsWith("c"))
  .map(String::toUpperCase)
  .sorted()
  .forEach(System.out::println);

// C1
// C2
```

- Stream operations are either _intermediate_ or _terminal_.

- _Intermediate_ operations return a stream, so we can chain multiple intermediate operations without using semicolons.
- _Terminal_ operations are either void or return a non-stream result.

In the above example filter, `map` and `sorted` are _intermediate_ operations whereas `forEach` is a *terminal* operation.

Most stream operations accept some kind of _lambda expression_ parameter, a functional interface specifying the exact behavior of the operation. Most of those operations must be both non-interfering
and stateless.

**What does that mean?**

A function is non-interfering when it does not modify the underlying data source of the stream, e.g. in the above example no lambda expression does modify `myList` by adding or removing elements from
the collection.

A function is stateless when the execution of the operation is deterministic, e.g. in the above example no lambda expression depends on any mutable variables or states from the outer scope which might
change during execution.
---

## Different kind of streams

Streams can be created from various data sources, especially collections. Lists and Sets support new methods `stream()` and `parallelStream()` to either create a sequential or a parallel stream.

```java
Arrays.asList("a1","a2","a3")
  .stream()
  .findFirst()
  .ifPresent(System.out::println);  // a1
```

Calling the method `stream()` on a list of objects returns a regular object stream. But we don't have to create collections in order to work with streams as we see in the next code sample:

```java
Stream.of("a1","a2","a3")
  .findFirst()
  .ifPresent(System.out::println);  // a1
```

Just use `Stream.of()` to create a stream from a bunch of object references.

Besides regular object streams Java 8 ships with special kinds of streams for working with the primitive data types int, long and double.

IntStreams can replace the regular for-loop utilizing `IntStream.range()`:

```java
IntStream.range(1,4)
  .forEach(System.out::println);

// 1
// 2
// 3
```

All those primitive streams work just like regular object streams with the following differences:

- Primitive streams use specialized lambda expressions, e.g. `IntFunction` instead of `Function` or `IntPredicate` instead of `Predicate`. And primitive streams support the additional terminal
  aggregate operations `sum()` and `average()`:

  ```java
  Arrays.stream(new int[] {1, 2, 3})
        .map(n -> 2 * n + 1)
        .average()
        .ifPresent(System.out::println);  // 5.0
  ```

- Sometimes it's useful to transform a regular object stream to a primitive stream or vice versa. For that purpose object streams support the special mapping operations `mapToInt()`, `mapToLong()`
  and `mapToDouble`:

  ```java
  Stream.of("a1", "a2", "a3")
        .map(s -> s.substring(1))
        .mapToInt(Integer::parseInt)
        .max()
        .ifPresent(System.out::println);  // 3
  ```

- Primitive streams can be transformed to object streams via `mapToObj()`:

  ```java
  IntStream.range(1, 4)
           .mapToObj(i -> "a" + i)
           .forEach(System.out::println);

  // a1
  // a2
  // a3
  ```


- Here's a combined example: the stream of doubles is first mapped to an int stream and then mapped to an object stream of strings:

  ```java
  Stream.of(1.0, 2.0, 3.0)
        .mapToInt(Double::intValue)
        .mapToObj(i -> "a" + i)
        .forEach(System.out::println);

  // a1
  // a2
  // a3
  ```