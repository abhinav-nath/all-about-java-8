package com.codecafe.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// More examples in UseOfStreamsPersonExample.java

public class Sorting {

  public static void main(String[] args) {

    List<String> persons = Arrays.asList("Adam", "John", "Troy", "Abraham", "Josh", "Riley", "Billy");

    System.out.println("Original List:");
    persons.forEach(e -> System.out.print(e + " "));

    List<String> sortedList = persons.stream()
                                     .sorted()
                                     .collect(Collectors.toList());

    System.out.println("\n\nSorted List:");
    sortedList.forEach(e -> System.out.print(e + " "));

    List<String> naturalOrderList = persons.stream()
                                           .sorted(Comparator.naturalOrder())
                                           .collect(Collectors.toList());

    System.out.println("\n\nNatural Order:");
    naturalOrderList.forEach(e -> System.out.print(e + " "));

    List<String> reverseOrderList = persons.stream()
                                           .sorted(Comparator.reverseOrder())
                                           .collect(Collectors.toList());

    System.out.println("\n\nReverse Order:");
    reverseOrderList.forEach(e -> System.out.print(e + " "));

  }

}