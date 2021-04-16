import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AvailableShapes;
import cs5004.animator.model.Rect;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.SVGView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests cases for the SVGView.
 */
public class SVGViewTest {
  private SVGView view1;
  private SVGView view2;
  private AnimationModelImpl model;
  private String toh;

  @Before
  public void setup() {
    this.model = new AnimationModelImpl();
    this.toh = "toh-5.txt";
  }

  @Test
  public void testConstructor() {
    //Testing the constructor 1 with X/Y width and Height

  }

  @Test
  public void testInvalidConstructor() {

}

//SVG and Text Views do not have methods that return anything rn
  @Test
  public void testOutput() throws IOException {
    FileReader fileIn = new FileReader("smalldemo.txt");
    AnimationModel model = AnimationReader.parseFile(fileIn,
            new AnimationModelImpl.Builder());
    Appendable viewLog = new StringBuilder();
    SVGView smalldemoSVG = new SVGView(model, viewLog, 10);
    smalldemoSVG.run();
    String[] lines = viewLog.toString().split("\n");
    viewLog.append("hello");
    System.out.print(viewLog.toString());
    assertEquals("1", viewLog.toString());
}

  }


