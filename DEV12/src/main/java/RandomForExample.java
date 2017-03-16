/**
 * Created by User on 16.03.2017.
 */
public class RandomForExample {

  // A - 65 | 72 - H | 97 - a | 104 - h

  private final int FIRST_UPPER_LETTER = 65;
  private final int FIRST_LOWER_LETTER = 97;

  public String generateLowerCaseRandomExample() {
    String rand;
    Character letter = (char) ((Math.random()* 8) + FIRST_LOWER_LETTER);
    Integer number = (int) (Math.random() * 8) + 1;

    rand = letter + number.toString();
    return rand;
  }

  public String generateUpperCaseRandomExample() {
    String random;
    Character letter = (char) ((Math.random()* 8) + FIRST_UPPER_LETTER);
    Integer number = (int) (Math.random() * 8) + 1;

    random = letter + number.toString();
    return random;
  }
}