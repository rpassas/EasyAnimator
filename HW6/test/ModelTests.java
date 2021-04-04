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
  public void addingShapes() {
    // adding a circle and rect
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
  }
}
