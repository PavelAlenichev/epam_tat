import Employees.Employee;
import Employees.Junior;
import Employees.Lead;
import Employees.Middle;
import Employees.Senior;
import java.util.ArrayList;
import java.util.List;

/**
 * Build team by Max productivity
 */
public class TeamBuilderTask1 {

  private ArrayList<Employee> team = new ArrayList<>();
  private int productivity;

  /**
   * return team list
   *
   * @param productivity
   * @return team
   */
  public List<Employee> getTeam(int productivity) {
    this.productivity = productivity;
    buildTeam();
    return team;
  }

  /**
   * Building team
   */
  private void buildTeam() {
    Lead lead = new Lead();
    Senior senior = new Senior();
    Middle middle = new Middle();
    Junior junior = new Junior();
    if (productivity > senior.getProductivity()) {
      loopAdd(lead);
    } else if (productivity > middle.getProductivity() && productivity <= senior.getProductivity()) {
      loopAdd(senior);
    } else if (productivity > junior.getProductivity() && productivity <= middle.getProductivity()) {
      loopAdd(middle);
    } else if (productivity <= junior.getProductivity()) {
      team.add(junior);
    }
  }

  /**
   * many times add employee in team list
   * @param employee
   */
  private void loopAdd(Employee employee) {
    while (productivity > 0) {
      team.add(employee);
      productivity-=employee.getProductivity();
    }
  }
}
