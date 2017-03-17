package Checkers;

import java.util.InvalidPropertiesFormatException;

/**
 * class to describe checker
 */
public abstract class Checker {

  /**
   * uses to get minimal number of steps from start to destiny point
   *
   * @return number of steps
   * @throws InvalidPropertiesFormatException when destiny coords aren't valid
   */
  public abstract Integer getNumberOfSteps() throws InvalidPropertiesFormatException;
}