import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Test;

public class InputOfLanguageOfPatternsTest {

  @Test(expected = RuntimeException.class)
  public void input() throws Exception {

    InputOfLanguageOfPatterns languageOfPatterns = new InputOfLanguageOfPatterns();

    languageOfPatterns.input();

    String data = "-2";
    InputStream stdin = System.in;

    try {
      System.setIn(new ByteArrayInputStream(data.getBytes()));
      Scanner scanner = new Scanner(System.in);
      System.out.println(scanner.nextLine());
    } finally {
      System.setIn(stdin);
    }

    /*ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());

    System.setIn(in);*/
  }
}