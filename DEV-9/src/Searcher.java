import java.util.NoSuchElementException;

/**
 * Created by User on 03.03.2017.
 */
public class Searcher {

  public void searchSection(String file, String section, Keeper keeper){

    int firstOccurrence;
    int newSection;
    char sectionOpen = '[';
    if (isExist(file,section)) {
      firstOccurrence = file.indexOf(section);
      newSection = file.indexOf(sectionOpen, firstOccurrence + 1);
      keeper.setSection(file.substring(firstOccurrence, newSection));
    }
  }

  public void searchValues(String section, String key, Keeper keeper) {

    if(isExist(section,key)) {

    }


  }

  private boolean isExist(String wholeString, String value){
    if (wholeString.contains(value)) {
      return true;
    } else {
      throw new NoSuchElementException();
    }
  }

}
