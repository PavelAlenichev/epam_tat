/**
 * Created by berthold on 01.03.2017.
 */
public class TimeChecker {

  public boolean doCheck(String input, Pattern pattern) {
    boolean checked;
    if (input.matches(pattern.getTimeFormat())){
      checked = true;
    } else {
      checked = false;
    }

    String[] s = null;
    if (checked) {
      s = input.split(pattern.getTimeSeparater());
    }
    if (Integer.valueOf(s[0]) <= 23 && Integer.valueOf(s[1]) <= 59) {
      checked = true;
    } else {
      checked = false;
    }

    return checked;
  }
}
