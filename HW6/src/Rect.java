/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */

public class Rect extends AbstractShape {
  private int width;
  private int height;
  private AvailableShapes type;

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public Rect(int x, int y, int width, int height) {
    super(new Point2D(x, y));
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    this.width = width;
    this.height = height;
    super.setR(0);
    super.setG(0);
    super.setB(0);
    super.setOpacity(1);
    this.type = AvailableShapes.RECTANGLE;
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
  public Rect(int x, int y, int width, int height, int r, int g, int b, int a) {
    super(new Point2D(x, y));
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    this.width = width;
    this.height = height;
    super.setR(r);
    super.setG(g);
    super.setB(b);
    super.setOpacity(a);
    this.type = AvailableShapes.RECTANGLE;
  }

  @Override
  public AvailableShapes getType() {
    return this.type;
  }

  public String toString() {
    return String.format("Rectangle: LL corner (%d, %d) width %d height " +
                    "%d",
            this.reference.getX(), this.reference.getY(), this.width, this
                    .height);
  }
}

