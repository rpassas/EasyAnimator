package cs5004.AnimationModel;

public class Move extends AbstractChange {

  public Move(BasicShape shape, int shapeID, String shapeLabel,
              int x, int y, int startTime, int endTime) {
    Point2D location = new Point2D(shape.getLocation().getX(), shape.getLocation().getY());
    super.reference = location;
    super.reference.setX(x);
    super.reference.setY(y);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.MOVE);
    // set defaults
    super.setUpdatedR(shape.getR());
    super.setUpdatedG(shape.getG());
    super.setUpdatedB(shape.getB());
    super.setUpdatedA(shape.getOpacity());
    super.setUpdatedHeight(shape.getHeight());
    super.setUpdatedWidth(shape.getWidth());
  }


  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its position to x-dimension: "
        + super.reference.getX() + ", y-dimension: " + super.reference.getY()
        + " from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}
