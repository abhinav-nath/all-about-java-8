package com.codecafe.java8.lambdas.foundation.exercise;

public class Person {

  private final String firstName;
  private final String lastName;
  private final int age;

  public Person(String firstName, String lastName, int age) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
  }

}