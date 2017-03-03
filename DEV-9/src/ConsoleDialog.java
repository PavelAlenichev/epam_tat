import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Uses to get Section from console and Key from console
 */
public class ConsoleDialog {

  private static Logger log = Logger.getLogger(ConsoleDialog.class.getName());

  /**
   * get Section from console, logging IOException
   *
   * @return Section
   */
  public String readSection() {
    String section = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int attempt = 10;


    while (attempt > 0) {
      try {
        System.out.println("Please input section: ");
        section = reader.readLine();

        if (section.isEmpty()) {
          System.out.println("Not empty value please.");
          continue;
        } else {
          break;
        }
      } catch (IOException e) {
        log.log(Level.SEVERE, "Exception: IOException", e);
        attempt--;
        continue;
      }
    }

    return section;
  }

  /**
   * read Key from console, logging IOException
   *
   * @return Key
   */
  public String readKey() {
    String key = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int attemptCounter = 10;


    while (attemptCounter > 0) {
      try {
        System.out.println("Please input key: ");
        key = reader.readLine();
        if (key.isEmpty()) {
          System.out.println("Not empty value please.");
          continue;
        } else {
          break;
        }
      } catch (IOException e) {
        log.log(Level.SEVERE, "Exception: IOException", e);
        attemptCounter--;
        continue;
      }
    }

    return key;
  }
}