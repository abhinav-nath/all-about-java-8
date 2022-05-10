package com.codecafe.java8.streams.model;

public class Person {

  private final String name;
  private final Gender gender;
  private final int age;
  private final int numberOfCars;

  public Person(String theName, Gender theGender, int theAge, int numberOfCars) {
    this.name = theName;
    this.gender = theGender;
    this.age = theAge;
    this.numberOfCars = numberOfCars;
  }

  public String getName() {
    return name;
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
    return "Person{" + "name='" + name + '\'' + ", gender=" + gender + ", age=" + age + ", numberOfCars=" + numberOfCars + '}';
  }

}