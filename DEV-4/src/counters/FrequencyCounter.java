package counters;

import abstractClasses.Counter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which count frequency of number pair of letters
 * (magic)
 */
public class FrequencyCounter extends Counter {

  private final double ONE_MORE = 1.0;

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
        if ((((pairOfChars[0] <= 'z') && (pairOfChars[0] >= 'a')) && (((pairOfChars[1] <= 'z') &&
            (pairOfChars[1] >= 'a'))))) {
          if (frequencyMap.containsKey(twoChars)) {
            frequencyMap.put(twoChars, (frequencyMap.get(twoChars) + ONE_MORE) / wholePairCounter);
          } else {
            frequencyMap.put(twoChars, (ONE_MORE / wholePairCounter));
          }
        }
      }
    }
    System.out.println(wholePairCounter);
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
    validateWordList();
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
   * validating word list because we need to ignore non-letter symbols
   */
  private void validateWordList() {
    for (int i = 0; i < listOfWords.size(); i++) {
      String word = listOfWords.get(i);
      word = word.replaceAll("\\W*\\d*\\_*", "");
      listOfWords.remove(i);
      listOfWords.add(i, word);
    }
  }
}