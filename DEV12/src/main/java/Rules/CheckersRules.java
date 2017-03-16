package Rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 16.03.2017.
 */
public class CheckersRules extends Rules {


  private String[] cells = {
      "A2", "A4", "A6", "A8",
      "B1", "B3", "B5", "B7",
      "C2", "C4", "C6", "C8",
      "D1", "D3", "D5", "D7",
      "E2", "E4", "E6", "E8",
      "F1", "F3", "F5", "F7",
      "G2", "G4", "G6", "G8",
      "H1", "H3", "H5", "H7"
  };

  private List<String> buffer = Arrays.asList(cells);

  private final ArrayList<String> forbiddenCells = new ArrayList<String>(buffer);


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

  public void checkForForbiddenCell(String destination) throws InvalidPropertiesFormatException {

    for(String forbidden : forbiddenCells) {
      if (destination.equalsIgnoreCase(forbidden)) {
        throw new InvalidPropertiesFormatException("Wrong coordinate. It's on forbidden cell.");
      }
    }
  }

}