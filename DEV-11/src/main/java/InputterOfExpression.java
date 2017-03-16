import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for input our expression
 */
public class InputterOfExpression {

  /**
   * Method for input our expression
   * return String with our expression
   */
  public String init() {
    System.out.println("Input your expression.");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String expression = null;
    try {
      expression = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return expression;
  }
}
