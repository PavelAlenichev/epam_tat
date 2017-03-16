/**
 * Class matrix and methods to fill it and receive parameters
 */
public class Matrix {

  private double[][] matrix;
  private int x_param;
  private int y_param;

  /**
   * to define matrix dimension x on y
   */
  public Matrix(int x, int y) {
    this.matrix = new double[x][y];
    this.x_param = x;
    this.y_param = y;
  }

  /**
   * uses to add number at [x,y] coordinate
   */
  public void addToMatrix(int x, int y, double number) {
    this.matrix[x][y] = number;
  }

  /**
   * return [x,y] element of matrix
   */
  public double getElement(int x, int y) {
    return matrix[x][y];
  }

  public int getX_param() {
    return x_param;
  }

  public int getY_param() {
    return y_param;
  }
}