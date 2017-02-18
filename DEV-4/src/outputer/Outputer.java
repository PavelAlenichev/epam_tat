package outputer;

import abstractClasses.Counter;

/**
 * Uses to output some information
 */
public class Outputer {

  /**
   * print result of getValue of some objects that were inherited from Counter
   */
  public void printInConsole(Counter counter) {
    System.out.println(counter.getValue());
  }
}
