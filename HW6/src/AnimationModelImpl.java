import java.util.LinkedList;

/**
 * Implementation of the IShape interface.
 */
public class AnimationModelImpl implements AnimationModel {
  private LinkedList<AbstractShape> listOfShapes;
  private LinkedList<AbstractChange> listOfChanges;
  private LinkedList<Integer> listOfIndexes;
  int shapeIndex;

  public AnimationModelImpl() {
    this.listOfShapes = new LinkedList<AbstractShape>();
    this.listOfIndexes = new LinkedList<>();
    this.listOfChanges = new LinkedList<AbstractChange>();
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
    if (shape.getType().equals(AvailableShapes.OVAL)) {
      listOfShapes.add(shape);
      listOfIndexes.add(shapeIndex);
      shapeIndex++;
    } else if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
      listOfShapes.add(shape);
      listOfIndexes.add(shapeIndex);
      shapeIndex++;
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
      listOfIndexes.add(shapeIndex);
      shapeIndex++;
    } else if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(x, y, w, h));
      listOfIndexes.add(shapeIndex);
      shapeIndex++;
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  public void addShape(AvailableShapes shape, int x, int y, int w, int h,
                       int r, int g, int b, int opacity) {
    if (x < 0 || y < 0) {
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
      listOfIndexes.add(shapeIndex);
      shapeIndex++;
    } else if (shape == AvailableShapes.RECTANGLE) {
      listOfShapes.add(new Rect(x, y, w, h, r, g, b, opacity));
      listOfIndexes.add(shapeIndex);
      shapeIndex++;
    } else {
      throw new IllegalArgumentException("added shape must be one of the accepted types");
    }
  }

  @Override
  public void removeShape(AbstractShape shape) {
    if(listOfShapes.contains(shape)) {
      listOfIndexes.remove(listOfShapes.indexOf(shape));
      listOfShapes.remove(shape);
    } else {
      throw new IllegalArgumentException("That shape is not in the list");
    }
    // We shouldn't decrement the shape index here, its a number that we don't want repeats of
    //shapeIndex--;
  }

  public void removeShape(int shapeIdentifier) {
    if (listOfIndexes.contains(shapeIdentifier)) {
      listOfShapes.remove(listOfIndexes.indexOf(shapeIdentifier));
      listOfIndexes.remove(listOfIndexes.indexOf(shapeIdentifier));
      //shapeIndex--;
    } else {
     throw new IllegalArgumentException("That identifier is empty");
    }
  }

  private boolean timeOverlap(AbstractShape shape, int t1, int t2) {
    for (Change c : this.listOfChanges) {
      //only one change can be made at a time
      if (c.getShapeID() == listOfIndexes.get(listOfShapes.indexOf(shape)) //overlapping time at the front
              && c.getStartTime() < t1 && c.getEndTime() > t1
              // Overlapping time at the end
              || c.getShapeID() == listOfIndexes.get(listOfShapes.indexOf(shape))
              && c.getStartTime() < t2 && c.getEndTime() > t2
              // old change inside new change's time
              || c.getShapeID() == listOfIndexes.get(listOfShapes.indexOf(shape))
              && c.getStartTime() < t1 && c.getEndTime() > t2
              //new change inside old change time
              || c.getShapeID() == listOfIndexes.get(listOfShapes.indexOf(shape))
              && c.getStartTime() > t1 && c.getEndTime() < t2) {
        return true;
      }
    }
    return false;
  }

  // TODO include checks for contradicting changes e.g. shape can't move left and right at once
  @Override
  public void addMove(AbstractShape shape, int x, int y, int t1, int t2) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Invalid X and Y coordinate");
    }
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (timeOverlap(shape, t1, t2)) {
      throw new IllegalArgumentException("Only one change can be made at a time");
    }
    if (listOfShapes.indexOf(shape) == -1) {
      this.addShape(shape);
    }
    listOfChanges.add(new Move(shape, listOfShapes.indexOf(shape), x, y, t1, t2));
  }

  @Override
  public void addRecolor(AbstractShape shape, int r, int g, int b, int t1, int t2) {
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }
    if (r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("Color values must be below 255");
    }
    if (timeOverlap(shape, t1, t2)) {
      throw new IllegalArgumentException("Only one change can be made at a time");
    }
    if (listOfShapes.indexOf(shape) == -1) {
      this.addShape(shape);
    }
    listOfChanges.add(new Recolor(shape, listOfShapes.indexOf(shape), r, g, b, t1, t2));
  }

  @Override
  public void addResize(AbstractShape shape, int w, int h, int t1, int t2) {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("dimensions must be positive.");
    }
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time value must be positive");
    }
    if (timeOverlap(shape, t1, t2)) {
      throw new IllegalArgumentException("Only one change can be made at a time");
    }
    if (listOfShapes.indexOf(shape) == -1) {
      this.addShape(shape);
    }
    listOfChanges.add(new Resize(shape, listOfShapes.indexOf(shape), w, h, t1, t2));
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
