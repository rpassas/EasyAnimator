import java.util.LinkedList;

/**
 * Implementation of the IShape interface.
 */
public class AnimationModelImpl implements AnimationModel {
  private LinkedList<AbstractShape> listOfShapes;

  public AnimationModelImpl() {
    this.listOfShapes = new LinkedList<AbstractShape>();
  }

  //TODO if we overload addshape do we also override?
  // I don't think so, it should be similar to adding a constructor, we can write tests to check though

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
    if (x < 0 || y > 0) {
      throw new IllegalArgumentException("Invalid X and Y coordinate");
    }
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (r < 0 || g < 0 || b < 0 || opacity < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }
    if (r > 255 || g > 255 || b > 255 || opacity > 100) {
      throw new IllegalArgumentException("Color values must be below 255 for " +
              "rgb and 100 for opacity");
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
    listOfShapes.remove(shape);
  }

  // TODO these will rely on get shapes at tick
  @Override
  public void translate(AbstractShape shape, int x, int y, int t1, int t2) {
    if (x < 0 || y > 0) {
      throw new IllegalArgumentException("Invalid X and Y coordinate");
    }
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    double moveProgress = (t2 - t1) / 100;
  }

  // I'm not sure we do this one, i can't think of a way to easily implement this.
  @Override
  public void rotate(AbstractShape shape, double angle, int t1, int t2) {
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
  }

  @Override
  public void flash(AbstractShape shape, int t1, int t2) {
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
  }

  @Override
  public void shader(AbstractShape shape, int r, int g, int b, int t1, int t2) {
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }
    if (r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("Color values must be below 255");
    }
  }

  @Override
  public AnimationModel resize(AbstractShape shape, int h, int w, int t1, int t2) {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }

    return null;
  }

  //TODO does not have to be implemented until next time for controller

  @Override
  public AnimationModel getShapesAtTick(int CurrentTick) {
    if (CurrentTick < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    return null;
  }
}
