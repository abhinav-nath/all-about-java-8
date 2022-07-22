# Immutability in Java

```java
public class Sample {
  public static void main(String[] args) {
        goto;
  }
}
```

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem:
Syntax error on token "goto", delete this token

at com.codecafe.java8.functionalprogramming.immutability.SimpleForLoop.main(SimpleForLoop.java:7)
```

### `goto` is a keyword in Java then why does the compiler not allow us to use `goto`?

Let's write a simple for loop in structural style:

```java
public class Sample {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      if (i > 5)
        System.out.println(i);
    }
  }
}
```

Nothing fancy about it until we see it's byte code:

```shell
javap -v Sample.class
```

```shell
    Code:
      stack=2, locals=2, args_size=1
         0: iconst_0
         1: istore_1
         2: iload_1
         3: bipush        10
         5: if_icmpge     26
         8: iload_1
         9: iconst_5
        10: if_icmple     20
        13: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        16: iload_1
        17: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        20: iinc          1, 1
        23: goto          2
        26: return
```

### So Java internally uses `goto` but does not allow us to use it !!

> _`goto` is like matches. You don't go to the children and say, I'm gonna take a shower, here are few matches for you to play with._
>
> `goto` is for adults to deal with.

The problem with `goto` is that it turns code into a _spaghetti code_ which is really hard to work with.

So here is an analogy:

> `goto` is to structural programming
>
> as
>
> assignment is to functional programming

So just like we saw, we don't use goto but there could be gotos in the layers below. In the similar way, when are doing assignment-less programming, it doesn't mean that there is no assignment at all.

It simply means that we don't do assignment in our code but there could be assignment and mutation in layers below our code.

### Now the question is, if we are doing mutation, then what is the problem with it?

- Describing what the code is doing becomes really hard
- Understanding the code becomes really hard
- Maintaining the code becomes really hard
- Making the code concurrent becomes really hard
- leads to errors and bugs in the code

#### Therefore, **"Explicit Mutability"** should be avoided.