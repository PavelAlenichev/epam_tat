import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.03.2017.
 */
public class DataKeeper extends Keeper {

  private String textFromFile;
  private ArrayList<String> values = new ArrayList<>();

  public DataKeeper(String textFromFile) {
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
}
