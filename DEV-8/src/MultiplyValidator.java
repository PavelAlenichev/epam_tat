/**
 * Created by User on 02.03.2017.
 */
public class MultiplyValidator {

  public boolean check(Matrix firstMatrix, Matrix secondMatrix) {
    boolean checked;

    if (firstMatrix.getX_param() == secondMatrix.getY_param()) {
      checked = true;
    } else {
      checked = false;
    }

    return checked;
  }

}
