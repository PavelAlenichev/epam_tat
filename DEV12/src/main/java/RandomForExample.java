/**
 * Uses to do random hints to show user
 */
public class RandomForExample {

  // A - 65 | 72 - H | 97 - a | 104 - h
  // as char uses

  private final int FIRST_UPPER_LETTER = 65;
  private final int FIRST_LOWER_LETTER = 97;

  /**
   * @return lower case hint like g3 or a1
   */
  public String generateLowerCaseRandomExample() {
    String rand;
    Character letter = (char) ((Math.random() * 8) + FIRST_LOWER_LETTER);
    Integer number = (int) (Math.random() * 8) + 1;

    rand = letter + number.toString();
    return rand;
  }

  /**
   * @return upper case hint like B2 or C5
   */
  public String generateUpperCaseRandomExample() {
    String random;
    Character letter = (char) ((Math.random() * 8) + FIRST_UPPER_LETTER);
    Integer number = (int) (Math.random() * 8) + 1;

    random = letter + number.toString();
    return random;
  }
}