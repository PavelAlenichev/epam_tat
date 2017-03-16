package Checkers;

import ValidatorsForTask.ValidatorForCheckers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by User on 16.03.2017.
 */
public class BlackChecker extends Checker {

  private String coordinate;
  private HashMap<Character, Integer> diagonalCoordinates = new HashMap<Character, Integer>();
  private Character letterCoord;
  private Integer digitCoord;
  private String distCoordinate;
  private ValidatorForCheckers validator;


  public BlackChecker(String coordinate, String distCoordinate, ValidatorForCheckers rule)
      throws InvalidPropertiesFormatException {

    this.validator = rule;
    rule.checkForForbiddenCell(coordinate);

    this.coordinate = coordinate.toUpperCase();
    this.distCoordinate = distCoordinate.toUpperCase();
    setSeparateCoords();
  }

  //TODO: add validator in params to check as requested
  private void getDiagonals() {

    Character diagCoordLetterUp = letterCoord;
    Integer diagCoordDigitUp = digitCoord;
    while (diagCoordLetterUp <= 'H') {
      diagonalCoordinates.put(diagCoordLetterUp, diagCoordDigitUp);
      diagCoordDigitUp--;
      diagCoordLetterUp++;
      if (diagCoordDigitUp < 1) {
        break;
      }
    }

    Character diagCoordLetterDown = letterCoord;
    Integer diagCoordDigitDown = digitCoord;

    while (diagCoordLetterDown >= 'A') {
      diagonalCoordinates.put(diagCoordLetterDown, diagCoordDigitDown);
      diagCoordDigitDown--;
      diagCoordLetterDown--;

    }
  }

  private void setSeparateCoords() throws InvalidPropertiesFormatException {

    char pos[] = this.coordinate.toCharArray();
    ArrayList<Character> position = new ArrayList<Character>();

    for (int i = 0; i < pos.length; i++) {
      position.add(pos[i]);
    }
    if (validator.checkCoordinateForCorrectString(this.coordinate)) {
      addCoordinates(position);
    }
  }

  private void addCoordinates(ArrayList<Character> position)
      throws InvalidPropertiesFormatException {
    if (position.get(0) > '0' && position.get(0) < '9') {
      this.digitCoord = Integer.parseInt(String.valueOf(position.get(0)));
      this.letterCoord = position.get(1);
    } else if (position.get(0) >= 'A' && position.get(0) <= 'H') {
      this.letterCoord = position.get(0);
      this.digitCoord = Integer.parseInt(String.valueOf(position.get(1)));
    } else {
      throw new InvalidPropertiesFormatException("Wrong start coordinate ADD COORDINATES");
    }
  }

  public Integer getNumberOfSteps() throws InvalidPropertiesFormatException {

    getDiagonals();

    validator.checkForForbiddenCell(distCoordinate);

    if (validator.checkBetweenForBlack(diagonalCoordinates, distCoordinate)) {
      return digitCoord - Integer.parseInt(String.valueOf(distCoordinate.charAt(1)));
    } else {
      throw new InvalidPropertiesFormatException("Wrong destination coordinate NUMBER STEPS BLACK");
    }
  }
}
