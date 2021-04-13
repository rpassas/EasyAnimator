package cs5004.animator.view;

import cs5004.animationmodel.AnimationModelImpl;
import cs5004.animationmodel.AvailableShapes;

public class Builder implements AnimationBuilder {
  AnimationModelImpl model;

  @Override
  public Object build() {
    return null;
  }

  @Override
  public AnimationBuilder setBounds(int x, int y, int width, int height) {
    return ;
  }

  @Override
  public AnimationBuilder declareShape(String name, String type) {
    if (type.equalsIgnoreCase("rectangle")){
      model.addShape(AvailableShapes.RECTANGLE, name, 0, 0, 0, 0, 0, 0, 0, 0);
    } else if (type.equalsIgnoreCase("ellipse")) {
      model.addShape(AvailableShapes.OVAL, name, 0, 0, 0, 0, 0, 0, 0, 0);
    } else {
      throw new IllegalArgumentException("Must be a rectangle or ellipse");
    }
  }

  @Override
  public AnimationBuilder addMotion(String name,
                                    int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                                    int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2)
  {
    if (x2 - x1 != 0 || y2 - y1 != 0) {
      model.addMove(model.getshape, x1, y1, x2, y2, t1, t2);
    } else if (w2 - w1 != 0 || h2 - h1 != 0) {
      model.addResize(model.getShape()), w1, h1, w2, h2, t1, t2);
    } else if (r2 - r1 != 0 || g2 - g1 != 0 || b2 - b1 != 0) {
      model.addRecolor(model.getshape(name), r1, g1, b1, 100, r2, g2, b2, 100, t1, t2);
    }
  }
}
