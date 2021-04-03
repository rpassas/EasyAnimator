/**
 * This interface contains all operations that all types of shapes
 * should support.
 */

public interface AnimationModel {

  /**
   * Adds a shape to to the model
   * @param shape the shape to be added to the model (list of shapes).
   * @throws IllegalArgumentException if the given shape does not have proper type.
   */
  void addShape(AbstractShape shape);

  /**
   * Given a shape, will remove that shape.
   * @param shapeIdentifier index of the target shape to be removed
   */
  void remove(int shapeIdentifier);

  /**
   * Moves a shape over a time interval by creating copies, deleting the previous shape,
   * and mapping time ticks to coordinates as they shape "moves."
   * @param shapeIdentifier index of shape to be moved
   * @param x integer indicating starting x coordinate
   * @param y integer indicating starting y coordinate
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   */
  void translate(int shapeIdentifier, int x, int y, int t1, int t2);

  /**
   * Takes a shape, changes color according to time, then removes the shape.
   * @param r red value 0 - 255
   * @param g green value 0 - 255
   * @param b blue value 0 - 255
   * @param shapeIdentifier index of shape to be animated
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   */
  void shader(int shapeIdentifier, int r, int g, int b, int t1, int t2);

  /**
   * Takes a shape and resizes it over time.
   * @param shapeIdentifier index of shape to resize
   * @param h new height
   * @param w new width
   * @param t1 start time
   * @param t2 end time
   */
  void resize(int shapeIdentifier, int h, int w, int t1, int t2);

  /**
   * Takes in a time interval and returns the shapes at that point.
   *
   * @param tick the time interval to get the shapes at.
   * @return the shapes that are created at that time interval.
   */
  AnimationModel getShapesAtTick(int tick);
}
