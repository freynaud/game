package com.ebay.game;

public class Game {

  private Figure left;
  private Figure right;
  private GameResult result;


  public Game(Figure left, Figure right) {
    this.left = left;
    this.right = right;
    this.result = new RuleEngine().getRuling(left, right);
  }

  public Result getResult() {
    return result.getResult();
  }

  public String toString() {
    switch (result.getResult()) {
      case DRAW:
        return left + " vs " + right + " is a draw";
      case LEFT_WIN:
        return left + " " + result.getVerb() + " " + right;
      case LEFT_LOSE:
        return right + " " + result.getVerb() + " " + left;
      default:
        throw new RuntimeException("no default");
    }

  }
}
