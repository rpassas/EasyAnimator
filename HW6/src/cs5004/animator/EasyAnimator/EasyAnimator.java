package cs5004.animator.EasyAnimator;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.view.ViewType;

public class EasyAnimator {

  public static void main(String[] args) {
    // parse input
    // if nothing is null/invalid
    // make the model
    // make the controller
    //IView view = ViewMaker.makeView(type, model, outputPath, speed);
    // mush them together and run

    // place holder view parameters
    String FileIn = "";
    ViewType viewType = null;
    String FileOut = "";
    int speed = 1;

    // parse commandline
    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) == '-') {
        switch (args[i]) {
          case "-in":
            i++;
            FileIn = args[i];
            break;
          case "-view":
            i++;
            viewType = ViewType.getType(args[i]);
            break;
          case "-out":
            i++;
            FileOut = args[i];
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


    if (FileIn.equals("") || FileOut.equals("")) {
      throw new IllegalArgumentException("Both file names must be provided");
    } else if (viewType == null) {
      throw new IllegalArgumentException("A type of view must be provided");
    } else if (speed <= 0) {
      throw new IllegalArgumentException("Provided speed must be positive");
    }


    AnimationModelImpl empty = new AnimationModelImpl();
    AnimationModelImpl builder = build();
    AnimationModelImpl model = parseFile(FileIn, builder);

  }

}
