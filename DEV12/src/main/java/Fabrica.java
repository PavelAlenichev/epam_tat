import Checkers.BlackChecker;
import Checkers.Checker;
import Checkers.WhiteChecker;
import Rules.Colors;
import ValidatorsForTask.ValidatorForCheckers;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by User on 16.03.2017.
 */
public class Fabrica {

  public Checker build(Integer color, String startPos, String destPos, ValidatorForCheckers
      validator) throws InvalidPropertiesFormatException {
    if (color == Colors.WHITE.ordinal()) {
      return new WhiteChecker(startPos, destPos, validator);
    } else if (color == Colors.BLACK.ordinal()) {
      return new BlackChecker(startPos, destPos, validator);
    } else {
      return null;
    }
  }
}