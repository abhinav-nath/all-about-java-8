package com.codecafe.java8.streams.usecases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

  public static void main(String[] args) {
    List<String> fruits = Arrays.asList("apple", "apple", "banana", "mango", "pineapple", "mango", "cherry", "cherry", "apple");

    Map<String, Long> fruitCounts = fruits.stream()
      .collect(Collectors.groupingBy(
        fruit -> fruit,
        Collectors.counting()
      ));

    HashMap<String, Long> fruitCountsHashMap = new HashMap<>(fruitCounts);

    fruitCountsHashMap.forEach((fruit, count) -> System.out.println(fruit + " : " + count));
  }

}