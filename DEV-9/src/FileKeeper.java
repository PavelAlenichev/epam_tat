import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.03.2017.
 */
public class FileKeeper implements IKeeper {

  private String textFromFile;
  private String section;
  private ArrayList<String> values = new ArrayList<>();

  public FileKeeper(String textFromFile) {
    this.textFromFile = textFromFile;
  }

  /**
   * @return text from file
   */
  @Override
  public String getInformation() {
    return this.textFromFile;
  }

  /**
   * add value in values list
   *
   * @param data
   */
  @Override
  public void putInformation(String data) {
    values.add(data);
  }


  public void setSection(String section) {
    this.section = section;
  }

  /**
   * @return setted section
   */
  public String getSection() {
    return section;
  }

  /**
   * prints values
   *
   * @return super.toString()
   */
  @Override
  public String toString() {

    for (String value : values) {
      System.out.println(value);
    }
    return super.toString();
  }
}