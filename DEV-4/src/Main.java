import counters.FrequencyCounter;
import counters.WordsCounter;
import outputer.Outputer;
import stringHandlers.StringConcatenator;
import stringHandlers.StringParser;
import stringHandlers.StringReader;

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
    Outputer outputer = new Outputer();
    String receivedText;

    while (true) {
      operationCounter++;
      receivedText = reader.read();
      receivedText = concatenator.concatenate(receivedText);
      StringParser parser = new StringParser(receivedText);

      if (operationCounter > INTERRUPT_NUMBER_OF_OPERATIONS
          && receivedText.equalsIgnoreCase("exit")) {
        break;
      } else {
        outputer.printInConsole(new FrequencyCounter(parser.parse()));
        System.out.print("Words with over 5 letters: ");
        outputer.printInConsole(new WordsCounter(parser.parse()));
      }
      System.out.println("After 3 types you can type \"exit\" to stop the program.");
    }
  }
}
