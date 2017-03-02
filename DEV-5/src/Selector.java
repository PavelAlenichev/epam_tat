import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * call necessary builder depends on choice
 */
public class Selector {

  private int producitvity;
  private TaskPerformer taskPerformer = new TaskPerformer(producitvity);

  /**
   * constructor
   *
   * @param producitvity
   */
  public Selector(int producitvity) {
    this.producitvity = producitvity;
  }

  /**
   * Dialog with user and print necessary team
   */
  public void giveChoice() {
    System.out.println("Choose function: \n"
        + "1. Max productivity \n"
        + "2. Minimal price in fixed productivity \n "
        + "3. Minimal number of employees rang over junior for fixed productivity");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int choice = 0;
    try {
      choice = Integer.parseInt(reader.readLine());
    } catch (IOException e) {
      System.out.println("Wow! Something went wrong!");
    } catch (NumberFormatException e) {
      System.out.println("Input decimal!");
      giveChoice();
    }

    switch (choice) {
      case 1:
        taskPerformer.taskBuilder(1);
        break;
      case 2:
        taskPerformer.taskBuilder(2);
        break;
      case 3:
        taskPerformer.taskBuilder(3);
      default:
        System.out.println("Please input decimal from 1 to 3");
        giveChoice();
    }
  }
}
