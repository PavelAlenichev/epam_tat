package ValidatorsForTask;

import Rules.Rules;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;

/**
 * Checks some positions directly of checkers
 */
public class ValidatorForCheckers {

  private Rules rules;

  public ValidatorForCheckers(Rules rules) {
    this.rules = rules;
  }

  /**
   * defines is it point included in diagonal sector
   *
   * uses for white sector, because their diagonals directed at top
   *
   * @return true if included false if not
   */
  public boolean checkBetweenForWhite(Map<Character, Integer> diagonals, String coordinate) {

    char letter = coordinate.charAt(0);
    int number = Integer.parseInt(String.valueOf(coordinate.charAt(1)));

    boolean checkState = false;

    if (diagonals.get(letter) <= number) {
      checkState = true;
    } else if (diagonals.get(letter) > number) {
      checkState = false;
    }
    return checkState;
  }

  /**
   * defines is it point included in diagonal sector
   *
   * uses for black sector, because their diagonals directed at bottom
   *
   * @return true if included false if not
   */
  public boolean checkBetweenForBlack(Map<Character, Integer> diagonals, String coordinate) {
    char letter = coordinate.charAt(0);
    int number = Integer.parseInt(String.valueOf(coordinate.charAt(1)));

    boolean checkState = false;

    if (diagonals.get(letter) >= number) {
      checkState = true;
    } else if (diagonals.get(letter) < number) {
      checkState = false;
    }

    return checkState;
  }

  /**
   * uses to check inputted coordinate into checkers class
   *
   * @return true if matches with regular expression
   * @throws InvalidPropertiesFormatException if not valid
   */
  public boolean checkCoordinateForCorrectString(String coordinate)
      throws InvalidPropertiesFormatException {
    boolean checkState = false;
    if (coordinate.matches(rules.getCOORDINATE_EXPRESSION())) {
      checkState = true;
    } else {
      throw new InvalidPropertiesFormatException("Wrong coordinate! Please input like: A2 F6 c3");
    }
    return checkState;
  }

  /**
   * uses to check for forbidden (white if CheckersRules) cells
   *
   * @throws InvalidPropertiesFormatException if coordinate matches with forbidden cells
   */
  public void checkForForbiddenCell(String coordinate)
      throws InvalidPropertiesFormatException {

    for (String forbidden : rules.getFORBIDDEN_CELLS()) {
      if (coordinate.equalsIgnoreCase(forbidden)) {
        throw new InvalidPropertiesFormatException("Wrong coordinate. It's on forbidden cell.");
      }
    }
  }
}