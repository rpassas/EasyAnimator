import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CTests {
  private Circle circle1;
  private Circle circle2;
  private Circle circle3;
  private Circle circle4;

  @Test
  public void testConstructor() {
    //Testing the constructor with a radius no RGB or width and height
    Circle circleConstructorRadius = new Circle(5, 3, 2);
    assertEquals("Circle-> center: (5, 3) x-dimension: 2, y-dimension: 2",
            circleConstructorRadius.toString());
    // Testing the constructor with a width and a height and no radius or rgb
    Circle circleConstructorWH1 = new Circle(2, 4, 5, 6);
    assertEquals("Circle-> center: (2, 4) x-dimension: 5, y-dimension: 6",
            circleConstructorWH1.toString());
    Circle circleConstructorWH2 = new Circle(15, 1, 15, 167);
    assertEquals("Circle-> center: (15, 1) x-dimension: 15, y-dimension: 167",
            circleConstructorWH2.toString());
    //Testing constructor with width and height and rgb, no radius
    Circle circleConstructorRGB1 = new Circle(5, 3, 2, 2, 2, 2, 2, 20);
    assertEquals("Circle-> center: (5, 3) x-dimension: 2, y-dimension: 2",
            circleConstructorRGB1.toString());
    Circle circleConstructorRGB2 = new Circle(1, 1, 1, 1, 1, 1, 1, 1);
    assertEquals("Circle-> center: (1, 1) x-dimension: 1, y-dimension: 1",
            circleConstructorRGB2.toString());
    //Testing constructor with radius and rgb no width and height
    Circle circleConstructorRGBRadius = new Circle(1, 2, 3, 4, 5, 6, 7);
    assertEquals("Circle-> center: (1, 2) x-dimension: 3, y-dimension: 3",
            circleConstructorRGBRadius.toString());
  }

  @Test
  public void testInvalidConstructor1() {
    // Testing negative radius for constructor 1
    try {
      new Circle(5, 5, -5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Radius must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative X for constructor 1
    try {
      new Circle(-5, 5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Y for constructor 1
    try {
      new Circle(1, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative X/Y for constructor 1
    try {
      new Circle(-5, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidConstructor2() {
    // Testing negative X for constructor 2
    try {
      new Circle(-5, 5, 2, 3, 2, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Y for constructor 2
    try {
      new Circle(5, -5, 2, 3, 2, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative X/Y for constructor 2
    try {
      new Circle(-5, -5, 2, 3, 2, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Width for constructor 2
    try {
      new Circle(5, 5, -2, 3, 2, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Height for constructor 2
    try {
      new Circle(5, 5, 2, -3, 2, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative r for constructor 2
    try {
      new Circle(5, 5, 2, 3, -2, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing r too high for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2000, 4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative g for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2, -4, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing g too high for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2, 400, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative b for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2, 4, -5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing b too high for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2, 4, 578, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative a for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2, 4, 5, -6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing a too high for constructor 2
    try {
      new Circle(5, 5, 2, 3, 2, 4, 5, 600);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidConstructor3() {
    // Testing negative X for constructor 3
    try {
      new Circle(-11, 12, 13, 14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Y for constructor 3
    try {
      new Circle(11, -12, 13, 14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative X/Y for constructor 3
    try {
      new Circle(-11, -12, 13, 14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Width for constructor 3
    try {
      new Circle(11, 12, -13, 14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Height for constructor 3
    try {
      new Circle(11, 12, 13, -14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidConstructor4() {
    // Testing negative X for constructor 4
    try {
      new Circle(-20, 30, 40, 50, 60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative Y for constructor 4
    try {
      new Circle(20, -30, 40, 50, 60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative X/Y for constructor 4
    try {
      new Circle(-20, -30, 40, 50, 60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("X and Y must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative radius for constructor 4
    try {
      new Circle(20, 30, -40, 50, 60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative r for constructor 4
    try {
      new Circle(20, 30, 40, -50, 60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing r too high for constructor 4
    try {
      new Circle(20, 30, 40, 500, 60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative g for constructor 4
    try {
      new Circle(20, 30, 40, 50, -60, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing g too high for constructor 4
    try {
      new Circle(20, 30, 40, 50, 690, 70, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative b for constructor 4
    try {
      new Circle(20, 30, 40, 50, 60, -1, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing b too high for constructor 4
    try {
      new Circle(20, 30, 40, 50, 60, 708, 80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative a for constructor 4
    try {
      new Circle(20, 30, 40, 50, 60, 70, -80);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing a too high for constructor 4
    try {
      new Circle(20, 30, 40, 50, 60, 70, 101);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }
}
