package Employees;

/**
 * Lead
 */
public class Lead extends Employee {

  private int productivity = 10000;
  private int salary = 4000;
  private int lidCounter = 0;

  @Override
  public int getProductivity() {
    return productivity;
  }

  @Override
  public int getSalary() {
    return salary;
  }
}
