package com.codecafe.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Skip {

  public static void main(String[] args) {

    List<String> list = Arrays.asList("Adam", "John", "Troy", "Abraham", "Josh", "Riley", "Billy");

    System.out.println("Original List:");
    list.forEach(e -> System.out.print(e + " "));

    List<String> newList = list.stream()
                               .skip(3)
                               .collect(Collectors.toList());

    System.out.println("\nList after skipping first 3 elements:");
    newList.forEach(e -> System.out.print(e + " "));

  }

}