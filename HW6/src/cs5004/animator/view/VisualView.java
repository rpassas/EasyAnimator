package cs5004.animator.view;

import javax.swing.JFrame;
import java.awt.Dimension;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.Point2D;


public class VisualView extends JFrame implements IView{
  private AnimationModel model;
  private CanvasPanel mainPanel;
  private int speed;

  //TODO speed must be > 0
  VisualView(AnimationModel model, int speed) {
    super();
    this.model = model;
    this.speed = speed;
    this.setTitle("EZ Animator");
    this.setPreferredSize(new Dimension(model.getCanvas().getWidth(),
        model.getCanvas().getHeight()));
    Point2D point = new Point2D(model.getCanvas().getX(), model.getCanvas().getY());
    this.mainPanel = new CanvasPanel(point,
        new Dimension(model.getCanvas().getWidth(), model.getCanvas().getHeight()));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {
    this.speed = speed;
  }

  @Override
  public void run() {
    this.setVisible(true);
  }

  @Override
  public void setUpdateShapes(int currentTick) {
    this.mainPanel.setAnimatedShapes(model.getShapesAtTick(currentTick));
    // every child component calls paintComponent as a result
    this.repaint();
  }

  @Override
  public ViewType getViewType() {
    return ViewType.VISUAL;
  }
}