# Some popular functional interfaces in Java 8

## Functional Interfaces and their SAMs

| Interface         | Function Signature | Example               | Mostly Used By |
|-------------------|--------------------|-----------------------|----------------|
| UnaryOperator<T>  | T apply(T)         | String::toLowerCase   |                |
| BinaryOperator<T> | T apply(T, T)      | BigInteger::add       |                |
| Predicate<T>      | boolean test(T)    | Collection::isEmpty   | filter         |
| Function<T, R>    | R apply(T)         | Arrays::asList        | map            |
| Supplier<T>       | T get()            | Instant::now          | factories      |
| Consumer<T>       | void accept(T)     | System.out::println   | forEach()      |


## Functional Interfaces and their Specializations

| Functional interface  | Function descriptor | Primitive specializations                                                                                                                                                                           |
|-----------------------|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Predicate<T>          | T -> boolean        | IntPredicate, LongPredicate, DoublePredicate                                                                                                                                                        |
| Consumer<T>           | T -> void           | IntConsumer, LongConsumer, DoubleConsumer                                                                                                                                                           |
| Function<T, R>        | T -> R              | IntFunction<R>, IntToDoubleFunction, IntToLongFunction,<br>LongFunction<R>, LongToDoubleFunction, LongToIntFunction,<br>DoubleFunction<R>, ToIntFunction<T>, ToDoubleFunction<T>, ToLongFunction<T> |
| Supplier<T>           | () -> T             | BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier                                                                                                                                          |
| UnaryOperator<T>      | T -> T              | IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator                                                                                                                                            |
| BinaryOperator<T>     | (T, T) -> T         | IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator                                                                                                                                         |
| BiPredicate<L, R>     | (L, R) -> boolean   |                                                                                                                                                                                                     |
| BiConsumer<T, U>      | (T, U) -> void      | ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T>                                                                                                                                         |
| BiFunction<T, U, R>   | (T, U) -> R         | ToIntBiFunction<T, U>, ToLongBiFunction<T, U>, ToDoubleBiFunction<T, U>                                                                                                                             |