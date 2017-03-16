package Checkers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by User on 16.03.2017.
 */
public class WhiteChecker extends Checker {

  private String coordinate;
  private HashMap<Character, Integer> diagonalCoordinates = new HashMap<Character, Integer>();
  private Character letterCoord;
  private Integer digitCoord;


  public WhiteChecker(String coordinate) throws InvalidPropertiesFormatException {

    this.coordinate = coordinate.toUpperCase();
    setSeparateCoords();
  }

  //TODO: add validator in params to check as requested
  public void getDiagonals() {

    Character diagCoordLetterUp = letterCoord;
    Integer diagCoordDigitUp = digitCoord;
    while (diagCoordLetterUp <= 'H') {
      diagonalCoordinates.put(diagCoordLetterUp, diagCoordDigitUp);
      diagCoordDigitUp++;
      diagCoordLetterUp++;
      if (diagCoordDigitUp > 8) {
        break;
      }
    }

    Character diagCoordLetterDown = letterCoord;
    Integer diagCoordDigitDown = digitCoord;

    while (diagCoordLetterDown >= 'A') {
      diagonalCoordinates.put(diagCoordLetterDown, diagCoordDigitDown);
      diagCoordDigitDown++;
      diagCoordLetterDown--;

    }
  }

  public HashMap<Character, Integer> getDiagonalCoordinates() {
    System.out.println(diagonalCoordinates);
    return diagonalCoordinates;
  }

  private void setSeparateCoords() throws InvalidPropertiesFormatException {

    char pos[] = this.coordinate.toCharArray();
    ArrayList<Character> position = new ArrayList<Character>();

    for(int i = 0; i < pos.length; i++) {
      position.add(pos[i]);
    }

    addCoordinates(position);
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


  public Integer getNumberOfSteps() {

    return 0;
  }
}