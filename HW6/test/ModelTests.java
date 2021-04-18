import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AvailableShapes;
import cs5004.animator.model.Change;
import cs5004.animator.model.Circle;
import cs5004.animator.model.Recolor;
import cs5004.animator.model.Rect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Testing for the Model class.
 */
public class ModelTests {
  private AnimationModelImpl model1;
  private AnimationModelImpl model2;
  private Rect rectangle1;
  private Rect rectangle2;
  private Circle circle1;
  private Circle circle2;

  @Before
  public void setup() {
    model1 = new AnimationModelImpl();
    model2 = new AnimationModelImpl();
    rectangle1 = new Rect("R1", 3, 6, 2, 3, 10, 20, 30, 50);
    rectangle2 = new Rect("R2", 5, 6, 7, 8);
    circle1 = new Circle("C1", 1, 2, 3, 4);
    circle2 = new Circle("C2", 15, 26, 45, 0, 64, 254, 100);
  }

  @Test
  public void testAnimationModelImplConstructor() {
    AnimationModelImpl modelConstructor = new AnimationModelImpl();
    modelConstructor.addShape(AvailableShapes.RECTANGLE, "Rect1", 5, 1, 2, 5,
        0, 0, 0,0);
    assertEquals("[Rectangle Rect1 with RGB(0, 0, 0), and corner at (5, 1), " +
            "width: 2, height: 5]",
        modelConstructor.getShapes().toString());
  }

  @Test
  public void addingShapes() {
    // adding a circle and rect via a premade shape
    LinkedList<AbstractShape> testList = new LinkedList<>();
    assertEquals(testList, model1.getShapes());
    Circle circleConstructorRadius = new Circle("Circ",5, 3, 2);
    testList.add(circleConstructorRadius);
    model1.addShape(circleConstructorRadius);
    assertEquals(testList, model1.getShapes());
    Rect rectangle1 = new Rect("cs5004.AnimationModel.Rect", 3, 6, 4, 7);
    assertEquals(testList, model1.getShapes());

    // adding via a change
    Rect rectangle2 = new Rect("Rect2", 3, 6, 2, 3,
        10, 20, 30, 50);
    model1.addMove(rectangle2, 5, 5, 3, 4,  0, 4);
    testList.add(rectangle2);
    assertEquals(testList, model1.getShapes());

    // testing a model via shape constructor
    model2.addShape(AvailableShapes.RECTANGLE, "aRect", 2, 2, 2, 2, 0, 0,
        0,0);
    model2.addShape(AvailableShapes.RECTANGLE, "anotherRect", 3, 3, 3, 3,0,
        0, 0,0);
    model2.addShape(AvailableShapes.OVAL, "aCircle", 4, 4, 4, 4,0, 0,
        0,0);
    model2.addShape(AvailableShapes.OVAL, "anotherCircle",
        5, 5, 5, 5, 5, 5, 5, 100);
    model2.addShape(AvailableShapes.RECTANGLE, "Rect3",
        6, 6, 6, 6, 6, 6, 6, 6);
    assertEquals("[Rectangle aRect with RGB(0, 0, 0), and corner at (2, 2), width: 2, " +
            "height: 2, Rectangle anotherRect with RGB(0, 0, 0), and corner at (3, 3), " +
            "width: 3, height: 3, Ellipse aCircle with RGB(0, 0, 0), and center at: " +
            "(4, 4), x-diameter: 4, y-diameter: 4, Ellipse anotherCircle with " +
            "RGB(5, 5, 5), and center at: (5, 5), x-diameter: 5, y-diameter: 5, " +
            "Rectangle Rect3 with RGB(6, 6, 6), and corner at (6, 6), width: " +
            "6, height: 6]",
        model2.getShapes().toString());
  }

  @Test
  public void testInvalidAddShapesWH() {
    // Testing negative width for addShape 2
    try {
      model1.addShape(AvailableShapes.OVAL, "invalid 1", 5, 5, -5, 5,0,
          0, 0,0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative height for addShape 2
    try {
      model1.addShape(AvailableShapes.OVAL, "invalid 1", 5, 5, -5, 5,0,
          0, 0,0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testRemoveShapes() {
    //Removing by shape index
    model2.addShape(AvailableShapes.RECTANGLE, "Rect1", 2, 2, 2, 2,
        0, 0, 0,0);
    model2.addShape(AvailableShapes.RECTANGLE, "Rect2",3, 3, 3, 3,
        0, 0, 0,0);
    model2.addShape(AvailableShapes.OVAL, "Circle1",4, 4, 4, 4,0,
        0, 0,0);
    model2.addShape(AvailableShapes.OVAL,"Circle2",
        5, 5, 5, 5, 5, 5, 5, 100);
    model2.addShape(AvailableShapes.RECTANGLE,"Circle3",
        6, 6, 6, 6, 6, 6, 6, 6);
    model2.removeShape("Rect1");
    assertEquals("[Rectangle Rect2 with RGB(0, 0, 0), and corner at (3, 3), width: " +
            "3, height: 3, Ellipse Circle1 with RGB(0, 0, 0), and center at: (4, 4), " +
            "x-diameter: 4, y-diameter: 4, Ellipse Circle2 with RGB(5, 5, 5), " +
            "and center at: (5, 5), x-diameter: 5, y-diameter: 5, Rectangle Circle3 " +
            "with RGB(6, 6, 6), and corner at (6, 6), width: 6, height: 6]",
        model2.getShapes().toString());
    model2.removeShape("Rect2");
    model2.removeShape("Circle1");
    model2.removeShape("Circle2");
    assertEquals("[Rectangle Circle3 with RGB(6, 6, 6), and corner at (6, 6), " +
            "width: 6, height: 6]",
        model2.getShapes().toString());
    model2.removeShape("Circle3");
    assertEquals("[]", model2.getShapes().toString());
  }

  @Test
  public void testRemoveShape() {
    // Testing removing by label
    try {
      model1.removeShape("hi");
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Given label does not exist.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testAddMove() {
    model1.addShape(AvailableShapes.RECTANGLE, "Rect1", 1, 2, 3, 7, 0,
        0, 0, 0);
    model1.addShape(AvailableShapes.RECTANGLE, "Rect2", 11, 3, 2, 3, 0,
        0, 0, 0);
    model1.addShape(AvailableShapes.OVAL, "Circle1", 41, 44, 1, 4, 0,
        0, 0, 0);
    model1.addShape(AvailableShapes.OVAL, "Circle2",
        5, 25, 5, 55, 53, 35, 5, 100);

    model2.addShape(rectangle1);
    model2.addShape(circle2);
    model2.addMove(rectangle1, 15, 15, 5, 10,  2, 11);
    model2.addMove(rectangle1, 2, 2, 10, 20, 12, 17);
    assertEquals("Rectangle R1 with RGB(10, 20, 30), and corner at (3, 6), width: 2," +
            " height: 3\n" +
            "Ellipse C2 with RGB(0, 64, 254), and center at: (15, 26), x-diameter: 45," +
            " y-diameter: 45\n" +
            "\n" +
            "R1 appears at time t=2\n" +
            "\n" +
            "Shape R1 updates its position from x-dimension: 2, y-dimension:" +
            " 2 to x-dimension: 10, y-dimension: 20 from t= 12 to t= 17\n",
        model2.toString());
    model2.addMove(circle2,1, 1, 0, 25, 18, 20);
    assertEquals("Rectangle R1 with RGB(10, 20, 30), and corner at (3, 6), width:" +
            " 2, height: 3\n" +
            "Ellipse C2 with RGB(0, 64, 254), and center at: (15, 26), x-diameter:" +
            " 45, y-diameter: 45\n" +
            "\n" +
            "R1 appears at time t=2\n" +
            "C2 appears at time t=18\n" +
            "\n" +
            "Shape R1 updates its position from x-dimension: 2, y-dimension:" +
            " 2 to x-dimension: 10, y-dimension: 20 from t= 12 to t= 17\n",
        model2.toString());
  }

  @Test
  public void testIllegalAddMove() {
    // Testing negative t1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, -5, 5, -10, 20);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 25, -5, 10, -20);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at front
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 5, 20, 15, 25);
      testIllegal.addMove(circle1, 15, 15,19, 20, 1, 16);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at the back
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15,5, 20, 15, 25);
      testIllegal.addMove(circle1, 15, 15,5, 20, 24, 45);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 2 is within move 1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15,5, 20, 15, 25);
      testIllegal.addMove(circle1, 15, 15,5, 20, 19, 21);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 1 is within move 2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15,5, 20, 15, 25);
      testIllegal.addMove(circle1, 15, 15,5, 20, 0, 40);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing start time after end time
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15,5, 20, 15, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Start time > end time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testAddColor() {
    model1.addShape(rectangle1);
    LinkedList<Change> testList = new LinkedList<>();
    Recolor color1 = new Recolor(rectangle1, rectangle1.getLabel(),
        100, 115, 130, 100,
        100, 115, 130, 100, 0, 5);
    testList.add(color1);
    model1.addRecolor(rectangle1, 100, 115, 130, 100,
        100, 115, 130, 100, 0, 5);
    assertEquals(testList.get(0).getShapeID(), model1.getChanges().get(0).getShapeID());
    assertEquals(testList.get(0).getUpdatedR(), model1.getChanges().get(0).getUpdatedR());
    assertEquals(testList.get(0).getUpdatedG(), model1.getChanges().get(0).getUpdatedG());
    assertEquals(testList.get(0).getUpdatedB(), model1.getChanges().get(0).getUpdatedB());
    assertEquals(testList.get(0).getUpdatedA(), model1.getChanges().get(0).getUpdatedA());
    assertEquals(testList.get(0).getStartTime(), model1.getChanges().get(0).getStartTime());
    assertEquals(testList.get(0).getEndTime(), model1.getChanges().get(0).getEndTime());

    model2.addShape(circle1);
    LinkedList<Change> testList2 = new LinkedList<>();
    Recolor color2 = new Recolor(circle1,
        circle1.getLabel(),100, 115, 130, 0,
        100, 115, 10, 0,5, 10);
    testList2.add(color2);
    model2.addRecolor(circle1, 100, 115, 130, 0,
        100, 115, 10, 0,5, 10);
    assertEquals(testList2.get(0).getShapeID(), model2.getChanges().get(0).getShapeID());
    assertEquals(testList2.get(0).getUpdatedR(), model2.getChanges().get(0).getUpdatedR());
    assertEquals(testList2.get(0).getUpdatedG(), model2.getChanges().get(0).getUpdatedG());
    assertEquals(testList2.get(0).getUpdatedB(), model2.getChanges().get(0).getUpdatedB());
    assertEquals(testList2.get(0).getUpdatedA(), model2.getChanges().get(0).getUpdatedA());
    assertEquals(testList2.get(0).getStartTime(), model2.getChanges().get(0).getStartTime());
    assertEquals(testList2.get(0).getEndTime(), model2.getChanges().get(0).getEndTime());
  }

  @Test
  public void testIllegalAddColor() {
    // Testing negative R
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, -15, 25, 30, 100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative G
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, -25, 30, 100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative B
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, -30, 100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative A
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, -100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // Testing too High R
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 315, 25, 30, 100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing too High G
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 325, 30, 100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing too high B
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 256, 100,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing too high A
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 101,
          100, 115, 130, 0,5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // Testing negative t1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,-5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,5, -6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at front
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,1, 16);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at the back
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,24, 45);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 2 is within move 1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,19, 21);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 1 is within move 2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,0, 40);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing start time after end time
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100,
          100, 115, 130, 0,6, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Start time > end time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testAddResize() {
    model1.addShape(rectangle2);
    assertEquals("[Rectangle R2 with RGB(0, 0, 0), and corner at (5, 6), " +
            "width: 7, height: 8]",
        model1.getShapes().toString());
    model1.addResize(rectangle2, 1, 3,
        5, 3,0 , 15);
    assertEquals("[Shape R2 updates its dimensions from width: 1 height: 3" +
            " to width: 5 height: 3 from t= 0 to t= 15\n" +
            "]",
        model1.getChanges().toString());
    model1.addResize(rectangle2, 5, 5,
        1, 3,15, 50);

    assertEquals("[Shape R2 updates its dimensions from width: 5 height: 5 to width:" +
            " 1 height: 3 from t= 15 to t= 50\n" +
            ", Shape R2 updates its dimensions from width: 1 height: 3 to width:" +
            " 5 height: 3 from t= 0 to t= 15\n" +
            "]",
        model1.getChanges().toString());

    model2.addShape(rectangle1);
    model2.addShape(circle2);
    model2.addShape(circle1);
    assertEquals("[Rectangle R1 with RGB(10, 20, 30), and corner at (3, 6), width: " +
            "2, height: 3, Ellipse C2 with RGB(0, 64, 254), and center at: (15, 26), " +
            "x-diameter: 45, y-diameter: 45, Ellipse C1 with RGB(0, 0, 0), and center" +
            " at: (1, 2), x-diameter: 3, y-diameter: 4]",
        model2.getShapes().toString());
    model2.addResize(rectangle1, 1, 1,7, 3, 1, 2);
    model2.addResize(circle1, 1, 1,3, 8, 1, 2);
    model2.addResize(circle2, 1, 1, 4, 1,1, 2);
    assertEquals("[Shape C1 updates its dimensions from width: 1 height: 1 to width:" +
            " 3 height: 8 from t= 1 to t= 2\n" +
            ", Shape R1 updates its dimensions from width: 1 height: 1 to width: 7 height:" +
            " 3 from t= 1 to t= 2\n" +
            ", Shape C2 updates its dimensions from width: 1 height: 1 to width: 4 height:" +
            " 1 from t= 1 to t= 2\n" +
            "]",
        model2.getChanges().toString());
  }

  @Test
  public void testIllegalAddResize() {
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, -15, 15, 1, 3, 5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative/0 height
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, -1,1, 3, 5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15,1, 3, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15,1, 3, 25, -5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at front
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15,1, 3, 15, 25);
      testIllegal.addResize(circle1, 15, 15,1, 3, 1, 16);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at the back
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15,1, 3, 15, 25);
      testIllegal.addResize(circle1, 15, 15,1, 3, 24, 45);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 2 is within move 1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15,1, 3, 15, 25);
      testIllegal.addResize(circle1, 15, 15, 1, 3,19, 21);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 1 is within move 2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15,1, 3, 15, 25);
      testIllegal.addResize(circle1, 15, 15, 1, 3,0, 40);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing start time after end time
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 1, 3,15, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Start time > end time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testToString() {
    assertEquals("", model1.toString());
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    assertEquals("Rectangle R1 with RGB(10, 20, 30), and corner at (3, 6), " +
            "width: 2, height: 3\n" +
            "Ellipse C1 with RGB(0, 0, 0), and center at: (1, 2), " +
            "x-diameter: 3, y-diameter: 4\n"
        , model1.toString());
    model1.addMove(rectangle1, 2, 3, 1, 3,2,3);
    model1.addMove(circle1, 2, 3, 1, 3,2,3);
    model1.addRecolor(rectangle1, 2, 3, 250,3,
        2, 3, 250,3,5, 7);
    model1.addRecolor(circle1, 17, 111, 2,3,
        2, 3, 250,3,5, 8);
    assertEquals("Rectangle R1 with RGB(10, 20, 30), and corner at (3, 6), width: " +
            "2, height: 3\n" +
            "Ellipse C1 with RGB(0, 0, 0), and center at: (1, 2), x-diameter: 3, " +
            "y-diameter: 4\n" +
            "Shape R1 updates its position from x-dimension: 2, y-dimension: 3 to " +
            "x-dimension: 1, y-dimension: 3 from t= 2 to t= 3\n" +
            "Shape C1 updates its position from x-dimension: 2, y-dimension: 3 to " +
            "x-dimension: 1, y-dimension: 3 from t= 2 to t= 3\n" +
            "Shape R1 updates its color from (2, 3, 250, 3) to (2, 3, 250, 3) from " +
            "t= 5 to t= 7\n" +
            "Shape C1 updates its color from (17, 111, 2, 3) to (2, 3, 250, 3) from " +
            "t= 5 to t= 8\n",
        model1.toString());
    model1.addResize(circle1, 15, 15, 1, 3,0, 100);
    assertEquals("Rectangle R1 with RGB(10, 20, 30), and corner at (3, 6), width: " +
            "2, height: 3\n" +
            "Ellipse C1 with RGB(0, 0, 0), and center at: (1, 2), x-diameter: 3, " +
            "y-diameter: 4\n" +
            "Shape R1 updates its position from x-dimension: 2, y-dimension: 3 to " +
            "x-dimension: 1, y-dimension: 3 from t= 2 to t= 3\n" +
            "Shape C1 updates its position from x-dimension: 2, y-dimension: 3 to " +
            "x-dimension: 1, y-dimension: 3 from t= 2 to t= 3\n" +
            "Shape R1 updates its color from (2, 3, 250, 3) to (2, 3, 250, 3) from " +
            "t= 5 to t= 7\n" +
            "Shape C1 updates its color from (17, 111, 2, 3) to (2, 3, 250, 3) from " +
            "t= 5 to t= 8\n" +
            "Shape C1 updates its dimensions from width: 15 height: 15 to width: 1 " +
            "height: 3 from t= 0 to t= 100\n",
        model1.toString());
  }

  @Test
  public void testGetShapesAtTick() {
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    AnimationModel modelEmpty = model1.getShapesAtTick(1);
    assertEquals(model2.toString(), modelEmpty.toString());
    model1.addResize(rectangle1, 1, 3,
        5, 3,0 , 10);
    model1.addMove(rectangle1, 1, 3, 5,3,
        0, 10);
    model1.addRecolor(circle1, 18, 111, 2,3,
        2, 3, 250,3,5, 11);
    // altered attributes
    assertEquals(model1.getShapesAtTick(5).getShape(rectangle1.getLabel()).getWidth(),
        3);
    assertEquals(model1.getShapesAtTick(5)
            .getShape(rectangle1.getLabel()).getLocation().getX(),
        3);
    assertEquals(model1.getShapesAtTick(8)
            .getShape(circle1.getLabel()).getR(),
        10);
    assertEquals(model1.getShapesAtTick(8)
            .getShape(circle1.getLabel()).getG(),
        57);
    assertEquals(model1.getShapesAtTick(8)
            .getShape(circle1.getLabel()).getB(),
        126);
    assertEquals(model1.getShapesAtTick(8)
            .getShape(circle1.getLabel()).getOpacity(),
        3);
    // unaltered attributes stay the same
    assertEquals(model1.getShapesAtTick(5).getShape(rectangle1.getLabel()).getHeight(),
        3);
    assertEquals(model1.getShapesAtTick(5).getShape(circle1.getLabel()).getHeight(),
        4);
  }

  @Test
  public void testIllegalGetShapesAtTick() {
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    model1.addResize(rectangle1, 1, 3,
        5, 3,0 , 10);
    // Testing negative tick
    try {
      assertEquals(model1.getShapesAtTick(-1).getShape(rectangle1.getLabel()).getWidth(),
          3);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be >= 0\"", iae.getMessage());
    }
  }
}
