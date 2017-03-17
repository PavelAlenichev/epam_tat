import Checkers.BlackChecker;
import Checkers.WhiteChecker;
import Rules.CheckersRules;
import Rules.Colors;
import ValidatorsForTask.StartPositionValidator;
import ValidatorsForTask.ValidatorForCheckers;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import org.junit.Before;
import org.junit.Test;

public class ValidatorsTest {



  //START POSITION VALIDATOR TESTS
  CheckersRules checkersRules = new CheckersRules();
  StartPositionValidator validator = new StartPositionValidator(checkersRules);

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkStartPosValidationBlack() throws InvalidPropertiesFormatException {
    validator.doCheckDependsOnColor(Colors.BLACK.ordinal(), "A1");
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkStartPosValidationWhite() throws InvalidPropertiesFormatException {
    validator.doCheckDependsOnColor(Colors.WHITE.ordinal(), "A7");
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkForForbiddenCells() throws InvalidPropertiesFormatException {
    validator.doCheckDependsOnColor(Colors.BLACK.ordinal(), "B1");
  }


  //VALIDATOR FOR CHECKERS TESTS
  CheckersRules rules = new CheckersRules();
  ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rules);
  WhiteChecker whiteChecker;
  BlackChecker blackChecker;

  @Before
  public void setUp() {
    try {
      whiteChecker = new WhiteChecker("A1", "A5", validatorForCheckers);
      blackChecker = new BlackChecker("B6", "a1", validatorForCheckers);
    } catch (Exception e) {

    }
  }

  @Test
  public void testCheckBetweenWhite() {

    Field whiteDiagonalMap = null;
    HashMap result = null;
    //USES REFLECTION TO GET PRIVATE METHODS
    try {
      whiteDiagonalMap = WhiteChecker.class.getDeclaredField("diagonalCoordinates");
      whiteDiagonalMap.setAccessible(true);
      result = (HashMap) whiteDiagonalMap.get(whiteChecker);
    } catch (Exception e) {

    }

    boolean checkState;
    checkState = validatorForCheckers.checkBetweenForWhite(result, "A5");
    assert(checkState);
  }

  @Test
  public void testCheckBetweenBlack() {

    Field blackDiagonalMap = null;
    HashMap result = null;
    //USES REFLECTION TO GET PRIVATE METHODS
    try {
      blackDiagonalMap = BlackChecker.class.getDeclaredField("diagonalCoordinates");
      blackDiagonalMap.setAccessible(true);
      result = (HashMap) blackDiagonalMap.get(blackChecker);
    } catch (Exception e) {

    }

    boolean checkState;
    checkState = validatorForCheckers.checkBetweenForBlack(result, "A1");
    assert(checkState);
  }

  @Test
  public void testCheckStringCorrectParams() {
    boolean state = false;
    try {
       state = validatorForCheckers.checkCoordinateForCorrectString("A1");
    } catch (InvalidPropertiesFormatException e) {

    }
    assert(state);
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void testCheckStringIncorrectParams() throws InvalidPropertiesFormatException {
    boolean state = false;

    state = validatorForCheckers.checkCoordinateForCorrectString("a-6");

    assert(state);
  }

  @Test (expected = InvalidPropertiesFormatException.class)
  public void checkForbiddenCells() throws InvalidPropertiesFormatException {
    validatorForCheckers.checkForForbiddenCell("B1");
  }
}