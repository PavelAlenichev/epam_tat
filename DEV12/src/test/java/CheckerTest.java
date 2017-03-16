import Checkers.BlackChecker;
import Checkers.WhiteChecker;
import Rules.CheckersRules;
import ValidatorsForTask.ValidatorForCheckers;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import org.junit.Test;

/**
 * Created by User on 16.03.2017.
 */
public class CheckerTest {


 /* @Test
  public void checkWhite() {
    WhiteChecker checker = null;
    try {
      checker = new WhiteChecker("A1", "D6");
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }

    CheckersRules rule = new CheckersRules();

    try {
      checker.getNumberOfSteps(rule);
    } catch (InvalidPropertiesFormatException e) {
      System.out.println(e.getMessage());
    }
  }*/


  @Test
  public void checkBlack() {
    BlackChecker checker = null;

    CheckersRules rule = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rule);
    try {
      checker = new BlackChecker("A7", "C1", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }


    try {
      checker.getNumberOfSteps();
    } catch (InvalidPropertiesFormatException e) {
      System.out.println(e.getMessage());
    }
  }

}