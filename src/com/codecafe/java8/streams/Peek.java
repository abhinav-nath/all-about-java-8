package com.codecafe.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
   According to its JavaDocs,
   the intermediate Stream operation java.util.Stream.peek()
   "exists mainly to support debugging" purposes.

   Just use peek() locally, do not push it to VCS :)
*/

public class Peek {

  public static void main(String[] args) {

    List<String> persons = Arrays.asList("Adam", "John", "Troy", "Abraham", "Josh", "Riley", "Billy");

    System.out.println("Peek into stream:");
    List<String> filteredPersons = persons.stream()
                                          .filter(p -> p.startsWith("A"))
                                          .peek(System.out::println)
                                          .collect(Collectors.toList());

    System.out.println("\nFiltered List:");
    filteredPersons.forEach(System.out::println);

  }

}