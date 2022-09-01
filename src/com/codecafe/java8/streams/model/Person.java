package com.codecafe.java8.streams.model;

public class Person {

  private final String firstName;
  private final String lastName;
  private final Gender gender;
  private final int age;
  private final int numberOfCars;

  public Person(String firstName, String lastName, Gender gender, int age, int numberOfCars) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.age = age;
    this.numberOfCars = numberOfCars;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }

  public int getNumberOfCars() {
    return numberOfCars;
  }

  @Override
  public String toString() {
    return "Person{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", gender=" + gender +
      ", age=" + age +
      ", numberOfCars=" + numberOfCars +
      '}';
  }

}