package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;

public class TextView implements IView{
  AnimationModel model;
  Appendable fileOutput;
  File file;
  FileWriter writer;

  public TextView(AnimationModel model, Appendable fileOutput) {
    this.model = model;
    this.fileOutput = fileOutput;
  }

  @Override
  public void run() throws IOException {
    // Could add an if statement to see if file exists, if it does open it and write to it
    try {

      fileOutput.append(model.toString());
    } catch (IOException e) {
      System.out.println("Error with the file writer.");
    }
  }

  @Override
  public void setUpdateShapes(int currentTick) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("SVG View cannot set updated shapes");
  }

  @Override
  public ViewType getViewType() {
    return ViewType.TEXT;
  }

  @Override
  public void setSpeed(int speed) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("SVG View cannot set speed");
  }
}
