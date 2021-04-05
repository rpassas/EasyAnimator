package cs5004.AnimationModel;

public abstract class AbstractChange implements Change{
  private int startTime;
  private int endTime;
  private int shapeID;
  private String shapeLabel;
  private AvailableChanges type;

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


