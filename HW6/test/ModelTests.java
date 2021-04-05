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

  @Before
  public void setup() {
    model1 = new AnimationModelImpl();
    model2 = new AnimationModelImpl();
  }

  @Test
  public void testAnimationModelImplConstructor() {
    AnimationModelImpl modelConstructor = new AnimationModelImpl();
    modelConstructor.addShape(AvailableShapes.RECTANGLE, 5, 1, 2, 5);
    assertEquals("[Rectangle-> center: (5, 1) x-dimension: 2, y-dimension: 5]", modelConstructor.getShapes().toString());
  }

  @Test
  public void addingShapes() {
    // adding a circle and rect via a premade shape
    LinkedList<AbstractShape> testList = new LinkedList<AbstractShape>();
    assertEquals(testList, model1.getShapes());
    Circle circleConstructorRadius = new Circle(5, 3, 2);
    testList.add(circleConstructorRadius);
    model1.addShape(circleConstructorRadius);
    assertEquals(testList, model1.getShapes());
    Rect rectangle1 = new Rect(3, 6, 4, 7);
    testList.add(circleConstructorRadius);
    model1.addShape(circleConstructorRadius);
    assertEquals(testList, model1.getShapes());

    // adding via a change
    Rect rectangle2 = new Rect(3, 6, 2, 3, 10, 20, 30, 50);
    model1.addMove(rectangle2, 5,5,0,4);
    testList.add(rectangle2);
    assertEquals(testList, model1.getShapes());

    // testing a model via shape constructor
    model2.addShape(AvailableShapes.RECTANGLE, 2, 2, 2, 2);
    model2.addShape(AvailableShapes.RECTANGLE, 3, 3, 3, 3);
    model2.addShape(AvailableShapes.OVAL, 4, 4, 4, 4);
    model2.addShape(AvailableShapes.OVAL, 5, 5, 5, 5, 5, 5, 5, 100);
    model2.addShape(AvailableShapes.RECTANGLE, 6, 6, 6, 6, 6, 6, 6, 6);
    assertEquals("[Rectangle-> center: (2, 2) x-dimension: 2, y-dimension: 2," +
            " Rectangle-> center: (3, 3) x-dimension: 3, y-dimension: 3, " +
            "Circle-> center: (4, 4) x-dimension: 4, y-dimension: 4, " +
            "Circle-> center: (5, 5) x-dimension: 5, y-dimension: 5, " +
            "Rectangle-> center: (6, 6) x-dimension: 6, y-dimension: 6]",
            model2.getShapes().toString());
  }

  @Test
  public void testRemoveShapes () {
    //Removing by shapde index
    model2.addShape(AvailableShapes.RECTANGLE, 2, 2, 2, 2);
    model2.addShape(AvailableShapes.RECTANGLE, 3, 3, 3, 3);
    model2.addShape(AvailableShapes.OVAL, 4, 4, 4, 4);

    model2.addShape(AvailableShapes.OVAL, 5, 5, 5, 5, 5, 5, 5, 100);
    model2.addShape(AvailableShapes.RECTANGLE, 6, 6, 6, 6, 6, 6, 6, 6);
    model2.removeShape(0);
    assertEquals("[Rectangle-> center: (3, 3) x-dimension: 3, y-dimension: 3, " +
                    "Circle-> center: (4, 4) x-dimension: 4, y-dimension: 4, " +
                    "Circle-> center: (5, 5) x-dimension: 5, y-dimension: 5, " +
                    "Rectangle-> center: (6, 6) x-dimension: 6, y-dimension: 6]",
            model2.getShapes().toString());
    model2.removeShape(1);
    model2.removeShape(3);
    model2.removeShape(4);
    assertEquals("[Circle-> center: (4, 4) x-dimension: 4, y-dimension: 4]",
            model2.getShapes().toString());
    model2.removeShape(2);
    assertEquals("[]", model2.getShapes().toString());

    // Removing by shape object
    Rect rectangle1 = new Rect(3, 6, 2, 3, 10, 20, 30, 50);
    Circle circle1 = new Circle(1, 2, 3, 4);
    Rect rectangle2 = new Rect(5, 6, 7, 8);
    Circle circle2 = new Circle(15, 26, 45, 0, 64, 254, 100);
    model1.addShape(rectangle1);
    model1.addShape(circle1);
    model1.addShape(rectangle2);
    model1.addShape(circle2);
    assertEquals("[Rectangle-> center: (3, 6) x-dimension: 2, " +
                    "y-dimension: 3, Circle-> center: (1, 2) x-dimension: 3, " +
                    "y-dimension: 4, Rectangle-> center: (5, 6) x-dimension: 7, " +
                    "y-dimension: 8, Circle-> center: (15, 26) x-dimension: 45, " +
                    "y-dimension: 45]",
            model1.getShapes().toString());
    model1.removeShape(rectangle1);
    model1.removeShape(rectangle2);
    assertEquals("[Circle-> center: (1, 2) x-dimension: 3, " +
                    "y-dimension: 4, Circle-> center: (15, 26) x-dimension: 45, " +
                    "y-dimension: 45]",
            model1.getShapes().toString());
    model1.removeShape(circle1);
    model1.removeShape(circle2);
    assertEquals("[]", model1.getShapes().toString());
  }
}
