/**
 * Created by berthold on 01.03.2017.
 */
public class StringSplitter {
  private String text;
  private String[] input;

  public StringSplitter(String text) throws NumberFormatException {
    if(text.equals("")) {
      throw new NumberFormatException();
    } else {
      this.text = text;
    }
  }

  public String[] splitString() {
    input = text.split(" ");
    return input;
  }
}
