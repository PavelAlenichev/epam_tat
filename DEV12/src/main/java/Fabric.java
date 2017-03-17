import Checkers.BlackChecker;
import Checkers.Checker;
import Checkers.WhiteChecker;
import Rules.Colors;
import ValidatorsForTask.ValidatorForCheckers;
import java.util.InvalidPropertiesFormatException;

/**
 * Tried to do pattern
 */
public class Fabric {

  /**
   * @param color of checker
   * @param startPos of checker
   * @param destPos of checker
   * @param validator which uses to do verification again
   * @return white or black checker depends on parameter
   * !!!EASY TO EXTEND!!!
   * @throws InvalidPropertiesFormatException coordinates incorrect
   * MORE STAGES OF SECIRITY.
   * because user could input his own values into checker
   */
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