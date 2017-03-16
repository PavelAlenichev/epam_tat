package Rules;

import java.util.InvalidPropertiesFormatException;
import java.util.Map;

/**
 * Created by User on 16.03.2017.
 */
public abstract class Rules {

  public abstract boolean checkBetweenForWhite(Map<Character, Integer> diagonals, String coordinate);

  //TODO: REMOVE!!!!!!!!!!!!!!!!!!!!!SOLID!!
  public abstract void checkForForbiddenCell(String destination) throws InvalidPropertiesFormatException;
}
