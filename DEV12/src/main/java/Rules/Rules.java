package Rules;

import java.util.ArrayList;

/**
 * Abstract class rules to describe your own rules
 */
public abstract class Rules {

  //there are only primitive getters inherited in CheckersRules, but u can override them as well
  // there is no reason to describe them for my opinion

  public abstract ArrayList<String> getFORBIDDEN_CELLS();

  public abstract String getCOORDINATE_EXPRESSION();

  public abstract Integer getMIN_FIELD_SIZE();

  public abstract Integer getMAX_FIELD_SIZE();

  public abstract Integer getBLACK_MAX_START_POSITION();

  public abstract Integer getWHITE_MAX_START_POSITION();
}