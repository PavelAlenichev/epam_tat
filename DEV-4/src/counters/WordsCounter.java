package counters;

import abstractClasses.Counter;
import java.util.ArrayList;

/**
 * Uses to count number of words, where number of letters is over five
 */
public class WordsCounter extends Counter {

  private ArrayList<String> listOfWords;
  private int counterForFiveMoreWords = 0;

  /**
   * Constructor to initialize object from other class and assign value of string array
   */
  public WordsCounter(ArrayList<String> listOfString) {
    this.listOfWords = listOfString;
  }

  /**
   * calculating words, where number of letters is over five and return object of this class
   *
   * @return wordsCounter
   */
  @Override
  public Integer getValue() {
    calculate();
    return counterForFiveMoreWords;
  }

  /**
   * Calculating number of words, where number of letters is over five
   * Uses private fields
   */
  @Override
  protected void calculate() {
    for (String word : listOfWords) {
      if (word.matches("^\\D{6,}$")) {
        counterForFiveMoreWords++;
      }
    }
  }
}