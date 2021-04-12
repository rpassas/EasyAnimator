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

  public void createCanvas() {
    System.out.printf("<svg width=\"%d\" height=\"%d\" version=\"1.1\" \n" +
            "xmls=\"http://www.w3.org/2000/svg\">", //Not sure if this line is right
            model.getCanvas().getWidth(), model.getCanvas().getHeight());
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
            System.out.printf("  <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" attributeName\"cx\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
                    change.getStartTime() * 1000 / this.speed, (change.getEndTime() - change.getStartTime()) * 1000 / this.speed, change.getStartReference().getX(), change.getReference().getX());
            System.out.printf("  <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" attributeName\"cy\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
                    change.getStartTime() * 1000 / this.speed, (change.getEndTime() - change.getStartTime()) * 1000 / this.speed, change.getStartReference().getY(), change.getReference().getY());
          } else if (change.getType().equals(AvailableChanges.RESIZE)) {
            System.out.printf("  <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" attributeName\"rx\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
                    change.getStartTime() * 1000 / this.speed, (change.getEndTime() - change.getStartTime()) * 1000 / this.speed, change.getStartWidth(), change.getUpdatedWidth());
            System.out.printf("  <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" attributeName\"ry\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
                    change.getStartTime() * 1000 / this.speed, (change.getEndTime() - change.getStartTime()) * 1000 / this.speed, change.getStartHeight(), change.getUpdatedHeight());
          } else if (change.getType().equals(AvailableChanges.RECOLOR)) {
            //Not sure if this recolor will work but should be close, doublecheck attributName/type
            System.out.printf("  <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" attributeName\"fill\" from=\"rgb(%d,%d,%d)\" to=\"rgb(%d,%d,%d)\" fill=\"freeze\" />\n",
                    change.getStartTime() * 1000 / this.speed, (change.getEndTime() - change.getStartTime()) * 1000 / this.speed,
                    change.getStartR(), change.getStartG(), change.getStartB(), change.getUpdatedR(), change.getUpdatedG(), change.getUpdatedB());
          }
        }
      }
      if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
        System.out.print("</rect>\n");
      } else if (shape.getType().equals(AvailableShapes.OVAL)) {
        System.out.print("</ellipse>\n");
      }
      System.out.println("\n");
    }
  }


  @Override
  public void run() {
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
