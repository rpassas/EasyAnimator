package cs5004.AnimationModel;

public class Move extends AbstractChange {
  protected Point2D startReference;
  protected Point2D reference;

  public Move(BasicShape shape, int shapeID, String shapeLabel,
              int startX, int startY, int endX, int endY, int startTime, int endTime) {
    Point2D location = new Point2D(shape.getLocation().getX(), shape.getLocation().getY());
    this.startReference = location;
    this.startReference.setX(startX);
    this.startReference.setY(startY);
    this.reference = location;
    this.reference.setX(endX);
    this.reference.setY(endY);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.MOVE);
  }

  @Override
  public int getStartHeight() {
    throw new IllegalStateException("Move does not have a height value");
  }

  @Override
  public void setStartHeight(int startHeight) {
    throw new IllegalStateException("Move cannot set height values");
  }

  @Override
  public int getStartWidth() {
    throw new IllegalStateException("Move cannot get width values");
  }

  @Override
  public void setStartWidth(int startWidth) {
    throw new IllegalStateException("Move cannot set width values");
  }

  @Override
  public int getStartR() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setStartR(int startR) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public int getStartG() {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public void setStartG(int startG) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public int getStartB() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setStartB(int startB) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public int getStartA() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setStartA(int startA) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public Point2D getStartReference() {
    return startReference;
  }

  @Override
  public void setStartReference(Point2D startReference) {
    this.startReference = startReference;
  }

  @Override
  public int getUpdatedHeight() {
    throw new IllegalStateException("Move cannot get height value");
  }

  @Override
  public void setUpdatedHeight(int updatedHeight) {
    throw new IllegalStateException("Move cannot set height value");
  }

  @Override
  public int getUpdatedWidth() {
    throw new IllegalStateException("Move cannot get width value");
  }

  @Override
  public void setUpdatedWidth(int updatedWidth) {
    throw new IllegalStateException("Move cannot set width value");
  }

  @Override
  public int getUpdatedR() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setUpdatedR(int updatedR) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public int getUpdatedG() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setUpdatedG(int updatedG) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public int getUpdatedB() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setUpdatedB(int updatedB) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public int getUpdatedA() {
    throw new IllegalStateException("Move cannot get color values");
  }

  @Override
  public void setUpdatedA(int updatedA) {
    throw new IllegalStateException("Move cannot set color values");
  }

  @Override
  public Point2D getReference() {
    return reference;
  }

  @Override
  public void setReference(Point2D reference) {
    this.reference = reference;
  }


  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its position from x-dimension: "
        + this.startReference.getX() + ", y-dimension: " + this.startReference.getY()
        +" to x-dimension: "
        + this.reference.getX() + ", y-dimension: " + this.reference.getY()
        + " from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}
