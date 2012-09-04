package com.ebay.game;

import java.util.ArrayList;
import java.util.List;
import static com.ebay.game.Figure.*;

public class RuleEngine {

  List<Rule> rules = new ArrayList<Rule>();

  public RuleEngine() {
    rules.add(new Rule(Scissors, "cuts", Paper));
    rules.add(new Rule(Paper, "covers", Rock));
    rules.add(new Rule(Rock, "crushes", Lizard));
    rules.add(new Rule(Lizard, "poisons", Spock));
    rules.add(new Rule(Spock, "smashes", Scissors));
    rules.add(new Rule(Scissors, "decapitates", Lizard));
    rules.add(new Rule(Lizard, "eats", Paper));
    rules.add(new Rule(Paper, "disproves", Spock));
    rules.add(new Rule(Spock, "vaporizes", Rock));
    rules.add(new Rule(Rock, "crushes", Scissors));
  }

  public GameResult getRuling(Figure left, Figure right) {
    if (left == right) {
      return new GameResult(Result.DRAW, "draw");
    }

    GameResult result = getRuling2(left, right, false);
    if (result == null) {
      result = getRuling2(right, left, true);
    }
    if (result == null) {
      throw new RuntimeException("Rule engine error");
    }
    return result;
  }

  private GameResult getRuling2(Figure left, Figure right, boolean flipped) {
    for (Rule r : rules) {
      if (r.getLeft() == left && r.getRight() == right) {
        Result result = Result.LEFT_WIN;
        if (flipped) {
          result = Result.LEFT_LOSE;
        }
        return new GameResult(result, r.getVerb());
      }
    }
    return null;
  }


}
