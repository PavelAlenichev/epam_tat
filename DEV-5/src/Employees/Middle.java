package Employees;

/**
 * Middle
 */
public class Middle extends Employee {

  private int productivity = 2000;
  private int salary = 1500;
  private int midCounter = 0;

  @Override
  public int getProductivity() {
    return productivity;
  }

  @Override
  public int getSalary() {
    return salary;
  }
}
