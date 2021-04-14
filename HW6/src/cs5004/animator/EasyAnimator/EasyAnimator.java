package cs5004.animator.EasyAnimator;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ViewMaker;
import cs5004.animator.view.ViewType;
import cs5004.animator.view.IView;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EasyAnimator {

  public static void main(String[] args) {
    // placeholder view parameters
    String fileNameIn = "";
    ViewType viewType = null;
    String fileNameOut = "";
    int speed = 1;

    // parse commandline
    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) == '-') {
        switch (args[i]) {
          case "-in":
            i++;
            fileNameIn = args[i];
            break;
          case "-view":
            i++;
            viewType = ViewType.getType(args[i]);
            break;
          case "-out":
            i++;
            fileNameOut = args[i];
            break;
          case "-speed":
            i++;
            speed = Integer.parseInt(args[i]);
            break;
          default:
            JFrame badArgs = new JFrame();
            JOptionPane.showMessageDialog(badArgs, "Warning",
                "Precede arguments with -speed, -out, -in, or -view.",
                JOptionPane.WARNING_MESSAGE);
        }
      }
    }

    if (fileNameIn.equals("") || fileNameOut.equals("")) {
      JFrame noFiles = new JFrame();
      JOptionPane.showMessageDialog(noFiles, "Warning",
          "Both file names must be provided.", JOptionPane.WARNING_MESSAGE);
    } else if (viewType == null) {
      JFrame noType = new JFrame();
      JOptionPane.showMessageDialog(noType, "Warning",
          "A view type must be provided.", JOptionPane.WARNING_MESSAGE);
    } else if (speed <= 0) {
      JFrame badSpeed = new JFrame();
      JOptionPane.showMessageDialog(badSpeed, "Warning",
          "Provided speed must be positive.", JOptionPane.WARNING_MESSAGE);
    }
    try {
      FileReader fileIn = new FileReader(fileNameIn);
      AnimationModelImpl model = AnimationReader.parseFile(fileIn,
          new AnimationModelImpl.Builder());
      IView view = ViewMaker.makeView(viewType, model, fileNameOut, speed);
      view.run();
      //TODO: controller
    } catch (IOException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      JFrame noFiles = new JFrame();
      JOptionPane.showMessageDialog(noFiles, "Warning",
          e.toString(),
          JOptionPane.WARNING_MESSAGE);
    }

  }
}
