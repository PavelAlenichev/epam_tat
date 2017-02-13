import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Entry point in application
 * Checking for input type
 * Creating exemplar of ReversedPolishNotation
 * and give string with expression there
 * (Class ReversedPolishNotation doesn't support negative numbers and exp view of numbers)
 * Code is working as task asks, but can't process some exceptions like ^
 */
public class Main {
    public static void main(String[] args) {
        String expression = "";
        if (args == null) {
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
          try {
            expression = reader.readLine();
          } catch (IOException e) {
            System.out.println("Wrong expression");
          }
          new ReversedPolishNotation(expression);
        } else {
          for (int i = 0; i < args.length; i++) {
            expression += args[i];
          }
          new ReversedPolishNotation(expression);
        }
    }
}