/**
 * This interface contains all operations that all types of shapes
 * should support.
 */

public interface IShape {

  //TODO we may need a create and a draw function, with one creating an object the other
  // drawing it for the viewer (maybe thats for the controller to do?)
  //TODO may need a version with colors - not sure how to handle colors yet
  /**
   * Creates a shape given coordinates and dimensions.
   * @param x the x coordinate of the shape's position
   * @param y the y coordinate of the shape's position
   * @param h the height of the shape
   * @param w the width of the shape
   * @return the shape to be drawn
   */
  IShape create(int x, int y, int h, int w);

  /**
   * Given a shape, will remove that shape.
   * @param shape the target shape to be removed
   */
  void remove(IShape shape);


  /**
   * Moves a shape over a time interval by creating copies, deleting the previous shape,
   * and mapping time ticks to coordinates as they shape "moves."
   * @param shape shape to be moved
   * @param x1 integer indicating starting x coordinate
   * @param y1 integer indicating starting y coordinate
   * @param x2 integer indicating ending x coordinate
   * @param y2 integer indicating ending y coordinate
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   */
  void move(IShape shape, int x1, int y1, int x2, int y2, int t1, int t2);

  /**
   * Takes a shape, changes opacity according to time, then removes the shape. Acts as
   * a appear/disappear function.
   * @param shape shape to be animated
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   */
  void flash(IShape shape, int t1, int t2);

  //TODO this method needs a version where you put a color enum instead
  /**
   * Takes a shape, changes color according to time, then removes the shape.
   * @param r red value 0 - 255
   * @param g green value 0 - 255
   * @param b blue value 0 - 255
   * @param shape shape to be animated
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   */
  void shader(IShape shape, int r, int g, int b, int t1, int t2);

  /**
   * Takes a shape and resizes it over time.
   * @param shape shape to resize
   * @param h new height
   * @param w new width
   * @param t1 start time
   * @param t2 end time
   */
  IShape resize(IShape shape, int h, int w, int t1, int t2);

  /**
   * Takes in a time interval and returns the shapes at that point.
   *
   * @param tick the time interval to get the shapes at.
   * @return the shapes that are created at that time interval.
   */
  IShape getShapesAtTick(int tick);

  /**
   * Returns the distance of this shape from the origin. The distance is
   * measured from whatever reference position a shape is (e.g. a center for
   * a circle)
   * @return the distance from the origin
   */
  double distanceFromOrigin(); //Probably can delete this one
  /**
   * Computes and returns the area of this shape.
   * @return the area of the shape
   */
  double area();

  /**
   * Computes and returns the perimeter of this shape.
   * @return the perimeter of the shape
   */
  double perimeter();

  /**
   * Create and return a shape of the same kind as this one, resized
   * in area by the provided factor
   * @param factor factor of resizing
   * @return the resized Shape
   */
  IShape resize(double factor);
}
