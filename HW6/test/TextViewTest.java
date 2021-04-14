import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AvailableShapes;
import cs5004.animator.model.Rect;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests cases for the TextView.
 */
public class TextViewTest {
  private TextView view1;
  private TextView view2;
  private AnimationModelImpl model;
  private String toh;

  @Before
  public void setup() {
    this.model = new AnimationModelImpl();
    this.toh = "toh-5.txt";
  }
/*
  @Test
  public void testConstructor() {
    //Testing the constructor 1 with X/Y width and Height
    SVGView toh1 = new TextView(model, toh, 2);
    assertEquals();
  }

  @Test
  public void testInvalidConstructor() {

  }

  //SVG and Text Views do not have methods that return anything rn
  @Test
  public void testOutput() {

  }

 */
}
