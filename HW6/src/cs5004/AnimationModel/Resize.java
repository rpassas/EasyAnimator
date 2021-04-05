package cs5004.AnimationModel;

public class Resize extends AbstractChange {
  private int startHeight;
  private int startWidth;
  private int updatedHeight;
  private int updatedWidth;

  public Resize(BasicShape shape, int shapeID, String shapeLabel,
                int startW, int startH, int endW, int endH, int startTime, int endTime) {
    this.setStartHeight(startH);
    this.setStartWidth(startW);
    this.setUpdatedHeight(endH);
    this.setUpdatedWidth(endW);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.RESIZE);

  }

  @Override
  public int getStartHeight() {
    return this.startHeight;
  }

  @Override
  public void setStartHeight(int startHeight) {
    this.startHeight = startHeight;
  }

  @Override
  public int getStartWidth() {
    return this.startWidth;
  }

  @Override
  public void setStartWidth(int startWidth) {
    this.startHeight = startWidth;
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
    throw new IllegalStateException("Move cannot get position values");
  }

  @Override
  public void setStartReference(Point2D startReference) {
    throw new IllegalStateException("Move cannot set position values");
  }

  @Override
  public int getUpdatedHeight() {
    return this.updatedHeight;
  }

  @Override
  public void setUpdatedHeight(int updatedHeight) {
    this.updatedHeight = updatedHeight;
  }

  @Override
  public int getUpdatedWidth() {
   return this.updatedWidth;
  }

  @Override
  public void setUpdatedWidth(int updatedWidth) {
    this.updatedWidth = updatedWidth;
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
    throw new IllegalStateException("Move cannot get position values");
  }

  @Override
  public void setReference(Point2D reference) {
    throw new IllegalStateException("Move cannot set position values");
  }


  @Override
  public String toString() {
    return "Shape " + super.getShapeLabel() + " updates its dimensions from width: "
        + this.getStartWidth() + " height: " + this.getStartHeight()
        + " to width: "
        + this.getUpdatedWidth() + " height: " + this.getUpdatedHeight()
        + " from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}