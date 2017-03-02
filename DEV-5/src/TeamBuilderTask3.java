import Employees.Employee;
import Employees.Junior;
import Employees.Lead;
import Employees.Middle;
import Employees.Senior;
import java.util.ArrayList;
import java.util.List;

/**
 * Build team by Minimal number of employees rang over junior for fixed productivity
 */
public class TeamBuilderTask3 {

  private ArrayList<Employee> team = new ArrayList<>();
  private int productivity;

  /**
   * return team list
   *
   * @param productivity
   * @return
   */
  public List<Employee> getTeam(int productivity) {
    this.productivity = productivity;
    buildTeam();
    return team;
  }

  /**
   * building team
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
      loopAdd(senior, lead);
    } else if (productivity <= senior.getProductivity() && productivity > middle
        .getProductivity()) {
      loopAdd(middle,senior);
    } else if (productivity <= middle.getProductivity() && productivity > junior
        .getProductivity()) {
      loopAdd(junior,middle);
    } else if (productivity < junior.getProductivity()) {
      team.add(middle);
    }
  }

  /**
   * many times add employee in team list
   * @param employeeOne
   * @param employeeTwo
   */
  private void loopAdd(Employee employeeOne, Employee employeeTwo) {
    ComparatorOfEmployees comparator = new ComparatorOfEmployees();

    while (productivity >= employeeOne.getProductivity()) {
      team.add(comparator.compare(employeeOne, employeeTwo, productivity));
      productivity -= comparator.compare(employeeOne, employeeTwo, productivity).getProductivity();
    }
  }
}
