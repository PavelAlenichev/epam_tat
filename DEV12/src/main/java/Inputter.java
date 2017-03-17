import Rules.Colors;
import Rules.Rules;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Uses to get coordinates and color from console
 */
public class Inputter {

  private static Logger log = Logger.getLogger(Inputter.class.getName());

  private Rules rules;

  /**
   * using requested rules
   */
  public Inputter(Rules rules) {
    this.rules = rules;
  }

  /**
   * getting correct color from console with asking again if there is some fail
   *
   * @return color as integer
   */
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

  /**
   * @param whichCoordinate start - if start coordinate destination - if destination coordinate
   * generates random examples for hints to user
   *
   * @return position
   */
  public String getPosition(String whichCoordinate) {
    String position = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    RandomForExample random = new RandomForExample();

    int attemptCounter = 10;
    while (attemptCounter > 0) {
      try {
        System.out.println("Print " + whichCoordinate + "(like " +
            random.generateLowerCaseRandomExample() + " or " + random
            .generateUpperCaseRandomExample()
            + " ):");
        position = reader.readLine();
        if (position.matches(rules.getCOORDINATE_EXPRESSION())) {
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
    return position;
  }
}