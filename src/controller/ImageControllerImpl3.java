package controller;

import model.IImageModel3;

/**
 * The following controller is designed to resize an image
 */
public class ImageControllerImpl3 extends ImageControllerImpl2{

  /**
   * Creates a controller implementation.
   *
   * @param model       the image processing model to use
   * @param inputStream the readable to take inputs from
   */
  public ImageControllerImpl3(IImageModel3 model, Readable inputStream, Appendable outputStream) {
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
        case "resize":
          this.model.resize(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  Integer.parseInt(this.getCommandSubstring(command, 3)),
                  Integer.parseInt(this.getCommandSubstring(command, 4)));
          break;
        default:
          super.runCommand(command);
      }
    } catch (IllegalArgumentException e) {
      super.outputSwitchError(e.getMessage());
    }
  }
}
