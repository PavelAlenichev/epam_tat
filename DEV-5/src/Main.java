/**
 * TODO: one interface for every team builder
 *
 * Gathering input and output
 */
public class Main {

  /**
   * entry point in application
   * @param args
   */
  public static void main(String[] args) {

    ConsoleReader reader = new ConsoleReader();
    Selector selector = new Selector(reader.read());
    selector.giveChoice();
  }
}
