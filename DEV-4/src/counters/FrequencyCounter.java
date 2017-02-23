package counters;

import abstractClasses.Counter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which count frequency of number pair of letters
 */
public class FrequencyCounter extends Counter {

  private final double ONE_MORE = 1.0;
  private final String REGEX_TO_CHECK = "\\W*\\d*\\_*";
  private final char FIRST_SYMBOL = 'a';
  private final char LAST_SYMBOL = 'z';

  private ArrayList<String> listOfWords = new ArrayList<>();
  private HashMap<String, Double> frequencyMap = new HashMap<>();
  private int wholePairCounter = 0;

  /**
   * Constructor initializes listOfWords
   */
  public FrequencyCounter(ArrayList<String> list) {
    listOfWords = list;
  }

  /**
   * separates every words to char combination and calculate frequency
   */
  @Override
  protected void calculate() {
    for (String word : listOfWords) {
      for (int i = 1; i < word.length(); i++) {
        String twoChars = word.substring(i - 1, i + 1).toLowerCase();
        char[] pairOfChars = twoChars.toCharArray();
        if ((((pairOfChars[0] <= LAST_SYMBOL) && (pairOfChars[0] >= FIRST_SYMBOL)) &&
            (((pairOfChars[1] <= LAST_SYMBOL) && (pairOfChars[1] >= FIRST_SYMBOL))))) {
          if (frequencyMap.containsKey(twoChars)) {
            frequencyMap.put(twoChars, (frequencyMap.get(twoChars) + ONE_MORE) / wholePairCounter);
          } else {
            frequencyMap.put(twoChars, (ONE_MORE / wholePairCounter));
          }
        }
      }
    }
  }

  /**
   * uses findFrequency to calculate and return Map with values
   */
  @Override
  public Map getValue() {
    findFrequency();
    return frequencyMap;
  }

  /**
   * does methods to find frequency
   */
  private void findFrequency() {
    fixWordList();
    numberOfPairs();
    calculate();
  }

  /**
   * calculating number of whole pair to correct calculating
   */
  private void numberOfPairs() {
    for (String word : listOfWords) {
      for (int i = 1; i < word.length(); i++) {
        String twoChars = word.substring(i - 1, i + 1).toLowerCase();
        wholePairCounter++;
      }
    }
  }

  /**
   * fixing word list because we need to ignore non-letter symbols
   */
  private void fixWordList() {
    for (int i = 0; i < listOfWords.size(); i++) {
      String word = listOfWords.get(i);
      word = word.replaceAll(REGEX_TO_CHECK, "");
      listOfWords.remove(i);
      listOfWords.add(i, word);
    }
  }
}