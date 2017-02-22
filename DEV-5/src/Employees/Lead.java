package Employees;

/**
 * Lead
 */
public class Lead extends Employee {

  private int productivity = 2000;
  private int salary = 1500;
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
