package com.ebay.game;

public class Rule {

  private Figure left;
  private Figure right;
  private String verb;

  private Rule() {};


  public Rule(Figure left, String verb, Figure right) {
    this.left = left;
    this.right = right;
    this.verb = verb;
  }

  public Figure getLeft() {
    return left;
  }

  public Figure getRight() {
    return right;
  }

  public String getVerb() {
    return verb;
  }


}
