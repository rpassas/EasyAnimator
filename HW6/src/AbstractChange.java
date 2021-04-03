public class AbstractChange implements Change{
  protected Point2D reference;
  private int updatedHeight;
  private int updatedWidth;
  private int updatedR;
  private int updatedG;
  private int updatedB;
  private int updatedA;

  public int getUpdatedHeight() {
    return updatedHeight;
  }

  public void setUpdatedHeight(int updatedHeight) {
    this.updatedHeight = updatedHeight;
  }

  public int getUpdatedWidth() {
    return updatedWidth;
  }

  public void setUpdatedWidth(int updatedWidth) {
    this.updatedWidth = updatedWidth;
  }

  public int getUpdatedR() {
    return updatedR;
  }

  public void setUpdatedR(int updatedR) {
    this.updatedR = updatedR;
  }

  public int getUpdatedG() {
    return updatedG;
  }

  public void setUpdatedG(int updatedG) {
    this.updatedG = updatedG;
  }

  public int getUpdatedB() {
    return updatedB;
  }

  public void setUpdatedB(int updatedB) {
    this.updatedB = updatedB;
  }

  public int getUpdatedA() {
    return updatedA;
  }

  public void setUpdatedA(int updatedA) {
    this.updatedA = updatedA;
  }

  public Point2D getReference() {
    return reference;
  }

  public void setReference(Point2D reference) {
    this.reference = reference;
  }
}
