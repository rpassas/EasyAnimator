package cs5004.animator.model;

import java.util.Comparator;

public class ChangeComparator implements Comparator<AbstractChange> {

  public int compare(AbstractChange a, AbstractChange b) {
    if (a.getStartTime() > b.getStartTime()) {
      return 1;
    }
    if (a.getStartTime() == b.getStartTime()) {
      return a.getShapeLabel().compareTo(b.getShapeLabel());
    }
    return -1;
  }
}
