public abstract class AbstractChange implements Change{
  protected Point2D reference;
  private int updatedHeight;
  private int updatedWidth;
  private int updatedR;
  private int updatedG;
  private int updatedB;
  private int updatedA;
  private int startTime;
  private int endTime;
  private int shapeID;
  private String shapeLabel;
  private AvailableChanges type;

  @Override
  public int getUpdatedHeight() {
    return updatedHeight;
  }

  @Override
  public void setUpdatedHeight(int updatedHeight) {
    this.updatedHeight = updatedHeight;
  }

  @Override
  public int getUpdatedWidth() {
    return updatedWidth;
  }

  @Override
  public void setUpdatedWidth(int updatedWidth) {
    this.updatedWidth = updatedWidth;
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
    return reference;
  }

  @Override
  public void setReference(Point2D reference) {
    this.reference = reference;
  }

  @Override
  public int getStartTime() {
    return startTime;
  }

  @Override
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  @Override
  public int getEndTime() {
    return endTime;
  }

  @Override
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  @Override
  public int getShapeID() {
    return shapeID;
  }

  @Override
  public void setShapeID(int shapeID) {
    this.shapeID = shapeID;
  }

  @Override
  public void setShapeLabel(String shapeLabel) {
    this.shapeLabel = shapeLabel;
  }

  @Override
  public void setType(AvailableChanges type) {
    this.type = type;
  }

  @Override
  public AvailableChanges getType() {return this.type;}

  @Override
  public String getShapeLabel() {
    return this.shapeLabel;
  }

}


