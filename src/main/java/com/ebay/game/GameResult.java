package com.ebay.game;

public class GameResult {

  private Result result;
  private String verb;

  public GameResult(Result result, String verb) {
    this.result = result;
    this.verb = verb;
  }

  public Result getResult() {
    return result;
  }

  public String getVerb() {
    return verb;
  }
}
