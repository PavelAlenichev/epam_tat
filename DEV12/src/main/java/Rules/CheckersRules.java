package Rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class describes rules of Checkers
 */
public class CheckersRules extends Rules {

  /**
   * restricted cells
   */
  private String[] cells = {
      "A2", "A4", "A6", "A8",
      "B1", "B3", "B5", "B7",
      "C2", "C4", "C6", "C8",
      "D1", "D3", "D5", "D7",
      "E2", "E4", "E6", "E8",
      "F1", "F3", "F5", "F7",
      "G2", "G4", "G6", "G8",
      "H1", "H3", "H5", "H7"
  };
  private List<String> buffer = Arrays.asList(cells);

  private final ArrayList<String> FORBIDDEN_CELLS = new ArrayList<String>(buffer);
  private final String COORDINATE_EXPRESSION = "^[A-Ha-h]{1}[1-8]{1}"; //like A1 or b4
  private final Integer MIN_FIELD_SIZE = 1;
  private final Integer MAX_FIELD_SIZE = 8;
  private final Integer BLACK_MAX_START_POSITION = 6;
  private final Integer WHITE_MAX_START_POSITION = 3;

  public ArrayList<String> getFORBIDDEN_CELLS() {
    return FORBIDDEN_CELLS;
  }

  public String getCOORDINATE_EXPRESSION() {
    return COORDINATE_EXPRESSION;
  }

  public Integer getMIN_FIELD_SIZE() {
    return MIN_FIELD_SIZE;
  }

  public Integer getMAX_FIELD_SIZE() {
    return MAX_FIELD_SIZE;
  }

  public Integer getBLACK_MAX_START_POSITION() {
    return BLACK_MAX_START_POSITION;
  }

  public Integer getWHITE_MAX_START_POSITION() {
    return WHITE_MAX_START_POSITION;
  }
}