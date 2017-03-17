import Checkers.BlackChecker;
import Checkers.WhiteChecker;
import Rules.CheckersRules;
import ValidatorsForTask.ValidatorForCheckers;
import java.util.InvalidPropertiesFormatException;
import org.junit.Test;

public class CheckerTest {


  // FOR WHITE
  //___________________________________________________________________________________
  @Test(expected = InvalidPropertiesFormatException.class)
  public void checkWhiteForInvalidDest() throws InvalidPropertiesFormatException {
    WhiteChecker checker = null;
    CheckersRules rule = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rule);
    try {
      checker = new WhiteChecker("A1", "C1", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }

      checker.getNumberOfSteps();
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkWhiteForInvalidStartCoordinate() throws InvalidPropertiesFormatException {
    WhiteChecker checker = null;
    CheckersRules rule = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rule);
    try {
      checker = new WhiteChecker("A2", "C7", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }

    checker.getNumberOfSteps();
  }

  @Test
  public void checkWhiteConstructor()
  {

    WhiteChecker checker = null;
    CheckersRules rules = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rules);
    try {
      checker = new WhiteChecker("A2", "c1", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e){

    } catch (NullPointerException e){

    }

    assert(checker.getCoordinate().equalsIgnoreCase("a2"));
  }



  //For black
  //________________________________________________________________________________________



  @Test
  public void checkBlackForValid() {
    BlackChecker checker = null;

    CheckersRules rule = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rule);
    try {
      checker = new BlackChecker("D6", "C1", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }


    try {
      checker.getNumberOfSteps();
    } catch (InvalidPropertiesFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void checkBlackConstructor()
  {

    BlackChecker checker = null;
    CheckersRules rules = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rules);
    try {
      checker = new BlackChecker("A7", "c1", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e){

    } catch (NullPointerException e){

    }

    assert(checker.getCoordinate().equalsIgnoreCase("a7"));
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkBlackForInvalidStartCoordinate() throws InvalidPropertiesFormatException {
    BlackChecker checker = null;
    CheckersRules rule = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rule);
    try {
      checker = new BlackChecker("A2", "C1", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }

    checker.getNumberOfSteps();
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkBlackForInvalidDest() throws InvalidPropertiesFormatException {
    BlackChecker checker = null;
    CheckersRules rule = new CheckersRules();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rule);
    try {
      checker = new BlackChecker("A7", "H6", validatorForCheckers);
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }

    checker.getNumberOfSteps();
  }
}