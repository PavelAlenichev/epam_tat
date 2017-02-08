/**
 * Write to command prompt selected text
 */
public class Writer {
    public static void invalidNumberOfOptions() {
        System.out.println("Invalid number of options. 
          Number of options must be at least 3.");
    }

    public static void invalidFormat(){
        System.out.println("Invalid format options. Try -s -t -k, for example. 
          And no more 7 letter in one option.");
    }

    public static void writeThreeOptions(String[] args) {
        for (String i: args) {
          System.out.println(i);
        }
    }

    public static void writeFourMoreOptions(String[] args) {
        for (int i = 0; i < 3; i++) {
          System.out.println(args[Random.randomNumber(args.length)]);
        }
    }

    public static void invalidNumberAndFormat(){
        System.out.println("Invalid number of options and format of them.");
    }
}