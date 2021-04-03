public class Resize extends AbstractChange {

  public Resize(BasicShape shape, int width, int height, int startTime, int endTime) {
    super.setUpdatedWidth(width);
    super.setUpdatedHeight(height);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
  }
}
