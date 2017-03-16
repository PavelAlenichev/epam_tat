package Checkers;

import ValidatorsForTask.ValidatorForCheckers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;

/**
 * Class to describe black checkers and way to calculate steps
 */
public class BlackChecker extends Checker {

  private String coordinate;
  private HashMap<Character, Integer> diagonalCoordinates = new HashMap<Character, Integer>();
  private Character letterCoord;
  private Integer digitCoord;
  private String distCoordinate;
  private ValidatorForCheckers validator;

  /**
   * @param coordinate from which cell we must move checker
   * @param distCoordinate to where we need to move checker
   * @param validator to check values
   */
  public BlackChecker(String coordinate, String distCoordinate, ValidatorForCheckers validator)
      throws InvalidPropertiesFormatException {

    this.validator = validator;
    validator.checkForForbiddenCell(coordinate);

    this.coordinate = coordinate.toUpperCase();
    this.distCoordinate = distCoordinate.toUpperCase();
    setSeparateCoords();
  }

  /**
   * get diagonals of moving checker to define boundary values of way
   */
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

  /**
   * check parameters because user can put random numbers in this class
   * do not allow do it
   * and save parameters as different variables, not as string
   */
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

  /**
   * @param position which divided and save to fields of class
   */
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

  /**
   * get number of steps from start point to destiny point
   *
   * @return number of steps
   * @throws InvalidPropertiesFormatException when destination point unavailable
   */
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