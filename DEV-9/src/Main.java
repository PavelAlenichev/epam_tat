import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gathering all classes to do tasks
 * has Logger to log messages
 */
public class Main {

  private static Logger log = Logger.getLogger(Main.class.getName());

  /**
   * filepath received as command line param
   *
   * catches some exceptions and print respective massages
   *
   * @param args has filepath
   */
  public static void main(String[] args) {

    ConsoleDialog dialog = new ConsoleDialog();

    FileHandler handler = new FileHandler();
    FileKeeper keeper = null;

    try {
      keeper = new FileKeeper(handler.read(args[0]));
    } catch (FileNotFoundException e) {
      log.log(Level.FINER, "No such file", e);
    }

    Searcher searcher = new Searcher();

    try {
      searcher.searchSection(keeper.getInformation(), dialog.readSection(), keeper);
      searcher.searchValues(keeper.getSection(), dialog.readKey(), keeper);
    } catch (NoSuchElementException e) {
      log.log(Level.FINER, e.getMessage(), e);
      System.out.println(e.getMessage());
    }

    keeper.toString();
  }
}