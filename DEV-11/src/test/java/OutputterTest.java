import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class OutputterTest {

  private static String exp;
  private static DictionaryDataAndTimePatterns dictionaryDataAndTimePatterns;
  private int numberOfLanguage = 2;

  @Before
  public void initExpression() {
    exp = "some invalid text";

  }

  @Test(expected = Exception.class)
  public void checkFroInvalidExpression() {

    Outputter outputter = new Outputter();
    outputter.init(dictionaryDataAndTimePatterns, numberOfLanguage, exp);
  }

  @Test(expected = Exception.class)
  public void checkForInvalidDict() {
    Outputter outputter = new Outputter();

    DictionaryDataAndTimePatterns dict = mock(DictionaryDataAndTimePatterns.class);

    exp = "d";
    outputter.init(dict, numberOfLanguage, exp);
  }
}