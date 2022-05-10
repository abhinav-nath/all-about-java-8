package com.codecafe.java8.functionalprogramming.designpatterns.decorator.example2;

public class Burger {

  private String burgerType;

  // no arg constructor
  public Burger() {
    this.burgerType = "";
  }

  public Burger(String burgerType) {
    this.burgerType = burgerType;
  }

  public Burger addVeggies() {
    System.out.println("Adding veggies to the burger");
    return new Burger(this.burgerType += " Veggie");
  }

  public Burger addCheese() {
    System.out.println("Adding cheese to the burger");
    return new Burger(this.burgerType += " Cheese");
  }

  @Override
  public String toString() {
    return String.format("%s", burgerType + " burger");
  }

}