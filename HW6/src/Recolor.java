public class Recolor extends AbstractChange {

  public Recolor(BasicShape shape, int shapeID, int r, int g, int b, int startTime, int endTime) {
    super.setUpdatedR(r);
    super.setUpdatedG(g);
    super.setUpdatedB(b);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
  }
}
