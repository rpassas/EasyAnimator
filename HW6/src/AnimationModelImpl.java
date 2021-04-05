import java.util.LinkedList;

/**
 * Implementation of the IShape interface.
 */
public class AnimationModelImpl implements AnimationModel {
  private final LinkedList<AbstractShape> listOfShapes;
  private final LinkedList<AbstractChange> listOfChanges;
  private final LinkedList<Integer> listOfKeys;
  int ShapeKey;

  public AnimationModelImpl() {
    this.listOfShapes = new LinkedList<>();
    this.listOfKeys = new LinkedList<>();
    this.listOfChanges = new LinkedList<>();
  }

  @Override
  public LinkedList<AbstractShape> getShapes() {
    return this.listOfShapes;
  }

  @Override
  public LinkedList<AbstractChange> getChanges() {
    return this.listOfChanges;
  }

  @Override
  public void addShape(AbstractShape shape) {
    // make sure labels are unique
    for (AbstractShape aShape : this.listOfShapes) {
      if (aShape.getLabel().equals(shape.getLabel())) {
        shape.setLabel(shape.getLabel() + "+");
      }
    }
    if (shape.getType().equals(AvailableShapes.OVAL)) {
      listOfShapes.add(shape);
      listOfKeys.add(ShapeKey);
      ShapeKey++;
    } else if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
      listOfShapes.add(shape);
      listOfKeys.add(ShapeKey);
      ShapeKey++;
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  /**
   * Overload of addShape that adds a shape to the model using parameters needed to construct
   * a shape.
   * @param shape enum shape type
   * @param label a label for the shape
   * @param x x position of the shape
   * @param y y position of the shape
   * @param w width of the shape
   * @param h height of the shape
   * @throws IllegalArgumentException if dimensions are not positive
   * @throws IllegalArgumentException for non-unique label
   * @throws IllegalArgumentException if shape is not a circle or rectangle type
   */
  public void addShape(AvailableShapes shape, String label, int x, int y, int w, int h) {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    for (AbstractShape aShape : this.listOfShapes) {
      if (aShape.getLabel().equals(label)) {
        throw new IllegalArgumentException("Labels must be unique to shapes");
      }
    }
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new Circle(label, x, y, w, h));
      listOfKeys.add(ShapeKey);
      ShapeKey++;
    } else if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(label, x, y, w, h));
      listOfKeys.add(ShapeKey);
      ShapeKey++;
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  /**
   * Overload of addShape that adds a shape to the model using parameters needed to construct
   * a shape.
   * @param shape enum shape type
   * @param label a label for the shape
   * @param x x position of the shape
   * @param y y position of the shape
   * @param w width of the shape
   * @param h height of the shape
   * @param r red fill value
   * @param g green fill value
   * @param b blue fill value
   * @param opacity fill opacity value
   * @throws IllegalArgumentException for non-positive dimensions
   * @throws IllegalArgumentException for negative color values
   * @throws IllegalArgumentException for color values outside of normal range
   * @throws IllegalArgumentException for non-unique label
   * @throws IllegalArgumentException for invalid shape type
   */
  public void addShape(AvailableShapes shape, String label, int x, int y, int w, int h,
                       int r, int g, int b, int opacity) {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (r < 0 || g < 0 || b < 0 || opacity < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }
    if (r > 255 || g > 255 || b > 255 || opacity > 100) {
      throw new IllegalArgumentException("Color values must be below 255 for " +
              "rgb and 100 for opacity");
    }
    for (AbstractShape aShape : this.listOfShapes) {
      if (aShape.getLabel().equals(label)) {
        throw new IllegalArgumentException("Labels must be unique to shapes");
      }
    }
    if (shape == AvailableShapes.OVAL) {
      listOfShapes.add(new Circle(label, x, y, w, h, r, g, b, opacity));
      listOfKeys.add(ShapeKey);
      ShapeKey++;
    } else if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(label, x, y, w, h, r, g, b, opacity));
      listOfKeys.add(ShapeKey);
      ShapeKey++;
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  @Override
  public void removeShape(AbstractShape shape) {
    if(listOfShapes.contains(shape)) {
      listOfKeys.remove(listOfShapes.indexOf(shape));
      listOfShapes.remove(shape);
    } else {
      throw new IllegalArgumentException("That shape is not in the list");
    }
  }

  /**
   * Overload method for removeShape that takes the indentifier for a shape rather than the shape
   * itself to find and remove it from the model.
   * @param shapeIdentifier index of the shape in the list of shapes
   */
  public void removeShape(int shapeIdentifier) {
    if (listOfKeys.contains(shapeIdentifier)) {
      listOfShapes.remove(listOfKeys.indexOf(shapeIdentifier));
      listOfKeys.remove(listOfKeys.indexOf(shapeIdentifier));
    } else {
     throw new IllegalArgumentException("That identifier is empty.");
    }
  }

  /**
   * Overload of removeShape method that uses the unique label of a shape rather than the shape
   * itself to find and remove it from the model.
   * @param label unique string label for a shape
   */
  public void removeShape(String label) {
    for (AbstractShape aShape : this.listOfShapes) {
      if (aShape.getLabel().equals(label)) {
        listOfShapes.remove(aShape);
        listOfKeys.remove(listOfShapes.indexOf(aShape));
        return;
      }
    }
      throw new IllegalArgumentException("Given label does not exist.");
  }

  /**
   * Helper method to check that time stamps do not overlap on conflicting
   * changes on the same shape.
   * @param shape shape being checked
   * @param type of change being checked for
   * @param t1 start time for change
   * @param t2 end time for change
   * @return boolean indicating overlap in conflicting changes
   */
  private boolean timeOverlap(AbstractShape shape, AvailableChanges type, int t1, int t2) {
    for (Change c : this.listOfChanges) {
      //two changes of the same type cannot occur at once
      if (type == c.getType()
          // same shape?
          && c.getShapeID() == listOfKeys.get(listOfShapes.indexOf(shape))
          //overlapping time at the front of existing change
          && ((c.getStartTime() <= t1 && c.getEndTime() > t1)
          // Overlapping time at the end of existing change
          || (c.getStartTime() < t2 && c.getEndTime() >= t2)
          //new change inside old change time
          || (c.getStartTime() <= t1 && c.getEndTime() >= t2)
          // old change inside new change's time
          || (c.getStartTime() >= t1 && c.getEndTime() <= t2))) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void addMove(AbstractShape shape, int x, int y, int t1, int t2) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("x & y coordinates must be positive");
    }
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (timeOverlap(shape, AvailableChanges.MOVE, t1, t2)) {
      throw new IllegalArgumentException("Only one move change can be made at a time");
    }
    if (t1 > t2) {
      throw new IllegalArgumentException("Start time > end time");
    }
    if (!listOfShapes.contains(shape)) {
      this.addShape(shape);
    }
    listOfChanges.add(new Move(shape, listOfShapes.indexOf(shape), shape.getLabel(), x, y, t1, t2));
  }

  @Override
  public void addRecolor(AbstractShape shape, int r, int g, int b, int a, int t1, int t2) {
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }
    if (r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("Color values must be below 255");
    }
    if (timeOverlap(shape, AvailableChanges.RECOLOR, t1, t2)) {
      throw new IllegalArgumentException("Only one recolor change can be made at a time");
    }
    if (t1 > t2) {
      throw new IllegalArgumentException("Start time > end time");
    }
    if (a < 0 || a > 100) {
      throw new IllegalArgumentException("Opacity must be between 0 and 100");
    }
    if (!listOfShapes.contains(shape)) {
      this.addShape(shape);
    }
    listOfChanges.add(new Recolor(shape, listOfShapes.indexOf(shape), shape.getLabel(),
        r, g, b, a, t1, t2));
  }

  @Override
  public void addResize(AbstractShape shape, int w, int h, int t1, int t2) {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (timeOverlap(shape, AvailableChanges.RESIZE, t1, t2)) {
      throw new IllegalArgumentException("Only one resize change can be made at a time");
    }
    if (t1 > t2) {
      throw new IllegalArgumentException("Start time > end time");
    }
    if (!listOfShapes.contains(shape)) {
      this.addShape(shape);
    }
    listOfChanges.add(new Resize(shape, listOfShapes.indexOf(shape), shape.getLabel(),
        w, h, t1, t2));
  }

  //TODO does not have to be implemented until next time for controller

  @Override
  public AnimationModel getShapesAtTick(int CurrentTick) {
    if (CurrentTick < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    return null;
  }

  @Override
  public String toString() {
    String model = "";
    for (AbstractShape shape: this.listOfShapes) {
      model = model + shape.toString() + "\n";
    }
    for (AbstractChange change: this.listOfChanges) {
      model = model + change.toString();
    }
    return model;
  }
}
