/**
 * A class representing a. oval.
 */
public class Circle extends AbstractShape{
  private int width;
  private int height;
  private AvailableShapes type;

  /**
   * Construct a circle object using the given center and radius
   * @param x x coordinate of the center of this circle
   * @param y y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(int x, int y, int radius) {
    super(new Point2D(x,y));
    if (radius < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    this.width = radius;
    this.height = radius;
    super.setR(0);
    super.setG(0);
    super.setB(0);
    super.setOpacity(1);
    this.type = AvailableShapes.OVAL;
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
   * @param a the opacity value
   */
  public Circle(int x, int y, int width, int height, int r, int g, int b, int a) {
    super(new Point2D(x,y));
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    this.width = width;
    this.height = height;
    super.setR(r);
    super.setG(g);
    super.setB(b);
    super.setOpacity(a);
    this.type = AvailableShapes.OVAL;
  }

  /**
   * Constructs an oval given the center and the width and height of the oval.
   * @param x the x coordinate of the center of the oval.
   * @param y the y coordinate of the center of the oval.
   * @param width the full width of the oval.
   * @param height the full height of the oval.
   */
  public Circle(int x, int y, int width, int height) {
    super(new Point2D(x,y));
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    this.width = width;
    this.height = height;
    super.setR(0);
    super.setG(0);
    super.setB(0);
    super.setOpacity(1);
    this.type = AvailableShapes.OVAL;
  }

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param radius the radius of the circle
   * @param r the r color value.
   * @param g the g color value.
   * @param b the b color value.
   * @param a the opacity value
   */
  public Circle(int x, int y, int radius, int r, int g, int b, int a) {
    super(new Point2D(x,y));
    if (radius < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    this.width = radius;
    this.height = radius;
    super.setR(r);
    super.setG(g);
    super.setB(b);
    super.setOpacity(a);
    this.type = AvailableShapes.OVAL;
  }

  @Override
  public AvailableShapes getType() {
    return this.type;
  }

  public String toString() {
    return String.format("Circle-> center: (%d, %d) x-dimension: %d, y-dimension: %d",
            this.reference.getX(),this.reference.getY(),this.width, this.height);
  }
}

