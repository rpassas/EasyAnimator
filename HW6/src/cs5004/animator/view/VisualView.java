package cs5004.animator.view;

import javax.swing.JFrame;
import java.awt.Dimension;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.Point2D;


public class VisualView extends JFrame implements IView{
  private AnimationModelImpl model;
  private CanvasPanel mainPanel;
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
    this.mainPanel = new CanvasPanel(point,
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

  @Override
  public void setUpdateShapes(int currentTick) {
    this.mainPanel.setAnimatedShapes(model);
  }

  @Override
  public ViewType getViewType() {
    return ViewType.VISUAL;
  }
}