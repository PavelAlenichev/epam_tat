import Checkers.WhiteChecker;
import Rules.CheckersRules;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import org.junit.Test;

/**
 * Created by User on 16.03.2017.
 */
public class CheckerTest {


  @Test
  public void checkConstructor() {
    WhiteChecker checker = null;
    try {
      checker = new WhiteChecker("a1", "a2");
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }

    CheckersRules rule = new CheckersRules() {
      @Override
      public boolean checkBetweenForWhite(Map<Character, Integer> diagonals, String coordinate) {
        return super.checkBetweenForWhite(diagonals, coordinate);
      }
    };

    try {
      checker.getNumberOfSteps(rule);
    } catch (InvalidPropertiesFormatException e) {
      System.out.println(e.getMessage());
    }
  }
}