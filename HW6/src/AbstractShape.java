public class AbstractShape implements BasicShape{
  protected Point2D reference;

  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

 @Override
  public double area() {
    return 0;
  }

  @Override
  public double perimeter() {
    return 0;
  }

  @Override
  public BasicShape resize(double factor) {
    return null;
  }
}
