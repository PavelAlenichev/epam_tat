package ValidatorsForTask;

import Rules.Rules;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;

/**
 * Created by User on 16.03.2017.
 */
public class ValidatorForCheckers {

  private Rules rules;

  public ValidatorForCheckers(Rules rules) {
    this.rules = rules;
  }

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


  public void checkForForbiddenCell(String coordinate)
      throws InvalidPropertiesFormatException {

    for(String forbidden : rules.getFORBIDDEN_CELLS()) {
      if (coordinate.equalsIgnoreCase(forbidden)) {
        throw new InvalidPropertiesFormatException("Wrong coordinate. It's on forbidden cell.");
      }
    }
  }

}
