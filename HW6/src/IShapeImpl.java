import java.util.LinkedList;

/**
 * Implementation of the IShape interface.
 */
public class IShapeImpl implements IShape {
  private LinkedList<AbstractShape> listOfShapes;

  public IShapeImpl() {
    this.listOfShapes = new LinkedList<AbstractShape>();
  }

  @Override
  public void addShape(AvailableShapes shape, int x, int y, int w, int h) {
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new C(x, y, w, h));
    }
    if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new R(x, y, w, h));
    }
  }

  public void addShape(AvailableShapes shape, int x, int y, int w, int h, int r, int g, int b, int opacity) {
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new C(x, y, w, h, r, g, b, opacity));
    }
    if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new R(x, y, w, h, r, g, b, opacity));
    }
  }

  @Override
  public void remove(IShape shape) {

  }

  @Override
  public void move(IShape shape, int x, int y, int t1, int t2) {

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
}
