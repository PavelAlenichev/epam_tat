import Employees.Employee;

/**
 * Uses to know which of 2 employees more effective
 */
public class ComparatorOfEmployees {

  /**
   * uses to compare two Employees successors of Employee
   *
   * @param firstEmployee
   * @param secondEmployee
   * @param productivity
   * @return the most effective employee
   */
  public Employee compare(Employee firstEmployee, Employee secondEmployee, int productivity) {

    if (productivity > firstEmployee.getProductivity()) {
      return secondEmployee;
    } else
      return firstEmployee;
  }


}