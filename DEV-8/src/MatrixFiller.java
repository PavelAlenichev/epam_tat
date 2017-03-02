/**
 * Class uses to fill matrix with numbers, can be extended
 */
public class MatrixFiller {

  /**
   * filling the received matrix with numbers from console
   *
   * @param matrix which will filling
   * @param number uses console reader to get number, soft bound
   */
  public void fill(Matrix matrix, Getter number) {

    for (int i = 0; i < matrix.getX_param(); i++) {
      for (int j = 0; j < matrix.getY_param(); j++) {
        matrix.addToMatrix(i,j,number.take());
      }
    }
  }
}
