package cs5004.animationview;

import cs5004.animationmodel.AnimationModelImpl;
import cs5004.animator.view.AnimationBuilder;
import cs5004.animator.view.AnimationReader;

public class TextView implements IView{
  AnimationModelImpl model = new AnimationModelImpl();
  AnimationBuilder input;

  public TextView(AnimationBuilder input) {
    this.input = input;
  }

  @Override
  public void run() {
    model.toString();
  }

  @Override
  public ViewType getType() {
    return ViewType.TEXT;
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {

  }
}
