package cs5004.animator.model;

/**
 * Class representing the canvass of the model.
 */
public class Canvas {
  int width;
  int height;
  int x;
  int y;

  /**
   * Constructor for the canvass class.
   */
  public Canvas() {
    this.width = 0;
    this.height = 0;
  }

  /**
   * Method to get the width of canvass.
   * @return the width of the canvass.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Method to set the width of the canvass.
   * @param width the width to set the canvass at.
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Method to get the height of canvass.
   * @return the height of the canvass.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Method to set the height of the canvass.
   * @param height the height to set the canvass at.
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Method to get the X of canvass.
   * @return the X of the canvass.
   */
  public int getX() {
    return x;
  }

  /**
   * Method to set the X of the canvass.
   * @param x the X to set the canvass at.
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Method to get the Y of canvass.
   * @return the Y of the canvass.
   */
  public int getY() {
    return y;
  }

  /**
   * Method to set the Y of the canvass.
   * @param y the Y to set the canvass at.
   */
  public void setY(int y) {
    this.y = y;
  }
}
