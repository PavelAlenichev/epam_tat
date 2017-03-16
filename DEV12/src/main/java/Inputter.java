import Rules.Colors;
import Rules.Rules;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 16.03.2017.
 */
public class Inputter {

  private static Logger log = Logger.getLogger(Inputter.class.getName());

  private Rules rules;


  public Inputter(Rules rules) {
    this.rules = rules;
  }

  public Integer getColor() {
    Integer color = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int attemptCounter = 10;
    while (attemptCounter > 0) {
      try {
        System.out.println("Chose color: \n 1. Black \n 2. White ");
        color = Integer.parseInt(reader.readLine());
        if (color == Colors.BLACK.ordinal() || color == Colors.WHITE.ordinal()) {
          break;
        } else {
          continue;
        }
      } catch (NumberFormatException e) {
        System.out.println("Please input integer number!");
        continue;
      } catch (IOException e) {
        attemptCounter--;
        log.log(Level.SEVERE, "Exception: IOException", e);
        continue;
      }
    }
    return color;
  }

  public String getPosition(String whichCoordinate) {
    String startPosition = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    RandomForExample random = new RandomForExample();

    int attemptCounter = 10;
    while (attemptCounter > 0) {
      try {
        System.out.println("Print " + whichCoordinate + "(like " +
            random.generateLowerCaseRandomExample() + " or " + random.generateUpperCaseRandomExample()
            + " ):");
        startPosition = reader.readLine();
        if (startPosition.matches(rules.getCOORDINATE_EXPRESSION())) {
          break;
        } else {
          System.out.println("Print coordinates like A5.");
          continue;
        }
      } catch (IOException e) {
        attemptCounter--;
        log.log(Level.SEVERE, "Exception: IOException", e);
        continue;
      }
    }

    return startPosition;
  }
}