package cs5004.animator.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.Point2D;
import javax.swing.Timer;


public class VisualView extends JFrame implements IView{
  private AnimationModel model;
  private CanvasPanel mainPanel;
  private int speed;
  private Timer timer;

  //TODO speed must be > 0
  VisualView(AnimationModel model, int speed) {
    super();
    this.model = model;
    this.speed = speed;
    this.setTitle("EZ Animator");
    this.setPreferredSize(new Dimension(model.getCanvas().getWidth(),
        model.getCanvas().getHeight()));
    System.out.println(new Dimension(model.getCanvas().getWidth(),
        model.getCanvas().getHeight()));
    Point2D point = new Point2D(model.getCanvas().getX(), model.getCanvas().getY());
    this.mainPanel = new CanvasPanel(point,
        new Dimension(model.getCanvas().getWidth(), model.getCanvas().getHeight()));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.timer = new Timer(1000 / speed, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        repaint();
      }
    });
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {
    this.speed = speed;
  }

  @Override
  public void run() {
    this.setVisible(true);
    this.timer.start();
  }

  @Override
  public void setUpdatedShapes(int currentTick) {
    this.mainPanel.setAnimatedShapes(model.getShapesAtTick(currentTick));
    // every child component calls paintComponent as a result
    this.repaint();
  }

  @Override
  public ViewType getViewType() {
    return ViewType.VISUAL;
  }
}