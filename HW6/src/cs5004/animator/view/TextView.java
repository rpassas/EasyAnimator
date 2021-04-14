package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.AnimationModelImpl;

public class TextView implements IView{
  AnimationModelImpl model;
  String filename;
  File file;
  FileWriter writer;

  public TextView(AnimationModelImpl model, String filename) {
    this.model = new AnimationModelImpl();
    this.filename = filename;
  }

  @Override
  public void run() throws IOException {
    // Could add an if statement to see if file exists, if it does open it and write to it
    try {
      this.file = new File(this.filename);
      file.createNewFile();
      this.writer = new FileWriter(file);
      writer.write(model.toString());
    } catch (IOException e) {
      System.out.println("Error with the file writer.");
    }
    finally {
      if (writer != null) {
        writer.close();
      }
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
