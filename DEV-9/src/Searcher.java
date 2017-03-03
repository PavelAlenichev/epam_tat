import java.util.NoSuchElementException;

/**
 * Created by User on 03.03.2017.
 */
public class Searcher {

  private final static String SECTION = "section";
  private final static String KEY = "key";
  private final static String NEW_LINE = "\n";

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

  private boolean isExist(String wholeString, String value, String method){
    if (wholeString.contains(value)) {
      return true;
    } else {
      throw new NoSuchElementException("No such " + method);
    }
  }

}
