/**
 * Implementation of the IShape interface.
 */
public class IShapeImpl implements IShape {
  @Override
  public IShape create(int x, int y, int h, int w) {
    return null;
  }

  @Override
  public void remove(IShape shape) {

  }

  @Override
  public void move(IShape shape, int x1, int y1, int x2, int y2, int t1, int t2) {

  }

  @Override
  public void flash(IShape shape, int t1, int t2) {

  }

  @Override
  public void shader(IShape shape, int r, int g, int b, int t1, int t2) {

  }

  @Override
  public IShape resize(IShape shape, int h, int w, int t1, int t2) {
    return null;
  }

  @Override
  public IShape getShapesAtTick(int tick) {
    return null;
  }

  @Override
  public double distanceFromOrigin() {
    return 0;
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
  public IShape resize(double factor) {
    return null;
  }
}
