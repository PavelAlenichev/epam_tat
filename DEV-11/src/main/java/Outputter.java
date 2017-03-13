import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class Outputter for output expression with date formatting
 */
public class Outputter {

  Date d = new Date();

  /**
   * Method init for output expression with date formatting
   * param DictionaryDataAndTimePatterns dictionary - dictionary of patterns
   * param int numberOfLanguage - number of language for patterns
   * param String expression - expression for patterns
   */
  public void init(DictionaryDataAndTimePatterns dictionary, int numberOfLanguage,
      String expression) {
    System.out.println("Our data format:");
    for (int i = 0; i < expression.length(); i++) {
      int j = 1;
      while ((j < 8) || (i + j - 1 < dictionary.get().length)) {
        String partOfExpression = expression.substring(i, i + j);
        System.out.println(partOfExpression);
        for (int ii = 0; ii < dictionary.get().length; ii++) {
          if (partOfExpression.equals(dictionary.get()[ii][numberOfLanguage])) {
            SimpleDateFormat sdf = new SimpleDateFormat(dictionary.get()[i][numberOfLanguage]);
            dictionary.get()[i][2] = sdf.format(d).toString();
            sdf = null;
            System.out.println(dictionary.get()[i][2]);
          }
        }
        if (j == 7) {
          System.out.print(expression.charAt(i));
        }
        j++;
      }
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(expression);
    System.out.println("Needed date: " + dateFormat.format(d));
  }
}