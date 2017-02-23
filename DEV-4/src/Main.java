import counters.FrequencyCounter;
import counters.WordsCounter;
import stringHandlers.StringConcatenator;
import stringHandlers.StringReader;
import stringHandlers.StringSplitter;

/**
 * Main class in application where others classes are gathering
 */
public class Main {

  private static final int INTERRUPT_NUMBER_OF_OPERATIONS = 3;

  /**
   * Entry point in application
   * uses infinity cycle
   * after 3 iterations could be interrupted
   */
  public static void main(String[] args) {
    int operationCounter = 0;
    StringConcatenator concatenator = new StringConcatenator();
    StringReader reader = new StringReader();
    String receivedText;

    while (true) {
      operationCounter++;
      receivedText = reader.read();
      receivedText = concatenator.concatenate(receivedText);
      StringSplitter parser = new StringSplitter(receivedText);

      if (operationCounter > INTERRUPT_NUMBER_OF_OPERATIONS
          && receivedText.equalsIgnoreCase("exit")) {
        break;
      } else {
        System.out.println((new FrequencyCounter(parser.split()).getValue()));
        System.out.print("Words with over 5 letters: ");
        System.out.println(new WordsCounter(parser.split()).getValue());
      }
      System.out.println("After 3 types you can type \"exit\" to stop the program.");
    }
  }
}
