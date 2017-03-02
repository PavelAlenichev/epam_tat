package Employees;

/**
 * Senior
 */
public class Senior extends Employee {

  private int productivity = 5000;
  private int salary = 2500;
  private int seniorCounter = 0;

  @Override
  public int getProductivity() {
    return productivity;
  }

  @Override
  public int getSalary() {
    return salary;
  }
}
