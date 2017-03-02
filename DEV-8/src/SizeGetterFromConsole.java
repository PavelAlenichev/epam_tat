import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Uses to get dimensions of matrixs from console
 * Contains validating
 */
public class SizeGetterFromConsole {

  /**
   * ****************************************************
   * e.g. we have array dimen [x,y]                     *
   *                                                    *
   * the 0th element of returning array is x            *
   * the 1st element of returning array is y            *
   ******************************************************
   *
   * also validating inputted variables in other method
   *
   * @return array with ints
   */
  public int[] getSizeOfMatrix(){
    int[] size = new int[2];
    String[] parsedInput = new String[2];
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = "";

    System.out.println("Input dimen of the matrix (in format x y)");

    int i = 10;
    while (i != 0) {
      try {
        input = reader.readLine();
        break;
      } catch (IOException e) {
        System.out.println("Something went wrong");
        i--;
        continue;
      }
    }


    parsedInput = input.split(" ");
    validate(parsedInput);

    try {
      size[0] = Integer.parseInt(parsedInput[0]);
      size[1] = Integer.parseInt(parsedInput[1]);
    } catch (NumberFormatException e) {
      System.out.println("Input decimals!");
      getSizeOfMatrix();
    }

    return size;
  }

  /**
   * validating inputted values
   *
   * @param parsedInput
   */
  private void validate(String[] parsedInput) {
    if (parsedInput.length != 2) {
      System.out.println("Please input in correct format!");
      getSizeOfMatrix();
    }
  }
}