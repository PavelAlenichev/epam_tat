import java.math.BigDecimal;

/**
 * Matrix of BigDecimals and some methods to use it
 */
public class ResultMatrix {

  private BigDecimal[][] matrix;
  private int x_param;
  private int y_param;

  /**
   * Constructor to define dimension of matrix
   */
  public ResultMatrix(int x, int y) {
    this.matrix = new BigDecimal[x][y];
    this.x_param = x;
    this.y_param = y;
  }

  /**
   * put number in result matrix[x,y]
   */
  public void putToResultMatrix(int x, int y, BigDecimal number) {
    this.matrix[x][y] = number;
  }

  /**
   * uses to print ResultMatrix in console with pleasant view
   *
   * @return super.toString()
   */
  @Override
  public String toString() {

    for (int i = 0; i < x_param; i++) {
      for (int j = 0; j < y_param; j++) {
        System.out.println(matrix[i][j] + " ");
      }
      System.out.println("\n");
    }

    return super.toString();
  }

  /**
   * uses to get element on x,y coordinates
   *
   * @return matrix[x, y]
   */
  public BigDecimal getElement(int x, int y) {
    return matrix[x][y];
  }
}