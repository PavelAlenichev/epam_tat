import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Class for contact with user by method contact, uses BufferedReader
 */
public class Contacter {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Adding a new person
     * chose option
     * exit if user type "exit"
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void contact() throws IOException, SQLException, ClassNotFoundException {

        String input_text = "one";
        while (!input_text.equals("exit")){
          System.out.println("Input human's name: ");
          String name = reader.readLine();
          System.out.println("Input human's surname: ");
          String surname = reader.readLine();
          System.out.println("Input human's sex: ");
          String sex = reader.readLine();
          System.out.println("Input human's age: ");
          Integer age = Integer.parseInt(reader.readLine());

          DbHandler.WriteDB(new People(name, surname, sex, age));
          People.incrementId();

          System.out.println("Choose information, what you want to get: \n" +
                  "1. Average age of all users \n" +
                  "2. The most old user \n" +
                  "3. The most popular female name \n" +
                  "4. All people with _similar surname \n" +
                  "Press any key to ignore this option.");

          int numberOfAction = Integer.parseInt(reader.readLine());
          optionManager(numberOfAction);

          System.out.println("If you want stop the program, please type \"exit\" ");
          input_text = reader.readLine();
        }
    }

    /**
     * chosing option, what user want
     * @param numberOfAction
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private void optionManager(int numberOfAction) throws SQLException, ClassNotFoundException, IOException {
        switch (numberOfAction) {
            case 1:
                DbHandler.calculateAverageAge();
                break;
            case 2:
                DbHandler.mostOldUser();
                break;
            case 3:
                DbHandler.mostPopularFemName();
                break;
            case 4:
                System.out.println("Print surname:");
                String sur = reader.readLine();
                DbHandler.getPeopleWithThisSurname(sur);
                break;
            default:
                break;
        }
    }
}
