package cs5004.AnimationModel;

public class Recolor extends AbstractChange {
  private int startR;
  private int startG;
  private int startB;
  private int startA;
  private int updatedR;
  private int updatedG;
  private int updatedB;
  private int updatedA;

  public Recolor(AbstractShape shape, int shapeID, String shapeLabel,
                 int startR, int startG, int startB, int startA,
                 int endR, int endG, int endB, int endA,
                 int startTime, int endTime) {
    this.setStartR(startR);
    this.setStartG(startG);
    this.setStartB(startB);
    this.setStartA(startA);
    this.setUpdatedR(endR);
    this.setUpdatedG(endG);
    this.setUpdatedB(endB);
    this.setUpdatedA(endA);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeID(shapeID);
    super.setShapeLabel(shapeLabel);
    super.setType(AvailableChanges.RECOLOR);
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
    return startR;
  }

  @Override
  public void setStartR(int startR) {
    this.startR = startR;
  }

  @Override
  public int getStartG() {
    return startG;
  }

  @Override
  public void setStartG(int startG) {
    this.startG = startG;
  }

  @Override
  public int getStartB() {
    return startB;
  }

  @Override
  public void setStartB(int startB) {
    this.startB = startB;
  }

  @Override
  public int getStartA() {
    return startA;
  }

  @Override
  public void setStartA(int startA) {
    this.startA = startA;
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
    return updatedR;
  }

  @Override
  public void setUpdatedR(int updatedR) {
    this.updatedR = updatedR;
  }

  @Override
  public int getUpdatedG() {
    return updatedG;
  }

  @Override
  public void setUpdatedG(int updatedG) {
    this.updatedG = updatedG;
  }

  @Override
  public int getUpdatedB() {
    return updatedB;
  }

  @Override
  public void setUpdatedB(int updatedB) {
    this.updatedB = updatedB;
  }

  @Override
  public int getUpdatedA() {
    return updatedA;
  }

  @Override
  public void setUpdatedA(int updatedA) {
    this.updatedA = updatedA;
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
    return "Shape " + super.getShapeLabel()
        + " updates its color from (" + this.getStartR() + ", "
        + this.getStartG() + ", " + this.getStartB() + ", " + this.getStartA()
        + ") to (" + this.getUpdatedR() + ", "
        + this.getUpdatedG() + ", " + this.getUpdatedB() + ", " + this.getUpdatedA()
        + ") from t= " + super.getStartTime() + " to t= " + super.getEndTime() + "\n";
  }
}
