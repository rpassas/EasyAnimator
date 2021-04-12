package cs5004.animationview;

import cs5004.animationmodel.AbstractChange;
import cs5004.animationmodel.AbstractShape;
import cs5004.animationmodel.AnimationModelImpl;
import cs5004.animationmodel.AvailableChanges;
import cs5004.animationmodel.AvailableShapes;
import cs5004.animator.view.AnimationBuilder;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class SVGView implements IView {
  AnimationModelImpl model = new AnimationModelImpl();
  AnimationBuilder input;
  Appendable output;

  public SVGView(AnimationBuilder input, Appendable output) {
    this.input = input;
    this.output = output;
  }

  public void createCanvass(int width, int height) {
    System.out.printf("<svg width=\"%d\" height=\"%d\" version=\"1.1\" \n" +
            "xmls=\"http://www.w3.org/2000/svg\">", //Not sure if this line is right
            model.getCanvass().getWidth(), model.getCanvass().getHeight());
  }

  public void createShapes(LinkedList<AbstractShape> listOfShapes) {
    for(AbstractShape shape : model.getShapes()) {
      if (shape.getType().equals(AvailableShapes.OVAL)) {
        System.out.printf("<ellipse id=\"%s\" cx=\"%d\" cy=\"%d\" rx=\"%d\" " +
                        "ry=\"%d fill=\"rgb(%d, %d, %d)\" visibility=\"visible\" >\n",
                shape.getLabel(), shape.getLocation().getX(), shape.getLocation().getY(),
                shape.getWidth(), shape.getHeight(), shape.getR(), shape.getG(), shape.getB());
        for(AbstractChange change : model.getChanges()) {
          if (change.getShapeLabel().equals(shape.getLabel())) {
            if (change.getType().equals(AvailableChanges.MOVE)) {
              System.out.printf("  <animate attributeType=\"xml\" begin=\"base.begin+%dms\" dur=\"%dms\" attributeName\"cx\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
                      change.getStartTime() * 1000, (change.getEndTime() - change.getStartTime()) * 1000, change.getStartReference().getX(), change.getReference().getX());
              System.out.printf("  <animate attributeType=\"xml\" begin=\"base.begin+%dms\" dur=\"%dms\" attributeName\"cy\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
                      change.getStartTime() * 1000, (change.getEndTime() - change.getStartTime()) * 1000, change.getStartReference().getY(), change.getReference().getY());
            } else if (change.getType().equals(AvailableChanges.RESIZE)) {

            }
          }
        }
      }
      if (shape.getType().equals(AvailableShapes.RECTANGLE)) {
        if (shape.getType().equals(AvailableShapes.OVAL)) {
          System.out.printf("<rect  id=\"%s\" cx=\"%d\" cy=\"%d\" rx=\"%d\" " +
                          "ry=\"%d fill=\"rgb(%d, %d, %d)\" visibility=\"visible\" >",
                  shape.getLabel(), shape.getLocation().getX(), shape.getLocation().getY(),
                  shape.getWidth(), shape.getHeight(), shape.getR(), shape.getG(), shape.getB());
        }
      }
    }
  }

  @Override
  public void run() {

  }

  @Override
  public ViewType getType() {
    return null;
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {

  }
}
