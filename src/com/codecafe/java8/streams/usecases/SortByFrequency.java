package com.codecafe.java8.streams.usecases;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SortByFrequency {

  public static void main(String[] args) {
    List<String> words = Arrays.asList("java", "go", "java", "go", "python", "java", "python", "java", "java", "python", "go", "python");

    Map<String, Long> frequencyMap = words.stream()
                                          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println("Frequency map: " + frequencyMap);

    // without modifying the list
    words.stream()
         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
         .entrySet().stream()
         .sorted(Map.Entry.<String, Long>comparingByValue()
                          .thenComparing(Map.Entry.comparingByKey()))
         .flatMap(e -> LongStream.range(0, e.getValue()).mapToObj(l -> e.getKey()))
         .forEach(e -> System.out.print(e + " "));

    System.out.println();

    // modify the list
    words.sort(Comparator.<String>comparingLong(frequencyMap::get)
                         .thenComparing(Comparator.naturalOrder()));

    System.out.println(words);
  }

}
