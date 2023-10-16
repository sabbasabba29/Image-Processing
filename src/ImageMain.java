import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import controller.IImageController;
import controller.ImageControllerImpl3;
import model.EightBitImageModel3;
import model.IImageModel3;

/**
 * Drives the ImageProcessing application using a main method.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 4:36 PM Eastern Time
 */
public class ImageMain {
  /**
   * A main method to run the Image Processing Program.
   *
   * @param args the arguments of the command line
   */
  public static void main(String[] args) {
    IImageModel3 xy;
    Readable read;
    Appendable app;
    IImageController x;

    read = new InputStreamReader(System.in);

    List<String> argsList = new ArrayList<>(Arrays.asList(args));
    try {
      if (argsList.get(0).equals("-file")
              && argsList.get(1).indexOf(".txt") == argsList.get(1).length() - 4) {
        try {
          Scanner sc = new Scanner(new FileInputStream(argsList.get(1)));
          StringBuilder sb = new StringBuilder();
          if (sc.hasNextLine()) {
            sb.append(sc.nextLine());
          }
          while (sc.hasNextLine()) {
            sb.append(System.lineSeparator());
            sb.append(sc.nextLine());
          }

          read = new StringReader(sb.toString());

        } catch (FileNotFoundException e) {
          throw new IllegalArgumentException("File " + argsList.get(1) + " not found!");
        }
      }
    } catch (IndexOutOfBoundsException e) {
      // Do nothing
    }
    xy = new EightBitImageModel3();
    app = System.out;
    x = new ImageControllerImpl3(xy, read, app);
    x.start();
  }
}
