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
    super.setR(0);
    super.setG(0);
    super.setB(0);
    super.setOpacity(0);
  }

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   * @param r the r color value.
   * @param g the g color value.
   * @param b the b color value.
   * @param opacity the opacity value
   */
  public R(double x, double y, double width, double height, int r, int g, int b, int opacity) {
    super(new Point2D(x, y));
    this.width = width;
    this.height = height;
    super.setR(r);
    super.setG(g);
    super.setB(b);
    super.setOpacity(opacity);
  }

  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
                    "%.3f",
            this.reference.getX(), this.reference.getY(), this.width, this
                    .height);
  }
}

