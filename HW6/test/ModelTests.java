import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

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
    Rect rectangle1 = new Rect("Rect", 3, 6, 4, 7);
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
            " Circle aCircle -> center: (4, 4), x-dimension: 4, y-dimension: 4," +
            " Circle anotherCircle -> center: (5, 5), x-dimension: 5, y-dimension: 5," +
            " Rectangle Rect3 -> center: (6, 6), x-dimension: 6, y-dimension: 6]",
            model2.getShapes().toString());
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
            "Circle Circle1 -> center: (4, 4), x-dimension: 4, y-dimension: 4, Circle Circle2 -> " +
            "center: (5, 5), x-dimension: 5, y-dimension: 5, Rectangle Circle3 -> " +
            "center: (6, 6), x-dimension: 6, y-dimension: 6]",
            model2.getShapes().toString());
    model2.removeShape(1);
    model2.removeShape(3);
    model2.removeShape(4);
    assertEquals("[Circle Circle1 -> center: (4, 4), x-dimension: 4, y-dimension: 4]",
            model2.getShapes().toString());
    model2.removeShape(2);
    assertEquals("[]", model2.getShapes().toString());

    // Removing by shape object
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    model1.addShape(rectangle2);
    model1.addShape(circle2);
    assertEquals("[Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3, " +
            "Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4, " +
            "Rectangle R2 -> center: (5, 6), x-dimension: 7, y-dimension: 8, " +
            "Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45]",
            model1.getShapes().toString());
    model1.removeShape(rectangle1);
    model1.removeShape(rectangle2);
    assertEquals("[Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4, " +
            "Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45]",
            model1.getShapes().toString());
    model1.removeShape(circle1);
    model1.removeShape(circle2);
    assertEquals("[]", model1.getShapes().toString());
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
    assertEquals("[Rectangle R1 -> center: (2, 2), x-dimension: 2, y-dimension: 3, " +
                    "Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45]",
            model2.getShapes().toString());
    model2.addMove(circle2,1, 1, 0, 25);
    assertEquals("[Rectangle R1 -> center: (2, 2), x-dimension: 2, y-dimension: 3, " +
                    "Circle C2 -> center: (1, 1), x-dimension: 45, y-dimension: 45]",
            model2.getShapes().toString());
  }

  @Test
  public void testAddColor() {
    model1.addShape(rectangle1);
    LinkedList<Change> testList = new LinkedList<>();
    Recolor color1 = new Recolor(rectangle1,
        0, rectangle1.getLabel(),100, 115, 130, 0, 25);
    testList.add(color1);
    model1.addRecolor(rectangle1, 100, 115, 130, 0, 25);
    assertEquals(testList.get(0).getShapeID(), model1.getChanges().get(0).getShapeID());
    assertEquals(testList.get(0).getUpdatedR(), model1.getChanges().get(0).getUpdatedR());
    assertEquals(testList.get(0).getUpdatedG(), model1.getChanges().get(0).getUpdatedG());
    assertEquals(testList.get(0).getUpdatedB(), model1.getChanges().get(0).getUpdatedB());
    assertEquals(testList.get(0).getStartTime(), model1.getChanges().get(0).getStartTime());
    assertEquals(testList.get(0).getEndTime(), model1.getChanges().get(0).getEndTime());
    assertEquals(testList.get(0).getReference(), model1.getChanges().get(0).getReference());
  }

  @Test
  public void testAddResize() {
    model1.addShape(rectangle2);
    assertEquals("[Rectangle R2 -> center: (5, 6), x-dimension: 7, y-dimension: 8]",
            model1.getShapes().toString());
    model1.addResize(rectangle2, 1, 3, 0 , 15);
    assertEquals("[Rectangle R2 -> center: (5, 6), x-dimension: 1, y-dimension: 3]",
            model1.getShapes().toString());
    model1.addResize(rectangle2, 5, 5, 15, 50);
    assertEquals("[Rectangle R2 -> center: (5, 6), x-dimension: 5, y-dimension: 5]",
            model1.getShapes().toString());

    model2.addShape(rectangle1);
    model2.addShape(circle2);
    model2.addShape(circle1);
    assertEquals("[Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3, " +
            "Circle C2 -> center: (15, 26), x-dimension: 45, y-dimension: 45, " +
            "Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4]",
            model2.getShapes().toString());
    model2.addResize(rectangle1, 1, 1, 1, 2);
    model2.addResize(circle1, 1, 1, 1, 2);
    model2.addResize(circle2, 1, 1, 1, 2);
    assertEquals("[Rectangle R1 -> center: (3, 6), x-dimension: 1, y-dimension: 1," +
            " Circle C2 -> center: (15, 26), x-dimension: 1, y-dimension: 1, " +
            "Circle C1 -> center: (1, 2), x-dimension: 1, y-dimension: 1]",
            model2.getShapes().toString());
  }

  @Test
  public void testToString() {
    assertEquals("", model1.toString());
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    assertEquals("""
        Rectangle R1 -> center: (3, 6), x-dimension: 2, y-dimension: 3
        Circle C1 -> center: (1, 2), x-dimension: 3, y-dimension: 4
        """, model1.toString());
    model1.addMove(rectangle1, 2, 3, 2,3);
    model1.addMove(circle1, 2, 3, 2,3);
    model1.addRecolor(rectangle1, 2, 3, 250,3, 5);
    model1.addRecolor(circle1, 17, 111, 2,3, 5);
    assertEquals("""
        Rectangle R1 -> center: (2, 3), x-dimension: 2, y-dimension: 3
        Circle C1 -> center: (2, 3), x-dimension: 3, y-dimension: 4
        Shape R1 updates its position to x-dimension: 2, y-dimension: 3 from t= 2 to t= 3
        Shape C1 updates its position to x-dimension: 2, y-dimension: 3 from t= 2 to t= 3
        Shape R1 updates its color to (2, 3, 250) from t= 3 to t= 5
        Shape C1 updates its color to (17, 111, 2) from t= 3 to t= 5
        """, model1.toString());

  }

}
