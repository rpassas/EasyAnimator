public class Resize extends AbstractChange {

  public Resize(BasicShape shape, int shapeID, String shapeLabel,
                int width, int height, int startTime, int endTime) {
    shape.setWidth(width);
    shape.setHeight(height);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.RESIZE);
  }

  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its dimensions to width: "
        + super.getUpdatedWidth() + " height: " + super.getUpdatedHeight()
        + " from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}
