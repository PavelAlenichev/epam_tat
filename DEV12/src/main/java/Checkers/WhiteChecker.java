package Checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
  public void getDiagonals(String position) {

    char pos[] = position.toCharArray();



  }

  private void setSeparateCoords() throws InvalidPropertiesFormatException {

    char pos[] = this.coordinate.toCharArray();
    ArrayList<Character> position = new ArrayList<Character>();

    for(int i = 0; i < pos.length; i++) {
      position.add(pos[i]);
    }

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