public class Resize extends AbstractChange {

  public Resize(BasicShape shape, int width, int height) {
    super.setUpdatedWidth(width);
    super.setUpdatedHeight(height);
  }
}
