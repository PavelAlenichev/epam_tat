package stringHandlers;

import java.util.Scanner;

/**
 * Class to read information from console
 */
public class StringReader {

  private String text = "";

  /**
   * uses scanner to read information from console
   *
   * @return text
   */
  public String read() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input text please: ");
    text = scanner.nextLine();
    return text;
  }
}