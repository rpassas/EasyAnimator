package cs5004.animationview;

import cs5004.animationmodel.AbstractChange;
import cs5004.animationmodel.AbstractShape;
import cs5004.animationmodel.AnimationModelImpl;
import cs5004.animationmodel.AvailableChanges;
import cs5004.animationmodel.AvailableShapes;
import cs5004.animator.view.AnimationBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Model that outputs a SVG file.
 */
public class SVGView implements IView {
  AnimationModelImpl model;
  String filename;
  int speed;
  File file;
  FileWriter writer;

  /**
   * Constructor for the SVG model.
   * @param model the animationModelImpl that contains the data.
   * @param filename the name of the file to export to.
   * @param speed the speed of the file playback.
   * @throws IOException if there is an error with the IO.
   */
  public SVGView(AnimationModelImpl model, String filename, int speed) throws IOException {
    this.model = new AnimationModelImpl();
    this.filename = filename;
    this.speed = speed;
    this.file = new File(this.filename);;
    file.createNewFile();
    this.writer = new FileWriter(file);

  }

  // TODO add in IO exception/trycatch handling like in the last lab

  /**
   * Creates a canvass with the specified dimensions for the SVG.
   * @throws IOException if there is an error with the IO.
   */
  public void createCanvas() throws IOException {
    writer.write("<svg width=\"" + model.getCanvas().getWidth() + "\" height=\"" + model.getCanvas().getHeight() + "\" version=\"1.1\" \n" +
            "xmls=\"http://www.w3.org/2000/svg\">"); //Not sure if this line is right
  }

  /**
   * Adds all the shapes to the SVG output file.
   * @param listOfShapes the list of shapes to be added.
   * @param speed the speed at which it plays.
   * @throws IOException if there is an error with the IO.
   */
  public void createShapes(LinkedList<AbstractShape> listOfShapes, int speed) throws IOException {
    for(AbstractShape shape : model.getShapes()) {
      if (shape.getType().equals(AvailableShapes.OVAL)) {
        writer.write("<ellipse id=\"" + shape.getLabel() + "\" cx=\"" + shape.getLocation().getX() + "\" cy=\"" + shape.getLocation().getY() + "\" rx=\"" + shape.getWidth() + "\" " +
                        "ry=\"" + shape.getHeight() + " fill=\"rgb(" + shape.getR() + ", " + shape.getG() + ", " + shape.getB() + ")\" visibility=\"visible\" >\n");
      } else if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
        writer.write("<rect id=\"" + shape.getLabel() + "\" cx=\"" + shape.getLocation().getX() + "\" cy=\"" + shape.getLocation().getY() + "\" rx=\"" + shape.getWidth() + "\" " +
                "ry=\"" + shape.getHeight() + " fill=\"rgb(" + shape.getR() + ", " + shape.getG() + ", " + shape.getB() + ")\" visibility=\"visible\" >\n");
        }
      for(AbstractChange change : model.getChanges()) {
        if (change.getShapeLabel().equals(shape.getLabel())) {
          if (change.getType().equals(AvailableChanges.MOVE)) {
            writer.write("  <animate attributeType=\"xml\" begin=\"" + change.getStartTime()
                            * 1000 / this.speed + "ms\" dur=\"" + (change.getEndTime()
                            - change.getStartTime()) * 1000 / this.speed + "ms\" attributeName\"cx\" from=\""
                    + change.getStartReference().getX() + "\" to=\"" + change.getReference().getX() +"\" fill=\"freeze\" />\n");
            writer.write("  <animate attributeType=\"xml\" begin=\"" + change.getStartTime() * 1000 / this.speed + "ms\" dur=\""
                            + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed + "ms\" attributeName\"cy\" from=\""
                            + change.getStartReference().getY() + "\" to=\"" + change.getReference().getY() + "\" fill=\"freeze\" />\n");
          } else if (change.getType().equals(AvailableChanges.RESIZE)) {
            writer.write("  <animate attributeType=\"xml\" begin=\"" + change.getStartTime() * 1000 / this.speed
                            + "ms\" dur=\"" + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed + "ms\" attributeName\"rx\" from=\""
                            + change.getStartWidth() + "\" to=\"" + change.getUpdatedWidth() + "\" fill=\"freeze\" />\n");
            writer.write("  <animate attributeType=\"xml\" begin=\""
                            + change.getStartTime() * 1000 / this.speed + "ms\" dur=\""
                            + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed
                            + "ms\" attributeName\"ry\" from=\"" + change.getStartHeight()
                            + "\" to=\"" + change.getUpdatedHeight() + "\" fill=\"freeze\" />\n");
          } else if (change.getType().equals(AvailableChanges.RECOLOR)) {
            //Not sure if this recolor will work but should be close, doublecheck attributName/type
            writer.write("  <animate attributeType=\"xml\" begin=\""
                            + change.getStartTime() * 1000 / this.speed + "ms\" dur=\""
                            + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed
                            + "ms\" attributeName\"fill\" from=\"rgb("
                            + change.getStartR() + ","
                            + change.getStartG() + ","
                            + change.getStartB() + ")\" to=\"rgb("
                            + change.getUpdatedR() + ","
                            + change.getUpdatedG() + ","
                            + change.getUpdatedB() + ")\" fill=\"freeze\" />\n");
          }
        }
      }
      if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
        writer.write("</rect>\n");
      } else if (shape.getType().equals(AvailableShapes.OVAL)) {
        writer.write("</ellipse>\n");
      }
      writer.write("\n");
    }
  }


  /**
   * Runs the SVG file.
   * @throws IOException if there is an error with the IO.
   */
  @Override
  public void run() throws IOException {
    createCanvas();
    createShapes(model.getShapes(), speed);
  }

  /**
   * Returns the type of view.
   * @return the type of view.
   */
  @Override
  public ViewType getType() {
    return ViewType.SVG;
  }

  /**
   * Sets the speed of the view.
   * @param speed updated speed of the view.
   * @throws UnsupportedOperationException if its not supported.
   */
  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {
    this.speed = speed;
  }
}
