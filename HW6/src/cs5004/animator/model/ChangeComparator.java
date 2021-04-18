package cs5004.animator.model;

import java.util.Comparator;

public class ChangeComparator implements Comparator<AbstractChange> {

  public int compare(AbstractChange a, AbstractChange b) {
    if (a.getStartTime() > b.getStartTime()) {
      return 1;
    } else if (a.getStartTime() == b.getStartTime()) {
      return a.toString().compareTo(b.toString());
    } else {
      return -1;
    }
  }
}
