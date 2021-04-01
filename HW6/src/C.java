/**
 * A class representing a. oval.
 */
public class C extends AbstractShape{
  private double radius;
  private double width;
  private double height;

  /**
   * Construct a circle object using the given center and radius
   * @param x x coordinate of the center of this circle
   * @param y y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public C(double x, double y, double radius) {
    super(new Point2D(x,y));
    this.radius = radius;
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
  public C(double x, double y, double width, double height, double r, double g, double b, double opacity) {
    super(new Point2D(x,y));
    this.width = width;
    this.height = height;
    super.setR(0);
    super.setG(0);
    super.setB(0);
    super.setOpacity(0);
  }

  /**
   * Constructs an oval given the center and the width and height of the oval.
   * @param x the x coordinate of the center of the oval.
   * @param y the y coordinate of the center of the oval.
   * @param width the full width of the oval.
   * @param height the full height of the oval.
   */
  public C(double x, double y, double width, double height) {
    super(new Point2D(x,y));
    this.width = width;
    this.height = height;
  }

  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f",
            this.reference.getX(),this.reference.getY(),this.radius);
  }
}

