import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Multiply matrixes
 */
public class MatrixMultiplier {

  /**
   * Multiplying matrixs with default algorithm
   * rounding floating point numbers to the second decimal for a pleasant output
   *
   * @param first matrix
   * @param second matrix
   * @param result matrix is BigDecimal
   */
  public void doAction(Matrix first, Matrix second, ResultMatrix result) {

    BigDecimal buffer;

    for (int r = 0; r < second.getY_param(); r++) {
      for (int i = 0; i < first.getY_param(); i++) {
        for (int j = 0; j < second.getX_param(); j++) {
          buffer = result.getElement(i, j);
          buffer = new BigDecimal(first.getElement(i, r) * second.getElement(r, j), MathContext.
              DECIMAL64);
          buffer.add(buffer);

          result.putToResultMatrix(i, j, buffer);
        }
      }
    }
  }
}