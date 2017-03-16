import Checkers.Checker;
import Rules.CheckersRules;
import ValidatorsForTask.StartPositionValidator;
import ValidatorsForTask.ValidatorForCheckers;
import java.util.InvalidPropertiesFormatException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Doing task dev-12 there
 */
public class EntryPoint {

  private static Logger log = Logger.getLogger(EntryPoint.class.getName());

  /**
   * gathering all classes, trying to get values if it error
   *
   * @param args not used
   */
  public static void main(String[] args) {

    CheckersRules rules = new CheckersRules();
    Fabric fabric = new Fabric();
    ValidatorForCheckers validatorForCheckers = new ValidatorForCheckers(rules);
    Inputter inputter = new Inputter(rules);
    StartPositionValidator startPositionValidator = new StartPositionValidator(rules);
    Checker checker = null;

    int color = inputter.getColor();
    String startPos;
    String destPos;

    startPos = inputter.getPosition("start");
    try {
      startPositionValidator.doCheckDependsOnColor(color, startPos);
    } catch (InvalidPropertiesFormatException e) {
      log.log(Level.FINER, e.getMessage(), e);
      System.out.println(e.getMessage());
      startPos = inputter.getPosition("start");
    }

    destPos = inputter.getPosition("destination");

    try {
      checker = fabric.build(color, startPos, destPos, validatorForCheckers);
    } catch (InvalidPropertiesFormatException e) {
      log.log(Level.FINER, e.getMessage(), e);
      System.out.println(e.getMessage());
    }

    try {
      System.out.println("Number of steps : " + checker.getNumberOfSteps().toString());
    } catch (InvalidPropertiesFormatException e) {
      log.log(Level.FINER, e.getMessage(), e);
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      log.log(Level.SEVERE, e.getMessage(), e);
    }
  }
}