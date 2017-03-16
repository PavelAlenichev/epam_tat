import Checkers.Checker;
import Rules.CheckersRules;
import ValidatorsForTask.StartPositionValidator;
import ValidatorsForTask.ValidatorForCheckers;
import java.util.InvalidPropertiesFormatException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 16.03.2017.
 */
public class EntryPoint {

  private static Logger log = Logger.getLogger(EntryPoint.class.getName());

  public static void main(String[] args) {

    CheckersRules rules = new CheckersRules();
    Fabrica fabrica = new Fabrica();
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
      checker = fabrica.build(color, startPos, destPos, validatorForCheckers);
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