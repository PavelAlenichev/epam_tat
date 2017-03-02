/**
 * Created by User on 22.02.2017.
 */
public class TaskPerformer {

  private int productivity;
  private TeamBuilderTask1 teamBuilderTask1;
  private TeamBuilderTask2 teamBuilderTask2;
  private TeamBuilderTask3 teamBuilderTask3;
  private ConsoleReader consoleReader;

  public TaskPerformer(int productivity) {
    this.productivity = productivity;
  }

  public void taskBuilder(int choice) {
    switch (choice){
      case 1:
        System.out.println(teamBuilderTask1.getTeam(productivity));
        break;
      case 2:
        System.out.println(teamBuilderTask2.getTeam(productivity));
        break;
      case 3:
        System.out.println(teamBuilderTask3.getTeam(productivity));
        break;
    }
  }
}
