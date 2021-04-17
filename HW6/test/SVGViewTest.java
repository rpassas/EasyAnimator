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
    assertEquals("<svg width=\"360\" height=\"360\" version=\"1.1\"xmls=\"http://www.w3.org/2000/svg\">\n" +
            "\n" +
            "<rect id=\"R\" x=\"100\" y=\"230\" width=\"25\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"hidden\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" attributeName=\"x\" from=\"0\" to=\"0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" attributeName=\"y\" from=\"130\" to=\"130\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" attributeName=\"x\" from=\"0\" to=\"100\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" attributeName=\"y\" from=\"130\" to=\"230\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" attributeName=\"x\" from=\"0\" to=\"100\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" attributeName=\"y\" from=\"130\" to=\"230\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"100ms\" attributeName=\"x\" from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"100ms\" attributeName=\"y\" from=\"230\" to=\"230\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5100ms\" dur=\"1900ms\" attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5100ms\" dur=\"1900ms\" attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5100ms\" dur=\"1900ms\" attributeName=\"x\" from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5100ms\" dur=\"1900ms\" attributeName=\"y\" from=\"230\" to=\"230\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"3000ms\" attributeName=\"x\" from=\"100\" to=\"0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"3000ms\" attributeName=\"y\" from=\"230\" to=\"130\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"3000ms\" attributeName=\"x\" from=\"100\" to=\"0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"3000ms\" attributeName=\"y\" from=\"230\" to=\"130\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "\n" +
            "<ellipse id=\"C\" cx=\"240\" cy=\"300\" rx=\"120\" ry=\"60\" fill=\"rgb(0,255,0)\" visibility=\"hidden\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"600ms\" dur=\"1400ms\" attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"600ms\" dur=\"1400ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"600ms\" dur=\"1400ms\" attributeName=\"cy\" from=\"0\" to=\"0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2000ms\" dur=\"3000ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2000ms\" dur=\"3000ms\" attributeName=\"cy\" from=\"0\" to=\"180\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2000ms\" dur=\"3000ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2000ms\" dur=\"3000ms\" attributeName=\"cy\" from=\"0\" to=\"180\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"2000ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"2000ms\" attributeName=\"cy\" from=\"180\" to=\"300\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"2000ms\" attributeName=\"fill\" from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"2000ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"5000ms\" dur=\"2000ms\" attributeName=\"cy\" from=\"180\" to=\"300\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"1000ms\" attributeName=\"fill\" from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"1000ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"7000ms\" dur=\"1000ms\" attributeName=\"cy\" from=\"300\" to=\"300\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8000ms\" dur=\"2000ms\" attributeName=\"cx\" from=\"240\" to=\"240\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"8000ms\" dur=\"2000ms\" attributeName=\"cy\" from=\"300\" to=\"300\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>hello", viewLog.toString());
}

  }


