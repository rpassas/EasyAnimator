package cs5004.animationview;

import javax.swing.JFrame;
import java.awt.Dimension;

import cs5004.animationmodel.AnimationModelImpl;
import cs5004.animationmodel.Point2D;
import cs5004.animationmodel.AvailableShapes;


public class VisualView extends JFrame implements IView{
  private AnimationModelImpl model;
  private MainPanel mainPanel;
  private int speed;

  //TODO speed must be > 0
  VisualView(AnimationModelImpl model, int speed) {
    super();
    this.model = model;
    this.speed = speed;
    this.setTitle("EZ Animator");
    this.setSize(model.getCanvas().getX() + model.getCanvas().getWidth(),
        model.getCanvas().getY() + model.getCanvas().getHeight());
    Point2D point = new Point2D(model.getCanvas().getX(), model.getCanvas().getY());
    this.mainPanel = new MainPanel(point,
        new Dimension(model.getCanvas().getWidth(), model.getCanvas().getHeight()));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {
    this.speed = speed;
  }

  public void run() {
    this.setVisible(true);
  }

  public ViewType getViewType() {
    return ViewType.VISUAL;
  }
}