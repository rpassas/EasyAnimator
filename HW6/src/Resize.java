public class Resize extends AbstractChange {

  public Resize(BasicShape shape, int shapeID, String shapeLabel,
                int width, int height, int startTime, int endTime) {
    super.setUpdatedHeight(height);
    super.setUpdatedWidth(width);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.RESIZE);
    // set defaults
    super.setUpdatedR(shape.getR());
    super.setUpdatedG(shape.getG());
    super.setUpdatedB(shape.getB());
    super.setUpdatedA(shape.getOpacity());
    Point2D location = new Point2D(shape.getLocation().getX(), shape.getLocation().getY());
    super.reference = location;
  }


  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its dimensions to width: "
        + this.getUpdatedWidth() + " height: " + this.getUpdatedHeight()
        + " from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}
