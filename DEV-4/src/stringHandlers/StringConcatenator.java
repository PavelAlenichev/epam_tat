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
    System.out.println(currentText);
    return currentText;
  }

  /**
   * private method, where is all functional to paste together all strings
   */
  private void concatenateStrings() {
    partsOfText.add(0, currentText);
    if (partsOfText.size() > 1) {
      for (int i = 1; i < partsOfText.size(); i++) {
        currentText = new StringBuilder(partsOfText.get(i) + " ").append(currentText).toString();
      }
    }
  }
}
