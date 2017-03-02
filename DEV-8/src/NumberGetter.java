import java.util.Scanner;

/**
 * Uses to provide soft bound getting numbers
 */
public class NumberGetter implements Getter{

  /**
   * get numbers from console and check it, is it Double
   *
   * @return Double
   */
  @Override
  public Double take() {
    Double number = 0.0;
    Scanner scanner = new Scanner(System.in);

    int attemptCounter = 10;
    while (attemptCounter > 0) {
      try {
        number = scanner.nextDouble();
        if (number.getClass().equals("class java.lang.Double")) {
          break;
        }
      } catch (Exception e) {
        System.out.println("Input valid values");
        attemptCounter--;
        continue;
      }
    }

    return number;
  }
}