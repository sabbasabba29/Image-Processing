package controller;

import model.IImageModel3;

/**
 * Represents a 2nd Image Processing Controller implementation, with filtering and
 * color transformations.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Wednesday, November 09, 2022 6:40 PM Eastern Time
 */
public class ImageControllerImpl2 extends ImageControllerImpl {


  /**
   * Creates a controller implementation.
   *
   * @param model       the image processing model to use
   * @param inputStream the readable to take inputs from
   */
  public ImageControllerImpl2(IImageModel3 model, Readable inputStream, Appendable outputStream) {
    super(model, inputStream, outputStream);
  }

  /**
   * Runs a command, given it and its arguments together as a String.
   *
   * @param command the command and its arguments as a String
   */
  @Override
  public void runCommand(String command) {
    try {
      switch (this.getCommandSubstring(command, 0)) {
        case "blur":
          this.model.blur(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2));
          break;
        case "sharpen":
          this.model.sharpen(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2));
          break;
        case "greyscale":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2));
          break;
        case "sepia":
          this.model.sepia(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2));
          break;
        default:
          super.runCommand(command);
      }
    } catch (IllegalArgumentException e) {
      super.outputSwitchError(e.getMessage());
    }
  }
}
