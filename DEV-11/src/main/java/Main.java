import java.util.*;
/**
 * Main class of programm
 */
public class Main {

  /**
   * Point of input of program.
   */
  public static void main(String[] args) {

    InputOfLanguageOfPatterns InputOfLanguageOfPatterns = new InputOfLanguageOfPatterns();
    int numberOfLanguage = InputOfLanguageOfPatterns.input();
    DictionaryDataAndTimePatterns dictionary = new DictionaryDataAndTimePatterns();
    dictionary.init();
    InputterOfExpression input = new InputterOfExpression();
    String expression = input.init();
    Outputter output = new Outputter();
    output.init(dictionary, numberOfLanguage, expression);
    }
}
