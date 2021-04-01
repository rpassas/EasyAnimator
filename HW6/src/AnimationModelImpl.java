import java.util.LinkedList;

/**
 * Implementation of the IShape interface.
 */
public class AnimationModelImpl implements AnimationModel {
  private LinkedList<AbstractShape> listOfShapes;
  //TODO private AbstractShape shape;

  //TODO add param of shape
  public AnimationModelImpl() {
    //TODO instead of add shape we can just have the constructor take
    // an existing shape (we have a create method for shapes)
    this.listOfShapes = new LinkedList<AbstractShape>();
  }


  @Override
  public void addShape(AvailableShapes shape, int x, int y, int width, int height) {
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new Circle(x, y, width, height));
    }
    if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(x, y, width, height));
    }
  }

  public void addShape(AvailableShapes shape, int x, int y, int w, int h, int r, int g, int b, int opacity) {
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new Circle(x, y, w, h, r, g, b, opacity));
    }
    if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(x, y, w, h, r, g, b, opacity));
    }
  }

  @Override
  public void remove(AnimationModel shape) {

  }

  @Override
  public void move(AnimationModel shape, int x, int y, int t1, int t2) {

  }

  @Override
  public void flash(AnimationModel shape, int t1, int t2) {

  }

  @Override
  public void shader(AnimationModel shape, int r, int g, int b, int t1, int t2) {

  }

  @Override
  public AnimationModel resize(AnimationModel shape, int h, int w, int t1, int t2) {
    return null;
  }

  @Override
  public AnimationModel getShapesAtTick(int tick) {
    return null;
  }
}
