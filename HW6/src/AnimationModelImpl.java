import java.util.LinkedList;

// Test github -jordan

/**
 * Implementation of the IShape interface.
 */
public class AnimationModelImpl implements AnimationModel {
  private LinkedList<AbstractShape> listOfShapes;

  public AnimationModelImpl() {
    this.listOfShapes = new LinkedList<AbstractShape>();
  }

  //TODO if we overload addshape do we also override?

  @Override
  public void addShape(AbstractShape shape) {
    if (shape.getType() == AvailableShapes.OVAL) {
      listOfShapes.add(shape);
    }
    if (shape.getType() == AvailableShapes.RECTANGLE) {
      listOfShapes.add(shape);
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  public void addShape(AvailableShapes shape, int x, int y, int w, int h) {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new Circle(x, y, w, h));
    }
    if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(x, y, w, h));
    }
  }

  public void addShape(AvailableShapes shape, int x, int y, int w, int h,
                       int r, int g, int b, int opacity) {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new Circle(x, y, w, h, r, g, b, opacity));
    }
    if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(x, y, w, h, r, g, b, opacity));
    }
  }

  @Override
  public void remove(AbstractShape shape) {

  }

  // TODO these will rely on get shapes at tick
  @Override
  public void translate(AbstractShape shape, int x, int y, int t1, int t2) {

  }

  @Override
  public void rotate(AbstractShape shape, double angle, int t1, int t2) {

  }

  @Override
  public void flash(AbstractShape shape, int t1, int t2) {

  }

  @Override
  public void shader(AbstractShape shape, int r, int g, int b, int t1, int t2) {

  }

  @Override
  public AnimationModel resize(AbstractShape shape, int h, int w, int t1, int t2) {
    return null;
  }

  //TODO does not have to be implemented until next time for controller

  @Override
  public AnimationModel getShapesAtTick(int tick) {
    return null;
  }
}
