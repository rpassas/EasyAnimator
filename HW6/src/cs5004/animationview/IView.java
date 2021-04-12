package cs5004.animationview;

import java.io.IOException;

public interface IView {

  /**
   * Has the animation run (outputs vary depending on view type).
   */
  void run() throws IOException;

  /**
   * Get the view's type (one of 3 types - visual, textual, SVG enum).
   * @return The type of view (enum)
   */
  ViewType getType();

  /**
   * Set the speed of the view given a speed (per tick).
   * @param speed updated speed of the view.
   * @throws UnsupportedOperationException if the view type is a TextualView (speed does not impact
   *                                      TextualView output).
   */
  void setSpeed(int speed) throws UnsupportedOperationException;
}
