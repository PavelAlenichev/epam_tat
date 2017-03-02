/**
 * Gathering all classes to correct multiplying with validations
 */
public class Main {

  /**
   * Entry point, creating 2 matrix, getting sizes, validate for could them multiply
   * if true, multiply and printing result matrix in console
   *
   * @param args not used
   */
  public static void main(String[] args) {

    SizeGetterFromConsole size = new SizeGetterFromConsole();
    int[] firstSize = size.getSizeOfMatrix();
    int[] secondSize = size.getSizeOfMatrix();
    Matrix first = new Matrix(firstSize[0], firstSize[1]);
    Matrix second = new Matrix(secondSize[0], secondSize[1]);

    MultiplyValidator validator = new MultiplyValidator();


    if ( !validator.check(first, second)) {
      System.out.println("Wrong size! Cannot multiply!");
    } else {
      MatrixFiller filler = new MatrixFiller();
      NumberGetter numberGetter = new NumberGetter();

      filler.fill(first, numberGetter);
      filler.fill(second, numberGetter);

      MatrixMultiplier multiplier = new MatrixMultiplier();
      ResultMatrix resultMatrix = new ResultMatrix(first.getY_param(), second.getX_param());
      multiplier.doAction(first,second, resultMatrix);

      resultMatrix.toString();
    }

  }

}
