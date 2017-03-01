/**
 * Created by berthold on 01.03.2017.
 */
public class Defineder {

  private String[] input;
  Pattern pattern;

  Defineder(String[] input, Pattern pattern) {
    this.pattern = pattern;
    for (int i = 0; i < input.length; i++) {
      this.input[i] = input[i];
    }
  }

  public int defineTime() {
    int timeIs = 0;
    if (input[0].matches(pattern.getTimeSeparater())) {
      timeIs = 0;
    } else if (input[1].matches(pattern.getTimeSeparater())) {
      timeIs = 1;
    } else {
      timeIs = -1;
    }
    return timeIs;
  }

  public int defineDate() {
    int DateIs = 1;
    if (input[0].matches(pattern.getDateSeparator())) {
      DateIs = 0;
    } else if (input[1].matches(pattern.getDateSeparator())) {
      DateIs = 1;
    } else {
      DateIs = -1;
    }
    return DateIs;
  }
}