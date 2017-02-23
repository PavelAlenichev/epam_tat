package stringHandlers;

import java.util.ArrayList;

/**
 * Class checks input string for valid separating and split string
 */
public class StringSplitter {

  private String stringToParse;

  /**
   * Constructor. stringToParse uses in methods further
   */
  public StringSplitter(String stringToParse) {
    this.stringToParse = stringToParse;
  }

  /**
   * Splits received string
   *
   * @return Array of Strings
   */
  public ArrayList<String> split() {
    validate();
    String[] arrayOfStrings;
    arrayOfStrings = stringToParse.split(" ");
    ArrayList<String> listOfStrings = new ArrayList<>();
    for (String string : arrayOfStrings) {
      listOfStrings.add(string);
    }
    return listOfStrings;
  }

  /**
   * Check for "_" uses as spaces in string and fix it
   */
  private void validate() {
    if (stringToParse.contains("_")) {
      fix();
    }
  }

  /**
   *  replace all "_" to do successful split
   */
  private void fix(){
    stringToParse.replace("_", " ");
  }
}
