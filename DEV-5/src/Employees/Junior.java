package Employees;

/**
 * Junior
 */
public class Junior extends Employee {

  private int productivity = 1000;
  private int salary = 1000;
  private int junCounter = 0;

  @Override
  public int getProductivity() {
    return productivity;
  }

  @Override
  public int getSalary() {
    return salary;
  }
}
