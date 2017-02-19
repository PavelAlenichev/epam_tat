package abstractClasses;

/**
 * Abstract class which provides his methods to successors
 * it's generic because outputer receives object of this class
 * so it could be every type what we want
 */
public abstract class Counter<T> {

  /**
   * parent method return null
   * can be used as cap
   * overrides in child classes
   */
  public abstract T getValue();

  /**
   * parent method, which overrides in child classes
   * uses to calculate something
   */
  protected abstract void calculate();
}
