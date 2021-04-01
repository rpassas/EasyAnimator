/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */

public class R extends AbstractShape {
  private double width;
  private double height;



  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public R(double x, double y, double width, double height) {
    super(new Point2D(x, y));
    this.width = width;
    this.height = height;
  }

  /**
   * Method to set a new width of the rectangle.
   * @param width the value of the new width.
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Method to set a new height of the rectangle.
   * @param height the value of the new height.
   */
  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public double area() {
    return this.width * this.height;
  }

  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  @Override
  public BasicShape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    return new R(
            this.reference.getX(),
            this.reference.getY(), sqrtFactor *
            this.width,
            sqrtFactor * this.height);
  }

  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
                    "%.3f",
            this.reference.getX(), this.reference.getY(), this.width, this
                    .height);
  }
}

