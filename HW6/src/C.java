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

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   * @param radius the radius of this circle
   */
  public C(double radius) {
    super(new Point2D(0,0));
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public BasicShape resize(double factor) {
    return new C(reference.getX(), reference.getY(), Math.sqrt(factor) *
            radius);
  }

  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f",
            this.reference.getX(),this.reference.getY(),this.radius);
  }
}

