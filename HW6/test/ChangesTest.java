import org.junit.Before;
import org.junit.Test;

import cs5004.AnimationModel.AbstractChange;
import cs5004.AnimationModel.AnimationModelImpl;
import cs5004.AnimationModel.Change;
import cs5004.AnimationModel.Circle;
import cs5004.AnimationModel.Move;
import cs5004.AnimationModel.Recolor;
import cs5004.AnimationModel.Rect;
import cs5004.AnimationModel.Resize;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ChangesTest {
  private Rect rectangle1;
  private Circle circle1;
  private Move move1;
  private Recolor recolor1;
  private Resize resize1;

  @Before
  public void setup() {
    rectangle1 = new Rect("R1", 3, 6, 4, 7);
    circle1 = new Circle("c1", 1, 2, 3);
    move1 = new Move(rectangle1, 1, "R1",
        3, 4,5,6,7,8);
    recolor1 = new Recolor(circle1, 1, "C1",
        3, 4, 5, 6, 7, 8, 9,10,
        11, 12);
    resize1 = new Resize(rectangle1, 1, "R1", 3, 4,5,6,
        7,8);
  }

  @Test
  public void testMoveInvalid() {
    // set/get colors
    try {
      move1.getStartB();
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalStateException iae) {
      assertEquals("Move cannot get color values", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // set/get dimensions
    try {
      move1.getStartHeight();
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalStateException iae) {
      assertEquals("Move does not have a height value", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testRecolorInvalid() {
// set/get location
    try {
      recolor1.getStartReference();
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalStateException iae) {
      assertEquals("Recolor cannot get position values", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // set/get dimensions
    try {
      recolor1.getStartHeight();
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalStateException iae) {
      assertEquals("Recolor does not have a height value", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testResizeInvalid() {
    // set/get colors
    try {
      resize1.getStartB();
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalStateException iae) {
      assertEquals("Resize cannot get color values", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // set/get location
    try {
      resize1.getStartReference();
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalStateException iae) {
      assertEquals("Resize cannot get position values", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

  }

}

