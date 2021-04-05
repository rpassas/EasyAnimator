package cs5004.AnimationModel;

import java.util.LinkedList;

/**
 * This interface contains all operations that all types of shapes
 * should support.
 */

public interface AnimationModel {

  /**
   * Gets all the shapes in the model.
   * @return list of shapes in the model
   */
  LinkedList<AbstractShape> getShapes();

  /**
   * Gets all the changes altering the shapes in the model.
   * @return list of changes in the model
   */
  LinkedList<AbstractChange> getChanges();

  /**
   * Adds a shape to to the model
   * @param shape the shape to be added to the model (list of shapes).
   * @throws IllegalArgumentException if the given shape does not have proper type.
   */
  void addShape(AbstractShape shape);

  /**
   * Given a shape, will remove that shape.
   * @param shape shape to be removed
   */
  void removeShape(AbstractShape shape);
  //TODO documentation should reflect error throws
  /**
   * Moves a shape over a time interval by creating copies, deleting the previous shape,
   * and mapping time ticks to coordinates as they shape "moves."
   * @param shape shape to be moved
   * @param x integer indicating starting x coordinate
   * @param y integer indicating starting y coordinate
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   * @throws IllegalArgumentException for negative time
   * @throws IllegalArgumentException for conflicting changes
   * @throws IllegalArgumentException for reverse time
   */
  void addMove(AbstractShape shape, int x, int y, int t1, int t2);

  /**
   * Takes a shape, changes color according to time, then removes the shape.
   * @param shape shape to be recolored
   * @param r red value 0 - 255
   * @param g green value 0 - 255
   * @param b blue value 0 - 255
   * @param t1 integer indicating start time
   * @param t2 integer indicating end time
   * @throws IllegalArgumentException for negative time
   * @throws IllegalArgumentException for conflicting changes
   * @throws IllegalArgumentException for reverse time
   * @throws IllegalArgumentException for negative colors
   * @throws IllegalArgumentException for out of bounds colors
   */
  void addRecolor(AbstractShape shape, int r, int g, int b, int a, int t1, int t2);

  /**
   * Takes a shape and resizes it over time.
   * @param shape to be resized
   * @param h new height
   * @param w new width
   * @param t1 start time
   * @param t2 end time
   * @throws IllegalArgumentException for negative time
   * @throws IllegalArgumentException for conflicting changes
   * @throws IllegalArgumentException for reverse time
   * @throws IllegalArgumentException for non-positive dimensions
   */
  void addResize(AbstractShape shape, int h, int w, int t1, int t2);

  /**
   * Takes in a time interval and returns the shapes at that point.
   *
   * @param tick the time interval to get the shapes at.
   * @return the shapes that are created at that time interval.
   */
  AnimationModel getShapesAtTick(int tick);

  /**
   * Generates a description of the model's shapes and changes to those shapes.
   * @return string describing the model
   */
  String toString();
}
