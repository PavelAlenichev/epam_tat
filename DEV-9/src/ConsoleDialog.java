import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 03.03.2017.
 */
public class ConsoleDialog {

  private static Logger log = Logger.getLogger(ConsoleDialog.class.getName());

  public String readSection() {
    String section = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int attempt = 10;
    while (attempt > 0) {
      try {
        section = reader.readLine();

        if (section.isEmpty()) {
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

}
