import Checkers.WhiteChecker;
import java.util.InvalidPropertiesFormatException;
import org.junit.Test;

/**
 * Created by User on 16.03.2017.
 */
public class CheckerTest {


  @Test
  public void checkConstructor() {
    WhiteChecker checker = null;
    try {
      checker = new WhiteChecker("d1");
    } catch (InvalidPropertiesFormatException e ) {
      System.out.println(e.getMessage());
    }


    checker.getDiagonals();
    checker.getDiagonalCoordinates();
  }

}
