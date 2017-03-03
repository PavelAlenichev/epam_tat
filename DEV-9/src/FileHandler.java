import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Uses to get text from file as String
 */
public class FileHandler {

  /**
   * validating for file existing
   * Reading file string by string
   *
   * @param filePath
   * @return textFromFile as String
   * @throws FileNotFoundException
   */
  public String read(String filePath) throws FileNotFoundException {

    exists(filePath);

    StringBuilder textFromFile = new StringBuilder();

    try {
      try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
        String string;
        while ((string = in.readLine()) != null) {
          textFromFile.append(string);
          textFromFile.append("\n");
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return textFromFile.toString();
  }

  /**
   * checks for file existing
   *
   * @param filePath
   * @throws FileNotFoundException
   */
  private void exists(String filePath) throws FileNotFoundException {
    File file = new File(filePath);
    if (!file.exists()) {
      throw new FileNotFoundException(file.getName());
    }
  }

}