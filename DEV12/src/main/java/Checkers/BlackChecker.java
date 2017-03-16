package Checkers;

import Rules.CheckersRules;
import Rules.Rules;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by User on 16.03.2017.
 */
public class BlackChecker extends Checker{

  private String coordinate;
  private HashMap<Character, Integer> diagonalCoordinates = new HashMap<Character, Integer>();
  private Character letterCoord;
  private Integer digitCoord;
  private String distCoordinate;
  private Rules rule;


  public BlackChecker(String coordinate, String distCoordinate, Rules rule)
      throws InvalidPropertiesFormatException {

    this.rule = rule;
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

    for(int i = 0; i < pos.length; i++) {
      position.add(pos[i]);
    }
    if (this.coordinate.matches(rule.getCOORDINATE_EXPRESSION())) {
      addCoordinates(position);
    } else {
      throw new InvalidPropertiesFormatException("Wrong start coordinate!");
    }
  }

  private void addCoordinates(ArrayList<Character> position)
      throws InvalidPropertiesFormatException {
    if(position.get(0) > '0' && position.get(0) < '9') {
      this.digitCoord = Integer.parseInt(String.valueOf(position.get(0)));
      this.letterCoord = position.get(1);
    } else if (position.get(0) >= 'A' && position.get(0) <= 'H') {
      this.letterCoord = position.get(0);
      this.digitCoord = Integer.parseInt(String.valueOf(position.get(1)));
    } else {
      throw new InvalidPropertiesFormatException("Wrong");
    }
  }

  public Integer getNumberOfSteps() throws InvalidPropertiesFormatException {

    getDiagonals();

    rule.checkForForbiddenCell(distCoordinate);

    if (rule.checkBetweenForBlack(diagonalCoordinates, distCoordinate)) {
      System.out.println(digitCoord - Integer.parseInt(String.valueOf(distCoordinate.charAt(1))));
      return digitCoord - Integer.parseInt(String.valueOf(distCoordinate.charAt(1)));
    } else {
      throw new InvalidPropertiesFormatException("Wrong destination coordinate");
    }
  }
}
