package cs5004.AnimationModel;

public class Recolor extends AbstractChange {

  public Recolor(AbstractShape shape, int shapeID, String shapeLabel,
                 int r, int g, int b, int a, int startTime, int endTime) {
    super.setUpdatedR(r);
    super.setUpdatedG(g);
    super.setUpdatedB(b);
    super.setUpdatedA(a);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.RECOLOR);
    // set defaults
    Point2D location = new Point2D(shape.getLocation().getX(), shape.getLocation().getY());
    super.reference = location;
    super.setUpdatedHeight(shape.getHeight());
    super.setUpdatedWidth(shape.getWidth());
  }


  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its color to (" + this.getUpdatedR() + ", "
        + this.getUpdatedG() + ", " + this.getUpdatedB() + ") from t= " + super.getStartTime()
        + " to t= " + super.getEndTime() + "\n";
  }
}
