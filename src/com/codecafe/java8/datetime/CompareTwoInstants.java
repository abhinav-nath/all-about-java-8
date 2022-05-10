package com.codecafe.java8.datetime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class CompareTwoInstants {

  public static void main(String[] args) {
    Instant now = Instant.now();
    Instant aWeekBefore = now.minus(7, ChronoUnit.DAYS);

    System.out.println("---------------------------------------------");
    System.out.println("Now : " + now);
    System.out.println("A week before : " + aWeekBefore);
    System.out.println("---------------------------------------------");
    System.out.println("now.compareTo(aWeekBefore) = " + now.compareTo(aWeekBefore));
    System.out.println("aWeekBefore.compareTo(aWeekBefore) = " + aWeekBefore.compareTo(aWeekBefore));
    System.out.println("aWeekBefore.compareTo(now) = " + aWeekBefore.compareTo(now));
    System.out.println("---------------------------------------------");
  }

}