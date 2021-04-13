package cs5004.animationview;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import cs5004.animationmodel.AbstractShape;
import cs5004.animationmodel.Point2D;

public class MainPanel extends JPanel{
  private Point2D reference;


  MainPanel(Point2D reference, Dimension dimension) {
    this.setBackground(Color.WHITE);
    this.setPreferredSize(dimension);
  }

  protected void paint(Graphics g) {
    super.paintComponent(g);
    //process: for shape in model
    // get color components for awt.color
    // generate a graphics2D rect or oval/ellipse (awt.shape)
    // set color/fill
    // or throw illegalstateexception for bad shape
    //for (AbstractShape shape : this.model.getlistOfShapes()) {
    // Color color = new Color(shape.getColor().getRed(), shape.getColor().getGreen(),
    //          shape.getColor().getBlue());
    // if (shape.getType().equals(AvailableShapes.RECT) {}
    // else if (shape.getType().equals(AvailableShapes.OVAL) {}
    // else {throw new IllegalStateException("Must be oval or rect shape.")}
  }
}
