package stringHandlers;

import java.util.ArrayList;

/**
 * Class which gather parts of text, that were inputted before with inputted just now
 */
public class StringConcatenator {

  private String currentText;
  private ArrayList<String> partsOfText = new ArrayList<>();

  /**
   * public method to gather strings
   */
  public String concatenate(String newText) {
    currentText = newText;
    concatenateStrings();
    return currentText;
  }

  /**
   * private method, where is all functional to paste together all strings
   */
  private void concatenateStrings() {
    partsOfText.add(0, currentText);
    StringBuilder stringBuilder = new StringBuilder();
    if (partsOfText.size() > 1) {
      for (int i = partsOfText.size() - 1; i >= 1; i--) {
        currentText = stringBuilder.append(partsOfText.get(i) + " ").toString();
      }
      currentText = stringBuilder.append(partsOfText.get(0)).toString();
    }
  }
}
