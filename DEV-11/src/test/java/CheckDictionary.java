import org.junit.Test;

public class CheckDictionary {

  @Test
  public void checkDictionaryForNull() {
    DictionaryDataAndTimePatterns dictionary = new DictionaryDataAndTimePatterns();
    assert(dictionary.get() != null);
  }
}
