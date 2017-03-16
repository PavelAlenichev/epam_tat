import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for input our language of patterns
 */
public class InputOfLanguageOfPatterns {

  /**
   * Method for input our language of patterns
   *int number of language
   */
  public int input() {
    System.out.println("What do you want to use?");
    System.out.println("C# Date Patterns: 1");
    System.out.println("Java Date Patterns: 2");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String sNuber = null;
    try {
      sNuber = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    int nNumber = Integer.parseInt(sNuber);
    if((nNumber==1) || (nNumber == 2)) {
      return nNumber;
    } else {
      throw new RuntimeException("wrong number. try it again.\n");
    }
  }
}
