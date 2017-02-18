package stringHandlers;

import java.util.ArrayList;

/**
 * Class checks input string for valid separating and split string
 */
public class StringParser {

  private String stringToParse;

  /**
   * Constructor. stringToParse uses in methods further
   */
  public StringParser(String stringToParse) {
    this.stringToParse = stringToParse;
  }

  /**
   * Splits received string
   *
   * @return Array of Strings
   */
  public ArrayList<String> parse() {
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
   * Check for "_" uses as spaces in string and replace them to do successful split
   */
  private void validate() {
    if (stringToParse.contains("_")) {
      stringToParse.replace("_", " ");
    }
  }
}
