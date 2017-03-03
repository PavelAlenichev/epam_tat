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

  @Override
  public String getInformation() {
    return this.textFromFile;
  }

  @Override
  public void putInformation(String data) {
    values.add(data);
  }

  public void setSection(String section) {
    this.section = section;
  }
}
