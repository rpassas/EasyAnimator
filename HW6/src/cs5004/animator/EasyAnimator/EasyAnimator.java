package cs5004.animator.EasyAnimator;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ViewMaker;
import cs5004.animator.view.ViewType;
import cs5004.animator.view.IView;
import java.io.FileReader;
import java.io.IOException;

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
            throw new IllegalArgumentException("Bad argument; try -in, -view, -out, -speed");
        }
      }
    }

    if (fileNameIn.equals("") || fileNameOut.equals("")) {
      throw new IllegalArgumentException("Both file names must be provided");
    } else if (viewType == null) {
      throw new IllegalArgumentException("A type of view must be provided");
    } else if (speed <= 0) {
      throw new IllegalArgumentException("Provided speed must be positive");
    }
    try {
      FileReader fileIn = new FileReader(fileNameIn);
      AnimationModelImpl model = AnimationReader.parseFile(fileIn,
          new AnimationModelImpl.Builder());
      IView view = ViewMaker.makeView(viewType, model, fileNameOut, speed);
      view.run();
      //TODO controller
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
