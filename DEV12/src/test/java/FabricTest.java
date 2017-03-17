import Checkers.BlackChecker;
import Checkers.Checker;
import Checkers.WhiteChecker;
import Rules.CheckersRules;
import Rules.Colors;
import ValidatorsForTask.ValidatorForCheckers;
import org.junit.Test;

public class FabricTest {

  private Fabric fabric = new Fabric();
  private CheckersRules rules = new CheckersRules();
  private ValidatorForCheckers validator = new ValidatorForCheckers(rules);

  @Test
  public void testForWhites() {
    Checker a = null;
    try {
      a = fabric.build(Colors.WHITE.ordinal(), "a1", "a7", validator);
    } catch (Exception e) {
      e.getMessage();
    }

    assert(a.getClass().equals(WhiteChecker.class));
  }

  @Test
  public void testForBlacks() {
    Checker a = null;
    try {
      a = fabric.build(Colors.BLACK.ordinal(), "a7", "a1", validator);
    } catch (Exception e) {
      e.getMessage();
    }

    assert(a.getClass().equals(BlackChecker.class));
  }

  @Test
  public void testForOther() {
    Checker a = null;
    try {
      a = fabric.build(3, "a1", "a7", validator);
    } catch (Exception e) {
      e.getMessage();
    }

    assert(a == null);
  }
}