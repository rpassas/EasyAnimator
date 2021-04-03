public class Move extends AbstractChange {

  public Move(BasicShape shape, int x, int y, int startTime, int endTime) {
    super.reference.setX(x);
    super.reference.setY(y);
    super.setStartTime(startTime);
    super.setEndTime(endTime);
  }
}
