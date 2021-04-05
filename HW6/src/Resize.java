public class Resize extends AbstractChange {

  public Resize(BasicShape shape, int shapeID, int width, int height, int startTime, int endTime) {
    shape.setWidth(width);
    shape.setHeight(height);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
  }
}
