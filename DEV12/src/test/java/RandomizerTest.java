import org.junit.Test;

public class RandomizerTest {

  @Test
  public void lowerCaseTests() {
    RandomForExample randomForExample = new RandomForExample();

    String s = randomForExample.generateLowerCaseRandomExample();

    char first = s.charAt(0);
    char second = s.charAt(1);

    assert (first >= 97 && first <= 104 && second >= 1 && second <= 8);
  }

  @Test
  public void upperCaseTests() {
    RandomForExample randomForExample = new RandomForExample();

    String s = randomForExample.generateUpperCaseRandomExample();

    char first = s.charAt(0);
    char second = s.charAt(1);

    assert (first >= 65 && first <= 72 && second >= 1 && second <= 8);
  }
}