import java.util.NoSuchElementException;

/**
 * Uses to search some variables in text
 */
public class Searcher {

  private final static String SECTION = "section";
  private final static String KEY = "key";
  private final static String NEW_LINE = "\n";

  /**
   * searching such section and save it in Keeper
   *
   * @param file
   * @param section
   * @param keeper
   */
  public void searchSection(String file, String section, Keeper keeper){

    int firstOccurrence;
    int newSection;
    char sectionOpen = '[';

    if (isExist(file,section, SECTION)) {
      firstOccurrence = file.indexOf(section);
      newSection = file.indexOf(sectionOpen, firstOccurrence + 1);
      keeper.setSection(file.substring(firstOccurrence, newSection));
    }
  }

  /**
   * searching such values by key and save them in Keeper
   *
   * @param section
   * @param key
   * @param keeper
   */
  public void searchValues(String section, String key, Keeper keeper) {
    key = key + "=";

    int index = 0;
    int newLineIndex;
    if(isExist(section,key, KEY)) {
      index = section.indexOf(key, index);
      if (index != section.lastIndexOf(key)) {
        while (index != section.lastIndexOf(key)) {
          newLineIndex = section.indexOf(NEW_LINE, index);
          keeper.putInformation(section.substring(index + key.length() + 1, newLineIndex));
          index++;
        }
      }
    }

    if (section.indexOf(key) != section.lastIndexOf(key)) {

    }
  }

  /**
   * checks for existing some element in section or text
   * as message in exception use name of method, that called check
   * to define where is error
   *
   * @param wholeString
   * @param value
   * @param method
   * @return true or
   * @throws NoSuchElementException
   */
  private boolean isExist(String wholeString, String value, String method) throws NoSuchElementException{
    if (wholeString.contains(value)) {
      return true;
    } else {
      throw new NoSuchElementException("No such " + method);
    }
  }
}