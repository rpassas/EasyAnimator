package cs5004.animator.view;

import cs5004.animator.model.AbstractChange;
import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AvailableChanges;
import cs5004.animator.model.AvailableShapes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Model that outputs a SVG file.
 */
public class SVGView implements IView {
  AnimationModel model;
  Appendable fileOutput;
  int speed;
  File file;
  FileWriter writer;

  /**
   * Constructor for the SVG model.
   * @param model the animationModelImpl that contains the data.
   * @param fileOutput the name of the file to export to.
   * @param speed the speed of the file playback.
   * @throws IOException if there is an error with the IO.
   */
  public SVGView(AnimationModel model, Appendable fileOutput, int speed) throws IOException {
    this.model = model;
    this.fileOutput = fileOutput;
    this.speed = speed;

  }

  // TODO add in IO exception/trycatch handling like in the last lab

  /**
   * Creates a canvass with the specified dimensions for the SVG.
   * @throws IOException if there is an error with the IO.
   */
  public void createCanvas() throws IOException {
    fileOutput.append("<svg width=\"" + model.getCanvas().getWidth() + "\" height=\""
            + model.getCanvas().getHeight() + "\" version=\"1.1\"" +
            "xmls=\"http://www.w3.org/2000/svg\">\n"); //Not sure if this line is right
    fileOutput.append("\n");
  }

  /**
   * Adds all the shapes to the SVG output file.
   * @param listOfShapes the list of shapes to be added.
   * @param speed the speed at which it plays.
   * @throws IOException if there is an error with the IO.
   */
  public void createShapes(LinkedList<AbstractShape> listOfShapes, int speed) throws IOException {
    for(AbstractShape shape : model.getShapes()) {
      try {
        if (shape.getType().equals(AvailableShapes.OVAL)) {
          fileOutput.append("<ellipse id=\"" + shape.getLabel() + "\" cx=\""
                  + (shape.getLocation().getX() - model.getCanvas().getX()) + "\" cy=\""
                  + (shape.getLocation().getY() - model.getCanvas().getY())
                  + "\" rx=\"" + shape.getWidth() + "\" "
                  + "ry=\"" + shape.getHeight() + " fill=\"rgb(" + shape.getR() + ","
                  + shape.getG() + "," + shape.getB() + ")\" visibility=\"visible\" >\n");
        } else if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
          fileOutput.append("<rect id=\"" + shape.getLabel() + "\" x=\""
                  + (shape.getLocation().getX() - model.getCanvas().getX())
                  + "\" y=\"" + (shape.getLocation().getY() - model.getCanvas().getY())
                  + "\" width=\"" + shape.getWidth() + "\" "
                  + "height=\"" + shape.getHeight() + "\" fill=\"rgb(" + shape.getR() + ","
                  + shape.getG()
                  + "," + shape.getB() + ")\" visibility=\"visible\" >\n");
        }
        for (AbstractChange change : model.getChanges()) {
          if (change.getShapeLabel().equals(shape.getLabel())) {
            if (change.getType().equals(AvailableChanges.MOVE)) { //Porbably need to make one for elipse vs rect
              fileOutput.append("    <animate attributeType=\"xml\" begin=\""
                      + change.getStartTime()
                      * 1000 / this.speed + "ms\" dur=\"" + (change.getEndTime()
                      - change.getStartTime()) * 1000 / this.speed
                      + "ms\" attributeName=\"x\" from=\""
                      + (change.getStartReference().getX() - model.getCanvas().getX()) + "\" to=\""
                      + (change.getReference().getX() - model.getCanvas().getX())
                      + "\" fill=\"freeze\" />\n");
              fileOutput.append("    <animate attributeType=\"xml\" begin=\""
                      + change.getStartTime() * 1000 / this.speed + "ms\" dur=\""
                      + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed
                      + "ms\" attributeName=\"y\" from=\"" + (change.getStartReference().getY()
                      - model.getCanvas().getY())
                      + "\" to=\"" + (change.getReference().getY() - model.getCanvas().getY())
                      + "\" fill=\"freeze\" />\n");
            } else if (change.getType().equals(AvailableChanges.RESIZE)) {
              fileOutput.append("    <animate attributeType=\"xml\" begin=\""
                      + change.getStartTime()
                      * 1000 / this.speed + "ms\" dur=\"" + (change.getEndTime()
                      - change.getStartTime()) * 1000 / this.speed
                      + "ms\" attributeName=\"x\" from=\"" + change.getStartWidth() + "\" to=\""
                      + change.getUpdatedWidth() + "\" fill=\"freeze\" />\n");
              fileOutput.append("    <animate attributeType=\"xml\" begin=\""
                      + change.getStartTime() * 1000 / this.speed + "ms\" dur=\""
                      + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed
                      + "ms\" attributeName=\"y\" from=\"" + change.getStartHeight()
                      + "\" to=\"" + change.getUpdatedHeight() + "\" fill=\"freeze\" />\n");
            } else if (change.getType().equals(AvailableChanges.RECOLOR)) {
              fileOutput.append("    <animate attributeType=\"xml\" begin=\""
                      + change.getStartTime() * 1000 / this.speed + "ms\" dur=\""
                      + (change.getEndTime() - change.getStartTime()) * 1000 / this.speed
                      + "ms\" attributeName=\"fill\" from=\"rgb("
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
          fileOutput.append("</rect>\n");
        } else if (shape.getType().equals(AvailableShapes.OVAL)) {
          fileOutput.append("</ellipse>\n");
        }
        fileOutput.append("\n");
      } catch (IOException e) {
        System.out.println("Error while writing to file");
      }
    }
  }


  /**
   * Runs the SVG file.
   * @throws IOException if there is an error with the IO.
   */
  @Override
  public void run() throws IOException {
    try {
      createCanvas();
      createShapes(model.getShapes(), speed);
      fileOutput.append("</svg>");
    } catch (IOException e) {
      System.out.println("Error with the file writer.");
    }
  }

  @Override
  public void setUpdatedShapes(int currentTick) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("SVG View cannot set updated shapes");
  }

  /**
   * Returns the type of view.
   * @return the type of view.
   */
  @Override
  public ViewType getViewType() {
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
