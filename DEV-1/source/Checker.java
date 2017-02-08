/**
 * Class Checker needs to check valid or not input data
 */
public class Checker {
    /**
     * REGEX - String, with which we compare input options
     *
     * It says, that option must start with "-" 
     * I think, that it's most matchable format for that program, 
     * where real options aren't declared
     */
    private static final String REGEX = "^\\-\\D$";

    /**
     * Function to check input options. Basics on number of them
     * @param args - array of Strings
     */
    public static void checkInput(String[] args) {
        switch (args.length) {
          case 0:
            Writer.invalidNumberOfOptions();
            break;
          case 1:
            if (args[0].matches(REGEX)) {
              Writer.invalidNumberOfOptions();
            } else {
                Writer.invalidNumberAndFormat();
            }
            break;
          case 2:
            if (args[0].matches(REGEX) && args[1].matches(REGEX)) {
              Writer.invalidNumberOfOptions();
            } else {
                Writer.invalidNumberAndFormat();
            }
            break;
          case 3:
            if (checkRegex(args)) {
              Writer.writeThreeOptions(args);
            } else {
                Writer.invalidFormat();
            }
            break;
          case 4:
            if (checkRegex(args)) {
              Writer.writeFourMoreOptions(args);
            } else {
                Writer.invalidFormat();
            }
            break;
          default:
            if (checkRegex(args)) {
              Writer.writeFourMoreOptions(args);
            } else {
                Writer.invalidFormat();
            }
            break;
        }
    }

    /**
     * This function check 3 or more options for matching to regular expression
     * @param args - array of Strings
     * @return true or false
     */
    private static boolean checkRegex(String[] args) {
        int k = 0;
        for (int i = 0; i < args.length; i++) {
          if (args[i].matches(REGEX)) {
            k++;
          }
        }
        if (k == args.length) {
          return true;
        } else {
            return false;
        }
    }
}