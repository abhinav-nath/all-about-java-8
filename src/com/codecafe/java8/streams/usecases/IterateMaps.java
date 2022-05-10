package com.codecafe.java8.streams.usecases;

import java.util.HashMap;
import java.util.Map;

public class IterateMaps {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Tom", 29);
    map.put("Bill", 33);
    map.put("Stacy", 30);
    map.put("Emily", 32);
    map.put("Jack", 35);

    // using lambda to iterate map
    System.out.println("\nKeys and Values using lambda:");
    map.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
  }
}