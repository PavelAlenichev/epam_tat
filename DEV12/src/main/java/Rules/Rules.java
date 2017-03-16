package Rules;

import java.util.ArrayList;

/**
 * Created by User on 16.03.2017.
 */
public abstract class Rules {


  public abstract ArrayList<String> getFORBIDDEN_CELLS();

  public abstract String getCOORDINATE_EXPRESSION();

  public abstract Integer getMIN_FIELD_SIZE();

  public abstract Integer getMAX_FIELD_SIZE();

  public abstract Integer getBLACK_MAX_START_POSITION();

  public abstract Integer getWHITE_MAX_START_POSITION();

}