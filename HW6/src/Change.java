public interface Change {
  /**
   * Method to get the updatedHeight value of the current shape.
   * @return the updatedHeight value of the current shape.
   */
  int getUpdatedHeight();

  /**
   * Method to set the updatedHeight value of the current shape.
   * @param updatedHeight the updatedHeight value that it will be set to.
   */
  void setUpdatedHeight(int updatedHeight);

  /**
   * Method to get the updatedWidth value of the current shape.
   * @return the updatedWidth value of the current shape.
   */
  int getUpdatedWidth();

  /**
   * Method to set the updatedWidth value of the current shape.
   * @param updatedWidth the updatedWidth value that it will be set to.
   */
  void setUpdatedWidth(int updatedWidth);

  /**
   * Method to get the updatedR value of RGB of the current shape.
   * @return the updatedR value of the current shape.
   */
  int getUpdatedR();

  /**
   * Method to set the updatedR value of the current shape.
   * @param updatedR the updatedR value that it will be set to.
   */
  void setUpdatedR(int updatedR);

  /**
   * Method to get the updated G value of RGB of the current shape.
   * @return the G value of the current shape.
   */
  int getUpdatedG();

  /**
   * Method to set the updated G value of the current shape.
   * @param updatedG the updatedG value that it will be set to.
   */
  void setUpdatedG(int updatedG);

  /**
   * Method to get the updatedB value of RGB of the current shape.
   * @return the updatedB of the current shape.
   */
  int getUpdatedB();

  /**
   * Method to set the updated B value of the current shape.
   * @param updatedB the updatedB value that it will be set to.
   */
  void setUpdatedB(int updatedB);

  /**
   * Method to get the updatedA value of the current shape.
   * @return the updatedA of the current shape.
   */
  int getUpdatedA();

  /**
   * Method to set the updatedA value of the current shape.
   * @param updatedA the updatedA value that it will be set to.
   */
  void setUpdatedA(int updatedA);

  /**
   * Method to get the reference value of the current shape.
   * @return the reference of the current shape.
   */
  Point2D getReference();

  /**
   * Method to set the reference value of the current shape.
   * @param reference the reference value that it will be set to.
   */
  void setReference(Point2D reference);

  /**
   * Method to get the startTime value of the current shape.
   * @return the startTime of the current shape.
   */
  int getStartTime();

  /**
   * Method to set the startTime value of the current shape.
   * @param startTime the startTime value that it will be set to.
   */
  void setStartTime(int startTime);

  /**
   * Method to get the endTime value of the current shape.
   * @return the endTime of the current shape.
   */
  int getEndTime();

  /**
   * Method to set the endTime value of the current shape.
   * @param endTime the endTime value that it will be set to.
   */
  void setEndTime(int endTime);

  /**
   * Get the shape's ID for a change.
   * @return int indicating shape ID
   */
  int getShapeID();

  /**
   * Set the shape's ID for a change.
   * @param shapeID is an int indicating a new ID.
   */
  void setShapeID(int shapeID);

  /**
   * Get the shape's label for a change.
   * @return int indicating shape label
   */
  String getShapeLabel();

  /**
   * Set the shape's label for a change.
   * @param shapeLabel is an int indicating a new label.
   */
  void setShapeLabel(String shapeLabel);

  /**
   * Generates a string describing the change.
   * @return string giving details of the change
   */
  String toString();
}
