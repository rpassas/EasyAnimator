package cs5004.animationview;

import java.io.IOException;

import cs5004.animationmodel.AnimationModel;
import cs5004.animationmodel.AnimationModelImpl;

/**
 * The main animation class will have to create a view given a user input. The parsed input will
 * determine which type of view to be generated.
 */
public class ViewMaker {

  /**
   * Creates an instance of a view.
   * @param type The type of view to be created
   * @param model The model to be animated
   * @param output The output
   * @param speed The speed of the animation
   * @return A view (depends on which type given)
   * @throws IllegalArgumentException If the given model is null or if the speed is < 0
   */
  static IView makeView(ViewType type, AnimationModelImpl model, String output, int speed)
          throws IllegalArgumentException, IOException {
    if (model == null) {
      throw new IllegalArgumentException("The provided model is null");
    } else if (speed < 1) {
      throw new IllegalArgumentException("The speed must be > 0");
    }

    //TODO figure out outputs for views
    if (type.equals(ViewType.TEXT)) {
      return new TextView(model, output);
    } else if (type.equals(ViewType.SVG)) {
      return new SVGView(model, output, speed);
    } else if (type.equals(ViewType.VISUAL)) {
      return new VisualView(model);
    } else {
      throw new IllegalArgumentException("Type must be an IView (text, svg, visual)");
    }
  }
}
