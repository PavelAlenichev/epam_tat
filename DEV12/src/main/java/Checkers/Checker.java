package Checkers;

import Rules.CheckersRules;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by User on 16.03.2017.
 */
public abstract class Checker {

  public abstract Integer getNumberOfSteps(CheckersRules rule) throws InvalidPropertiesFormatException;

}
