package com.codecafe.java8.streams.usecases;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.codecafe.java8.streams.model.Gender;
import com.codecafe.java8.streams.model.Person;

public class UseOfStreamsPersonExample {

  public static void main(String[] args) {

    List<Person> people = Arrays.asList(
      new Person("John", "Wick", Gender.MALE, 35, 1),
      new Person("Charles", "Xavier", Gender.MALE, 75, 2),
      new Person("Stacy", "Holmes", Gender.FEMALE, 28, 1),
      new Person("Bruce", "Banner", Gender.MALE, 38, 2),
      new Person("Bulma", "Blue", Gender.FEMALE, 39, 4),
      new Person("Peter", "Parker", Gender.MALE, 25, 3),
      new Person("Maggie", "Rhee", Gender.FEMALE, 34, 2),
      new Person("John", "Doe", Gender.MALE, 15, 1),
      new Person("Rick", "Grimes", Gender.MALE, 39, 0),
      new Person("Carol", "Peletier", Gender.FEMALE, 42, 0),
      new Person("Nick", "Fury", Gender.MALE, 20, 1),
      new Person("Bob", "Marley", Gender.MALE, 24, 0),
      new Person("Gwen", "Stacy", Gender.FEMALE, 17, 2),
      new Person("Jack", "Sparrow", Gender.MALE, 37, 3),
      new Person("Alexa", "Roberts", Gender.FEMALE, 18, 1),
      new Person("Zachary", "Smith", Gender.MALE, 27, 2),
      new Person("John", "Legend", Gender.MALE, 27, 0),
      new Person("Carol", "Danvers", Gender.FEMALE, 35, 1),
      new Person("John", "Paul", Gender.MALE, 32, 3));

    System.out.println("count of people : " + people.size() + "\n");

    // get the count of males
    long countOfMales = people.stream()
                              .filter(person -> person.getGender() == Gender.MALE)
                              .count();

    System.out.println("count of males : " + countOfMales + "\n");

    // get the distinct first names of males
    List<String> distinctFirstNamesOfMales = people.stream()
                                                   .filter(person -> person.getGender() == Gender.MALE)
                                                   .map(Person::getFirstName)
                                                   .distinct()
                                                   .collect(Collectors.toList());

    System.out.println("distinct first names of males : " + distinctFirstNamesOfMales + "\n");

    // get the count of females
    long countOfFemales = people.stream()
                                .filter(person -> person.getGender() == Gender.FEMALE)
                                .count();

    System.out.println("count of females : " + countOfFemales + "\n");

    // get the names of all females
    List<String> allFemales = people.stream()
                                    .filter(person -> person.getGender() == Gender.FEMALE)
                                    .map(Person::getFullName)
                                    .collect(Collectors.toList());

    System.out.println("all females : " + allFemales + "\n");

    // get the names of all females above 25
    List<String> femalesAbove25 = people.stream()
                                        .filter(person -> person.getGender() == Gender.FEMALE && person.getAge() > 25)
                                        .map(Person::getFullName)
                                        .collect(Collectors.toList());

    System.out.println("females above 25 : " + femalesAbove25 + "\n");

    // get the names of all males above 35 in upper case
    List<String> malesAbove35 = people.stream()
                                      .filter(person -> person.getGender() == Gender.MALE && person.getAge() > 35)
                                      .map(Person::getFullName)
                                      .map(String::toUpperCase)
                                      .collect(Collectors.toList());

    System.out.println("names of males above 35 in upper case : " + malesAbove35 + "\n");

    // get the names of people sorted by their ages
    List<String> sortedByAge = people.stream()
                                     .sorted(Comparator.comparing(Person::getAge))
                                     .map(Person::getFullName)
                                     .collect(Collectors.toList());

    System.out.println("people sorted by age : " + sortedByAge + "\n");

    // get all people having first name as John sorted by their age
    List<Person> johnsSortedByAge = people.stream()
                                          .filter(person -> "John".equals(person.getFirstName()))
                                          .sorted(Comparator.comparing(Person::getAge))
                                          .collect(Collectors.toList());

    System.out.println("Johns sorted by age : " + johnsSortedByAge + "\n");

    // get the names of people sorted by their names
    List<String> sortedByName = people.stream()
                                      .sorted(Comparator.comparing(Person::getFullName))
                                      .map(Person::getFullName)
                                      .collect(Collectors.toList());

    System.out.println("people sorted by name : " + sortedByName + "\n");

    // get the names of people sorted by their first name and last name
    List<String> sortedByFirstNameAndLastName = people.stream()
                                                      .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                                                      .map(Person::getFullName)
                                                      .collect(Collectors.toList());

    System.out.println("people sorted by first name and last name : " + sortedByFirstNameAndLastName + "\n");

    // get the names of people sorted by the length of their names
    List<String> sortedByLengthOfName = people.stream()
                                              .sorted(Comparator.comparing(p -> p.getFullName().length()))
                                              .map(Person::getFullName)
                                              .collect(Collectors.toList());

    System.out.println("people sorted by length of name : " + sortedByLengthOfName + "\n");

    // get the total number of cars
    int totalNumberOfCars = people.stream()
                                  .map(Person::getNumberOfCars)
                                  .reduce(0, Integer::sum);

    System.out.println("total number of cars : " + totalNumberOfCars);
  }

}