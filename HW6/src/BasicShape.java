/**
 * This interface contains all operations that all types of shapes
 * should support.
 */
public interface BasicShape {

  /**
   * Method to get the height of the current shape.
   * @return the height of the current shape.
   */
   double getHeight();

  /**
   * Method to get the width of the current shape.
   * @return the width of the current shape.
   */
   double getWidth();

  /**
   * Method to get the R value of RGB of the current shape.
   * @return the R value of the current shape.
   */
   int getR();

  /**
   * Method to get the G value of RGB of the current shape.
   * @return the G value of the current shape.
   */
   int getG();

  /**
   * Method to get the B value of RGB of the current shape.
   * @return the B value of the current shape.
   */
   int getB();

  /**
   * Method to get the opacity value of RGB of the current shape.
   * @return the opacity value of the current shape.
   */
   int getOpacity();

  /**
   * Method to set the height of the current shape.
   * @param height the height that it will be set to.
   */
   void setHeight(double height);

  /**
   * Method to set the width of the current shape.
   * @param width the width that it will be set to.
   */
   void setWidth(double width);

  /**
   * Method to set the R value of the current shape.
   * @param r the r value that it will be set to.
   */
   void setR(int r);

  /**
   * Method to set the G value of the current shape.
   * @param g the g value that it will be set to.
   */
   void setG(int g);

  /**
   * Method to set the B value of the current shape.
   * @param b the b value that it will be set to.
   */
   void setB(int b);

  /**
   * Method to set the opacity value of the current shape.
   * @param opacity the opacity value that it will be set to.
   */
   void setOpacity(int opacity);
}

