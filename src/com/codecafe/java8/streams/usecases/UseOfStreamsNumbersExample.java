package com.codecafe.java8.streams.usecases;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UseOfStreamsNumbersExample {

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // find the minimum number in the list
    System.out.println("min number = " +
      numbers.stream()
             .min(Integer::compare)
             .get()
    );

    // find the maximum number in the list
    System.out.println("max number = " +
      numbers.stream()
             .max(Integer::compare)
             .get()
    );

    // double every number in the list
    numbers.stream()
           .mapToInt(value -> value * 2)
           .forEach(System.out::println);

    // double every number and find the total
    System.out.println("sum of double of every number = " +
      numbers.stream()
             .mapToInt(value -> value * 2)
             .sum()
    );

    // find the sum of double of every even number
    System.out.println("sum of double of all even numbers = " +
      numbers.stream()
             .filter(value -> value % 2 == 0)
             .mapToInt(value -> value * 2)
             .sum()
    );

    // double the first even number greater than 3
    System.out.println("double of the first even number greater than 3 = " +
      numbers.stream()
             .filter(value -> value > 3)
             .filter(value -> value % 2 == 0)
             .map(value -> value * 2)
             .findFirst()
    );

    List<Integer> listOfNumbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

    // square of all the distinct numbers
    System.out.println("squares of distinct numbers : " +
      listOfNumbers.stream()
                   .map(n -> n * n)
                   .distinct()
                   .collect(Collectors.toList())
    );

    // sort the list of numbers
    System.out.println("numbers sorted by default sorted method : " +
      listOfNumbers.stream()
                   .sorted()
                   .collect(Collectors.toList())
    );

    System.out.println("numbers sorted by sorted method with naturalOrder comparator : " +
      listOfNumbers.stream()
                   .sorted(Comparator.naturalOrder())
                   .collect(Collectors.toList())
    );

    System.out.println("numbers sorted by sorted method with reverseOrder comparator : " +
      listOfNumbers.stream()
                   .sorted(Comparator.reverseOrder())
                   .collect(Collectors.toList())
    );


    // find 3 distinct smallest numbers from an array of integers
    int[] numArray = {4, 2, 1, 4, 5, 6, 7, 3, 2, 9, 3, 2, 1};

    // with imperative style

    // clone - avoid mutating the original array
    int[] copy = Arrays.copyOf(numArray, numArray.length);

    // sort
    Arrays.sort(copy);

    // pick first 3
    for (int i = 0; i < 3; i++)
      System.out.println(copy[i] + " "); // still need to write logic to find only distinct

    // now with stream
    IntStream.of(numArray).distinct().sorted().limit(3).forEach(System.out::println);
    // original array is not mutated
  }

}