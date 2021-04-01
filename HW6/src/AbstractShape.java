public class AbstractShape implements BasicShape{
  protected Point2D reference;
  private double height;
  private double width;
  private int r;
  private int g;
  private int b;
  private int opacity;

  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  @Override
  public double getHeight() {
    return height;
  }

  @Override
  public double getWidth() {
    return width;
  }

  @Override
  public int getR() {
    return r;
  }

  @Override
  public int getG() {
    return g;
  }

  @Override
  public int getB() {
    return b;
  }

  @Override
  public int getOpacity() {
    return opacity;
  }

  @Override
  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public void setWidth(double width) {
    this.width = width;
  }

  @Override
  public void setR(int r) {
    this.r = r;
  }

  @Override
  public void setG(int g) {
    this.g = g;
  }

  @Override
  public void setB(int b) {
    this.b = b;
  }

  @Override
  public void setOpacity(int opacity) {
    this.opacity = opacity;
  }
}
