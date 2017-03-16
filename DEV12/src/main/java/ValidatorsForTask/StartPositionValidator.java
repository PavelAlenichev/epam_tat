package ValidatorsForTask;

import Rules.Colors;
import Rules.Rules;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by User on 16.03.2017.
 */
public class StartPositionValidator {

  private Rules rules;

  public StartPositionValidator(Rules rules) {
    this.rules = rules;
  }

  public void doCheckDependsOnColor(Integer color, String inputPosition)
      throws InvalidPropertiesFormatException {
    Integer position = Integer.parseInt(String.valueOf(inputPosition.charAt(1)));

    if (color == Colors.BLACK.ordinal()) {
      checkBlackStartPosition(position);
    } else if (color == Colors.WHITE.ordinal()) {
      checkWhiteStartPosition(position);
    }
  }

  private void checkBlackStartPosition(Integer startPos) throws InvalidPropertiesFormatException {
    if (!(startPos >= rules.getBLACK_MAX_START_POSITION() && startPos <= rules
        .getMAX_FIELD_SIZE())) {
      throw new InvalidPropertiesFormatException("Invalid start coordinate!");
    }
  }

  private void checkWhiteStartPosition(Integer startPos) throws InvalidPropertiesFormatException {
    if (!(startPos >= rules.getMIN_FIELD_SIZE()) && startPos <= rules
        .getWHITE_MAX_START_POSITION()) {
      throw new InvalidPropertiesFormatException("Invalid start coordinate!");
    }
  }

}