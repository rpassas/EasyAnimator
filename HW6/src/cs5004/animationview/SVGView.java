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

public class SVGView implements IView {
  AnimationModelImpl model;
  AnimationBuilder input;
  String filename;
  int speed;
  File file;
  FileWriter writer;

  public SVGView(AnimationModelImpl model, String filename, int speed) throws IOException {
    this.model = new AnimationModelImpl();
    this.filename = filename;
    this.speed = speed;
    this.file = new File(this.filename);;
    file.createNewFile();
    this.writer = new FileWriter(file);

  }

  // TODO add in IO exception/trycatch handling like in the last lab

  public void createCanvas() throws IOException {
    writer.write("<svg width=\"" + model.getCanvas().getWidth() + "\" height=\"" + model.getCanvas().getHeight() + "\" version=\"1.1\" \n" +
            "xmls=\"http://www.w3.org/2000/svg\">"); //Not sure if this line is right
  }

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


  @Override
  public void run() throws IOException {
    createCanvas();
    createShapes(model.getShapes(), speed);
  }

  @Override
  public ViewType getType() {
    return ViewType.SVG;
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {

  }
}
