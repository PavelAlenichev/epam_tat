/**
 * Created by berthold on 01.03.2017.
 */
public class DateChecker {
  private String datePattern;

  public DateChecker(String datePattern) {
    this.datePattern = datePattern;
  }

  public boolean doCheck(String input) {
    boolean checked;
    if (input.matches(datePattern)){
      checked = true;
    } else {
      checked = false;
    }
    return checked;
  }

}