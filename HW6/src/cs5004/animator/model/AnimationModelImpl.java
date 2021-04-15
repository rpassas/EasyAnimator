package cs5004.animator.model;

import java.util.LinkedList;

import cs5004.animator.util.AnimationBuilder;

/**
 * Implementation of the IShape interface.
 */
public class AnimationModelImpl implements AnimationModel {
  private final LinkedList<AbstractShape> listOfShapes;
  private final LinkedList<AbstractChange> listOfChanges;
  private final LinkedList<Integer> listOfKeys;
  private final Canvas canvas;
  int shapeKey;

  /**
   * Constructor for the animation model impl.
   */
  public AnimationModelImpl() {
    this.listOfShapes = new LinkedList<>();
    this.listOfKeys = new LinkedList<>();
    this.listOfChanges = new LinkedList<>();
    this.canvas = new Canvas();
  }

  @Override
  public LinkedList<AbstractShape> getShapes() {
    return this.listOfShapes;
  }

  @Override
  public AbstractShape getShape(String name) {
    for (AbstractShape shape : this.listOfShapes) {
      if (shape.getLabel().equals(name)) {
        return shape;
      }
    }
    throw new IllegalArgumentException("no shape was found");
  }

  @Override
  public LinkedList<AbstractChange> getChanges() {
    return this.listOfChanges;
  }

  @Override
  public Canvas getCanvas() {
    return this.canvas;
  }

  @Override
  public void setCanvas(int x, int y, int width, int height) {
    this.canvas.setHeight(height);
    this.canvas.setWidth(width);
    this.canvas.setX(x);
    this.canvas.setY(y);
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
      listOfKeys.add(shapeKey);
      shapeKey++;
    } else if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
      listOfShapes.add(shape);
      listOfKeys.add(shapeKey);
      shapeKey++;
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
      listOfKeys.add(shapeKey);
      shapeKey++;
    } else if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(label, x, y, w, h, r, g, b, opacity));
      listOfKeys.add(shapeKey);
      shapeKey++;
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  @Override
  public void removeShape(AbstractShape shape) {
    if (listOfShapes.contains(shape)) {
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
  public void addMove(AbstractShape shape,
                      int startX, int startY, int endX, int endY, int t1, int t2) {
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
    listOfChanges.add(new Move(shape, listOfShapes.indexOf(shape), shape.getLabel(),
        startX, startY, endX, endY, t1, t2));
  }

  @Override
  public void addRecolor(AbstractShape shape,
                         int startR, int startG, int startB, int startA,
                         int endR, int endG, int endB, int endA, int t1, int t2) {
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (endR < 0 || endG < 0 || endB < 0 || startR < 0 || startG < 0 || startB < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }
    if (endR > 255 || endG > 255  || endB > 255
        || startR > 255  || startG > 255  || startB > 255 ) {
      throw new IllegalArgumentException("Color values must be below 255");
    }
    if (timeOverlap(shape, AvailableChanges.RECOLOR, t1, t2)) {
      throw new IllegalArgumentException("Only one recolor change can be made at a time");
    }
    if (t1 > t2) {
      throw new IllegalArgumentException("Start time > end time");
    }
    if (startA < 0 || startA > 100 || endA < 0 || endA > 100) {
      throw new IllegalArgumentException("Opacity must be between 0 and 100");
    }
    if (!listOfShapes.contains(shape)) {
      this.addShape(shape);
    }
    listOfChanges.add(new Recolor(shape, listOfShapes.indexOf(shape), shape.getLabel(),
        startR, startG, startB, startA, endR, endG, endB, endA, t1, t2));
  }

  @Override
  public void addResize(AbstractShape shape,
                        int startW, int startH, int endW, int endH, int t1, int t2) {
    if (startW <= 0 || startH <= 0 || endW <= 0 || endH <= 0) {
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
        startW, startH, endW, endH, t1, t2));
  }

  @Override
  public AnimationModelImpl getShapesAtTick(int currentTick) {
    if (currentTick < 0) {
      throw new IllegalArgumentException("Time value must be >= 0");
    }
    AnimationModelImpl modelCopy = new AnimationModelImpl();
    // For each change in the list, if the current tick is within the change add it to a list
    for (AbstractChange change : this.listOfChanges) {
      if (currentTick >= change.getStartTime() && currentTick <= change.getEndTime()) {
        // TweenOne is the first half of the tween formula
        int tweenOne = (change.getEndTime() - (currentTick) /
                (change.getEndTime() - change.getStartTime()));
        // TweenTwo is the second half of the tween formula
        int tweenTwo = (((currentTick) - change.getStartTime()) /
                (change.getEndTime() - change.getStartTime()));
        // add initial shape to modelCopy to have a starting point for iterators
        AbstractShape firstShape = this.getShape(change.getShapeLabel());
        AbstractShape firstCopy = firstShape.cloneShape();
        modelCopy.addShape(firstCopy);
        // for a MOVE change, if the change isn't in the list, add it, otherwise update the shape
        // this is done due to change commands being on the same time interval
        if(change.getType().equals(AvailableChanges.MOVE)) {
          // Checks each shape in the list for the current shape
          for (AbstractShape shape : modelCopy.getShapes()) {
            if (shape.getLabel().equals(change.getShapeLabel())) {
              //Shape is in the model, updating the XY at currentTick to account for a second change
              shape.getLocation().setX(change.getStartReference().getX() * tweenOne
                      + change.getReference().getX() * tweenTwo);
              shape.getLocation().setY(change.getStartReference().getY() * tweenOne
                      + change.getReference().getY() * tweenTwo);
            } else {
              //Shape is not in the model, adds shape to the model
              AbstractShape movedCopy = shape.cloneShape();
              // set the new coordinates
              int tweenX = change.getStartReference().getX() * tweenOne
                  + change.getReference().getX() * tweenTwo;
              int tweenY = change.getStartReference().getY() * tweenOne
                  + change.getReference().getY() * tweenTwo;
              Point2D newPoint = new Point2D(tweenX, tweenY);
              movedCopy.setLocation(newPoint);
              modelCopy.addShape(movedCopy);
            }
          }
        } else if (change.getType().equals(AvailableChanges.RECOLOR)) {
          // Checks each shape in the list for the current change shape
          for (AbstractShape shape : modelCopy.getShapes()) {
            // Shape is in the model at this point, updating the RGB values
            if (shape.getLabel().equals(change.getShapeLabel())) {
              shape.setR(change.getStartR() * tweenOne + change.getUpdatedR() * tweenTwo);
              shape.setG(change.getStartG() * tweenOne + change.getUpdatedG() * tweenTwo);
              shape.setB(change.getStartB() * tweenOne + change.getUpdatedB() * tweenTwo);
            } else {
              // Shape was not in the model, adding the shape with updated RGB values
              AbstractShape recoloredCopy = shape.cloneShape();
              // set new colors
              int tweenR = change.getStartR() * tweenOne + change.getUpdatedR() * tweenTwo;
              int tweenG = change.getStartG() * tweenOne + change.getUpdatedG() * tweenTwo;
              int tweenB = change.getStartB() * tweenOne + change.getUpdatedB() * tweenTwo;
              recoloredCopy.setR(tweenR);
              recoloredCopy.setG(tweenG);
              recoloredCopy.setB(tweenB);
              modelCopy.addShape(recoloredCopy);
            }
          }
        } else if (change.getType().equals(AvailableChanges.RESIZE)) {
          // Checks each shape in the list for the current change shape
          for (AbstractShape shape : modelCopy.getShapes()) {
            // Shape is in the model at this point, updating the width/height values
            if (shape.getLabel().equals(change.getShapeLabel())) {
              shape.setWidth(change.getStartWidth() * tweenOne + change.getUpdatedWidth() * tweenTwo);
              shape.setHeight(change.getStartHeight() * tweenOne + change.getUpdatedHeight() * tweenTwo);
            } else {
              // Shape was not in the model, adding the shape with updated width/height
              AbstractShape resizedCopy = shape.cloneShape();
              // set new dimensions
              int tweenW = change.getStartWidth() * tweenOne
                  + change.getUpdatedWidth() * tweenTwo;
              int tweenH = change.getStartHeight() * tweenOne
                  + change.getUpdatedHeight() * tweenTwo;
              resizedCopy.setWidth(tweenW);
              resizedCopy.setHeight(tweenH);
              modelCopy.addShape(resizedCopy);
            }
          }
        }
      }
    }

    return modelCopy;
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

  public static final class Builder implements AnimationBuilder<AnimationModel> {
    protected AnimationModel model;

    public Builder() {
      this.model = new AnimationModelImpl();
    }

    @Override
    public AnimationModel build() {
      return this.model;
    }

    @Override
    public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
      model.setCanvas(x, y, width, height);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
      if (type.equalsIgnoreCase("rectangle")){
        model.addShape(AvailableShapes.RECTANGLE, name,
            0, 0, 0, 0, 0, 0, 0, 0);
      } else if (type.equalsIgnoreCase("ellipse")) {
        model.addShape(AvailableShapes.OVAL, name,
            0, 0, 0, 0, 0, 0, 0, 0);
      } else {
        throw new IllegalArgumentException("Must be a rectangle or ellipse");
      }
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name,
                                      int t1, int x1, int y1, int w1, int h1,
                                                      int r1, int g1, int b1,
                                      int t2, int x2, int y2, int w2, int h2,
                                                      int r2, int g2, int b2)
    {
      if (x2 - x1 != 0 || y2 - y1 != 0) {
        model.addMove(model.getShape(name), x1, y1, x2, y2, t1, t2);
      } else if (w2 - w1 != 0 || h2 - h1 != 0) {
        model.addResize(model.getShape(name), w1,  h1, w2, h2, t1, t2);
      } else if (r2 - r1 != 0 || g2 - g1 != 0 || b2 - b1 != 0) {
        model.addRecolor(model.getShape(name),
            r1, g1, b1, 100, r2, g2, b2, 100, t1, t2);
      }
      return this;
    }
  }
}
