public class Recolor extends AbstractChange {

  public Recolor(BasicShape shape, int shapeID, String shapeLabel,
                 int r, int g, int b, int startTime, int endTime) {
    super.setUpdatedR(r);
    super.setUpdatedG(g);
    super.setUpdatedB(b);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.RECOLOR);
  }

  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its color to (" + super.getUpdatedR() + ", "
        + super.getUpdatedG() + ", " + super.getUpdatedB() + ") from t= " + super.getStartTime()
        + " to t= " + super.getEndTime() + "\n";
  }
}
