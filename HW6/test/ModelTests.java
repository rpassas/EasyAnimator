import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import cs5004.AnimationModel.AbstractShape;
import cs5004.AnimationModel.AnimationModelImpl;
import cs5004.AnimationModel.AvailableShapes;
import cs5004.AnimationModel.Change;
import cs5004.AnimationModel.Circle;
import cs5004.AnimationModel.Recolor;
import cs5004.AnimationModel.Rect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
    modelConstructor.addShape(AvailableShapes.RECTANGLE, "Rect1", 5, 1, 2, 5);
    assertEquals("[Rectangle Rect1 -> center: (5, 1), x-dimension: 2, y-dimension: 5]",
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
    testList.add(circleConstructorRadius);
    model1.addShape(circleConstructorRadius);
    assertEquals(testList, model1.getShapes());

    // adding via a change
    Rect rectangle2 = new Rect("Rect2", 3, 6, 2, 3,
        10, 20, 30, 50);
    model1.addMove(rectangle2, 5, 5, 0, 4);
    testList.add(rectangle2);
    assertEquals(testList, model1.getShapes());

    // testing a model via shape constructor
    model2.addShape(AvailableShapes.RECTANGLE, "aRect", 2, 2, 2, 2);
    model2.addShape(AvailableShapes.RECTANGLE, "anotherRect", 3, 3, 3, 3);
    model2.addShape(AvailableShapes.OVAL, "aCircle", 4, 4, 4, 4);
    model2.addShape(AvailableShapes.OVAL, "anotherCircle",
        5, 5, 5, 5, 5, 5, 5, 100);
    model2.addShape(AvailableShapes.RECTANGLE, "Rect3",
        6, 6, 6, 6, 6, 6, 6, 6);
    assertEquals("[Rectangle aRect -> center: (2, 2), x-dimension: 2, y-dimension: 2," +
            " Rectangle anotherRect -> center: (3, 3), x-dimension: 3, y-dimension: 3," +
            " cs5004.AnimationModel.Circle aCircle -> center: (4, 4), x-dimension: 4, y-dimension: 4," +
            " cs5004.AnimationModel.Circle anotherCircle -> center: (5, 5), x-dimension: 5, y-dimension: 5," +
            " Rectangle Rect3 -> center: (6, 6), x-dimension: 6, y-dimension: 6]",
            model2.getShapes().toString());
  }

  @Test
  public void testInvalidAddShapesWH() {
    // Testing negative width for addShape 2
    try {
      model1.addShape(AvailableShapes.OVAL, "invalid 1", 5, 5, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative height for addShape 2
    try {
      model1.addShape(AvailableShapes.OVAL, "invalid 1", 5, 5, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testRemoveShapes() {
    //Removing by shape index
    model2.addShape(AvailableShapes.RECTANGLE, "Rect1", 2, 2, 2, 2);
    model2.addShape(AvailableShapes.RECTANGLE, "Rect2",3, 3, 3, 3);
    model2.addShape(AvailableShapes.OVAL, "Circle1",4, 4, 4, 4);
    model2.addShape(AvailableShapes.OVAL,"Circle2",
        5, 5, 5, 5, 5, 5, 5, 100);
    model2.addShape(AvailableShapes.RECTANGLE,"Circle3",
        6, 6, 6, 6, 6, 6, 6, 6);
    model2.removeShape(0);
    assertEquals("[Rectangle Rect2 -> center: (3, 3), x-dimension: 3, y-dimension: 3, " +
            "cs5004.AnimationModel.Circle Circle1 -> center: (4, 4), x-dimension: 4, y-dimension: 4, cs5004.AnimationModel.Circle Circle2 -> " +
            "center: (5, 5), x-dimension: 5, y-dimension: 5, Rectangle Circle3 -> " +
            "center: (6, 6), x-dimension: 6, y-dimension: 6]",
            model2.getShapes().toString());
    model2.removeShape(1);
    model2.removeShape(3);
    model2.removeShape(4);
    assertEquals("[cs5004.AnimationModel.Circle Circle1 -> center: (4, 4), x-dimension: 4, y-dimension: 4]",
            model2.getShapes().toString());
    model2.removeShape(2);
    assertEquals("[]", model2.getShapes().toString());

    // Removing by shape object
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    model1.addShape(rectangle2);
    model1.addShape(circle2);
    assertEquals("[Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3, " +
            "cs5004.AnimationModel.Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4, " +
            "Rectangle R2 -> center: (5, 6), x-dimension: 7, y-dimension: 8, " +
            "cs5004.AnimationModel.Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45]",
            model1.getShapes().toString());
    model1.removeShape(rectangle1);
    model1.removeShape(rectangle2);
    assertEquals("[cs5004.AnimationModel.Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4, " +
            "cs5004.AnimationModel.Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45]",
            model1.getShapes().toString());
    model1.removeShape(circle1);
    model1.removeShape(circle2);
    assertEquals("[]", model1.getShapes().toString());
  }

  @Test
  public void testRemoveShape() {
    // Testing removing by shape identifier
    try {
      model1.removeShape(15);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("That identifier is empty.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
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
    //TODO how would we add a shape like this and then get it to move with parallel lists?
    model1.addShape(AvailableShapes.RECTANGLE, "Rect1", 1, 2, 3, 7);
    model1.addShape(AvailableShapes.RECTANGLE, "Rect2", 11, 3, 2, 3);
    model1.addShape(AvailableShapes.OVAL, "Circle1", 41, 44, 1, 4);
    model1.addShape(AvailableShapes.OVAL, "Circle2",
        5, 25, 5, 55, 53, 35, 5, 100);

    model2.addShape(rectangle1);
    model2.addShape(circle2);
    model2.addMove(rectangle1, 15, 15, 5, 10);
    model2.addMove(rectangle1, 2, 2, 10, 20);
    assertEquals("[Shape R1 updates its position to" +
            " x-dimension: 15, y-dimension: 15 from t= 5 to t= 10\n" +
            ", Shape R1 updates its position to" +
            " x-dimension: 2, y-dimension: 2 from t= 10 to t= 20\n" +
            "]",
            model2.getChanges().toString());
    model2.addMove(circle2,1, 1, 0, 25);
    assertEquals("[Shape R1 updates its position to" +
            " x-dimension: 15, y-dimension: 15 from t= 5 to t= 10\n" +
            ", Shape R1 updates its position to" +
            " x-dimension: 2, y-dimension: 2 from t= 10 to t= 20\n" +
            ", Shape C2 updates its position to" +
            " x-dimension: 1, y-dimension: 1 from t= 0 to t= 25\n" +
            "]",
            model2.getChanges().toString());
  }

  @Test
  public void testIllegalAddMove() {
    // Testing negative t1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 25, -5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at front
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 15, 25);
      testIllegal.addMove(circle1, 15, 15, 1, 16);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at the back
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 15, 25);
      testIllegal.addMove(circle1, 15, 15, 24, 45);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 2 is within move 1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 15, 25);
      testIllegal.addMove(circle1, 15, 15, 19, 21);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 1 is within move 2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 15, 25);
      testIllegal.addMove(circle1, 15, 15, 0, 40);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one move change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing start time after end time
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addMove(circle1, 15, 15, 15, 5);
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
    Recolor color1 = new Recolor(rectangle1,
        0, rectangle1.getLabel(),100, 115, 130, 0, 5, 10);
    testList.add(color1);
    model1.addRecolor(rectangle1, 100, 115, 130, 0, 5, 10);
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
            0, circle1.getLabel(),100, 115, 130, 0, 5, 10);
    testList2.add(color2);
    model2.addRecolor(circle1, 100, 115, 130, 0, 5, 10);
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
      testIllegal.addRecolor(circle1, -15, 25, 30, 100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative G
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, -25, 30, 100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative B
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, -30, 100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative A
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, -100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // Testing too High R
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 315, 25, 30, 100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing too High G
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 325, 30, 100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing too high B
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 256, 100, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Color values must be below 255", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing too high A
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 101, 5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Opacity must be between 0 and 100", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    // Testing negative t1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, -5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 5, -6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at front
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 1, 16);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at the back
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 24, 45);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 2 is within move 1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 19, 21);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 1 is within move 2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 15, 25);
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 0, 40);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one recolor change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing start time after end time
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addRecolor(circle1, 15, 25, 30, 100, 6, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Start time > end time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testAddResize() {
    model1.addShape(rectangle2);
    assertEquals("[Rectangle R2 -> center: (5, 6), x-dimension: 7, y-dimension: 8]",
            model1.getShapes().toString());
    model1.addResize(rectangle2, 1, 3, 0 , 15);
    assertEquals("[Shape R2 updates its dimensions to" +
            " width: 1 height: 3 from t= 0 to t= 15\n" +
            "]",
            model1.getChanges().toString());
    model1.addResize(rectangle2, 5, 5, 15, 50);
    assertEquals("[Shape R2 updates its dimensions to" +
            " width: 1 height: 3 from t= 0 to t= 15\n" +
            ", Shape R2 updates its dimensions to" +
            " width: 5 height: 5 from t= 15 to t= 50\n" +
            "]",
            model1.getChanges().toString());

    model2.addShape(rectangle1);
    model2.addShape(circle2);
    model2.addShape(circle1);
    assertEquals("[Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3, " +
            "cs5004.AnimationModel.Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45, " +
            "cs5004.AnimationModel.Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4]",
            model2.getShapes().toString());
    model2.addResize(rectangle1, 1, 1, 1, 2);
    model2.addResize(circle1, 1, 1, 1, 2);
    model2.addResize(circle2, 1, 1, 1, 2);
    assertEquals("[Shape R1 updates its dimensions to" +
            " width: 1 height: 1 from t= 1 to t= 2\n" +
            ", Shape C1 updates its dimensions to width: 1 height: 1 from t= 1 to t= 2\n" +
            ", Shape C2 updates its dimensions to width: 1 height: 1 from t= 1 to t= 2\n" +
            "]",
            model2.getChanges().toString());
  }

  @Test
  public void testIllegalAddResize() {
    // TODO added x & y must be positive, that should line up with our other logic
    // Testing negative/0 width
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, -15, 15, 5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative/0 height
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 0, 5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("dimensions must be positive.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, -5, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing negative t2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 25, -5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Time value must be positive", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at front
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 15, 25);
      testIllegal.addResize(circle1, 15, 15, 1, 16);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time at the back
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 15, 25);
      testIllegal.addResize(circle1, 15, 15, 24, 45);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 2 is within move 1
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 15, 25);
      testIllegal.addResize(circle1, 15, 15, 19, 21);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing conflicting time, move 1 is within move 2
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 15, 25);
      testIllegal.addResize(circle1, 15, 15, 0, 40);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Only one resize change can be made at a time", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    // Testing start time after end time
    try {
      AnimationModelImpl testIllegal = new AnimationModelImpl();
      testIllegal.addResize(circle1, 15, 15, 15, 5);
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
    assertEquals("""
        Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3
        cs5004.AnimationModel.Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4
        """, model1.toString());
    model1.addMove(rectangle1, 2, 3, 2,3);
    model1.addMove(circle1, 2, 3, 2,3);
    model1.addRecolor(rectangle1, 2, 3, 250,3, 5, 7);
    model1.addRecolor(circle1, 17, 111, 2,3, 5, 8);
    assertEquals("Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3\n" +
        "cs5004.AnimationModel.Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4\n" +
        "Shape R1 updates its position to x-dimension: 2, y-dimension: 3 from t= 2 to t= 3\n" +
        "Shape C1 updates its position to x-dimension: 2, y-dimension: 3 from t= 2 to t= 3\n" +
        "Shape R1 updates its color to (2, 3, 250) from t= 5 to t= 7\n" +
        "Shape C1 updates its color to (17, 111, 2) from t= 5 to t= 8\n", model1.toString());
    model1.addResize(circle1, 15, 15, 0, 100);
    assertEquals("Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3\n" +
            "cs5004.AnimationModel.Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4\n" +
            "Shape R1 updates its position to x-dimension: 2, y-dimension: 3 from t= 2 to t= 3\n" +
            "Shape C1 updates its position to x-dimension: 2, y-dimension: 3 from t= 2 to t= 3\n" +
            "Shape R1 updates its color to (2, 3, 250) from t= 5 to t= 7\n" +
            "Shape C1 updates its color to (17, 111, 2) from t= 5 to t= 8\n" +
            "Shape C1 updates its dimensions to width: 15 height: 15 from t= 0 to t= 100\n",
            model1.toString());
  }

}
