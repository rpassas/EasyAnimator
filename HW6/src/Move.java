public class Move extends AbstractChange {

  public Move(BasicShape shape, int shapeID, String shapeLabel,
              int x, int y, int startTime, int endTime) {
    super.reference = shape.getLocation();
    super.reference.setX(x);
    super.reference.setY(y);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
  }

  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its position to x-dimension: "
        + super.reference.getX() + ", y-dimension: " + super.reference.getY()
        + " from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}
