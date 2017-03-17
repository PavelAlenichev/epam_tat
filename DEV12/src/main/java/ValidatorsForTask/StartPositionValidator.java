package ValidatorsForTask;

import Rules.Colors;
import Rules.Rules;
import java.util.InvalidPropertiesFormatException;

/**
 * Checks start position for correct
 */
public class StartPositionValidator {

  private Rules rules;

  /**
   * use requested rules
   */
  public StartPositionValidator(Rules rules) {
    this.rules = rules;
  }

  /**
   * tried to use some idea of pattern
   * depends on color we use requested check and it relieves many if-elses later
   *
   * @throws InvalidPropertiesFormatException when input position isn't approach to this color
   */
  public void doCheckDependsOnColor(Integer color, String inputPosition)
      throws InvalidPropertiesFormatException {
    Integer position = Integer.parseInt(String.valueOf(inputPosition.charAt(1)));

    if (color == Colors.BLACK.ordinal()) {
      checkBlackStartPosition(position);
    } else if (color == Colors.WHITE.ordinal()) {
      checkWhiteStartPosition(position);
    }
  }

  /**
   * check black position
   *
   * @throws InvalidPropertiesFormatException when checker is beyond over the edge of field of this
   * color
   */
  private void checkBlackStartPosition(Integer startPos) throws InvalidPropertiesFormatException {
    if (!(startPos >= rules.getBLACK_MAX_START_POSITION() && startPos <= rules
        .getMAX_FIELD_SIZE())) {
      throw new InvalidPropertiesFormatException("Invalid start coordinate!");
    }
  }

  /**
   * check white position
   *
   * @throws InvalidPropertiesFormatException when checker is beyond over the edge of field of this
   * color
   */
  private void checkWhiteStartPosition(Integer startPos) throws InvalidPropertiesFormatException {
    if (!(startPos >= rules.getMIN_FIELD_SIZE()) && startPos <= rules
        .getWHITE_MAX_START_POSITION()) {
      throw new InvalidPropertiesFormatException("Invalid start coordinate!");
    }
  }
}