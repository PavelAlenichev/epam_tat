import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Read and validate input productivity
 */
public class ConsoleReader {

  public int read() {
    int productivity = 0;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Input productivity please. Integer number: ");
    try {
      productivity = Integer.parseInt(reader.readLine());
    } catch (IOException e) {
      System.out.println("Something goes wrong!");
    } catch (NumberFormatException e) {
      System.out.println("Write correct productivity!");
      read();
    }

    return productivity;
  }
}
