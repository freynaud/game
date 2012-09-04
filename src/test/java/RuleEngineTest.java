import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.ebay.game.Figure.*;

import com.ebay.game.Figure;
import com.ebay.game.Game;
import com.ebay.game.Result;

import static com.ebay.game.Result.*;


public class RuleEngineTest {


  @Test
  public void draws() {
    for (Figure f : Figure.values()) {
      Game g = new Game(f, f);
      Assert.assertEquals(g.getResult(), Result.DRAW);
    }
  }


  @DataProvider(name = "leftWin")
  public Object[][] createData1() {
    return new Object[][] {                      
      {Scissors, Paper ,"cuts" },
      {Paper, Rock ,"covers"},
      {Rock,Lizard, "crushes"},
      {Lizard, Spock,"poisons"},
      {Spock, Scissors,"smashes"},
      {Scissors,Lizard, "decapitates"},
      {Lizard, Paper,"eats"},
      {Paper, Spock,"disproves"},
      {Spock,Rock, "vaporizes"},
      {Rock,Scissors,"crushes" },
    };
  }
  
  

  @Test
  public void smokeTest() {
    Figure left = Figure.Paper;
    Figure right = Figure.Scissors;

    Game g = new Game(left, right);
    Assert.assertEquals(g.getResult(), Result.LEFT_LOSE);
    
    Game g2 = new Game(right, left);
    Assert.assertEquals(g2.getResult(), Result.LEFT_WIN);

  }

  @Test(dataProvider = "leftWin")
  public void allNonDraw(Figure left, Figure right,String verb) {
    Game g = new Game(left, right);
    Assert.assertEquals(g.getResult(), LEFT_WIN);
    Assert.assertEquals(g.toString(), left+" "+verb+" "+right);

  }
  
  @Test(dataProvider = "leftWin")
  public void allNonDrawReverse(Figure right, Figure left,String verb) {
    Game g = new Game(left, right);
    Assert.assertEquals(g.getResult(), LEFT_LOSE);
    Assert.assertEquals(g.toString(), right+" "+verb+" "+left);
    System.out.println(g);
  }
}
