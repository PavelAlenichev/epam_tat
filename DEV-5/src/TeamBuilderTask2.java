import Employees.Employee;
import Employees.Junior;
import Employees.Lead;
import Employees.Middle;
import Employees.Senior;
import java.util.ArrayList;
import java.util.List;


/**
 * Build team by minimal price in fixed productivity
 */
public class TeamBuilderTask2 {

  private ArrayList<Employee> team = new ArrayList<>();
  private int productivity;

  /**
   * return team
   *
   * @param productivity
   * @return team list
   */
  public List<Employee> getTeam(int productivity) {
    this.productivity = productivity;
    buildTeam();
    return team;
  }

  /**
   * build team
   */
  private void buildTeam() {
    Lead lead = new Lead();
    Senior senior = new Senior();
    Middle middle = new Middle();
    Junior junior = new Junior();

    if (productivity >= lead.getProductivity()) {
      team.add(lead);
      productivity -= lead.getProductivity();
    } else if (productivity <= lead.getProductivity() && productivity > senior.getProductivity()) {
      loopAdding(senior, lead);
    } else if (productivity <= senior.getProductivity() && productivity > middle
        .getProductivity()) {
      loopAdding(middle,senior);
    } else if (productivity <= middle.getProductivity() && productivity > junior
        .getProductivity()) {
      loopAdding(junior,middle);
    } else if (productivity < junior.getProductivity()) {
      team.add(junior);
    }
  }

  /**
   * many times add employee in team list
   * @param employeeOne
   * @param employeeTwo
   */
  private void loopAdding(Employee employeeOne, Employee employeeTwo) {
    ComparatorOfEmployees comparator = new ComparatorOfEmployees();

    while (productivity >= employeeOne.getProductivity()) {
      team.add(comparator.compare(employeeOne, employeeTwo, productivity));
      productivity -= comparator.compare(employeeOne, employeeTwo, productivity).getProductivity();
    }
  }
}
