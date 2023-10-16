package controller;

import java.io.IOException;
import java.util.Scanner;

import model.IImageModel3;
import model.PixelComponent;

/**
 * Represents an Image Processing Controller implementation.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 6:37 PM Eastern Time
 */
public class ImageControllerImpl implements IImageController {
  protected final IImageModel3 model;

  protected final Readable inputStream;

  protected final Appendable outputStream;

  /**
   * Creates a controller implementation.
   *
   * @param model       the image processing model to use
   * @param inputStream the readable to take inputs from
   */
  public ImageControllerImpl(IImageModel3 model, Readable inputStream, Appendable outputStream) {
    // The following is covering the case if either the model or readable are null, it will throw
    // an IllegalArgumentException as a result.
    if (model == null) {
      throw new IllegalArgumentException("Model is null");
    } else if (inputStream == null) {
      throw new IllegalArgumentException("Input stream is null");
    } else if (outputStream == null) {
      throw new IllegalArgumentException("Output stream is null");
    }
    // The following initializes the fields
    this.model = model;
    this.inputStream = inputStream;
    this.outputStream = outputStream;
  }

  /**
   * Starts the image processing program.
   *
   * @throws IllegalStateException if the Controller is unable to successfully read
   *                               input or transmit output
   */
  @Override
  public void start() {
    try {
      this.outputStream.append("Welcome to the Image Processor.").append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    try {
      this.outputStream.append("Please enter commands below.").append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    Scanner sc = new Scanner(this.inputStream);

    while (true) {
      if (sc.hasNextLine()) {
        String str = sc.nextLine();
        try {
          if (str.trim().equalsIgnoreCase("q")) {
            this.outputStream.append("Program quit!").append(System.lineSeparator());
            break;
          } else if (!str.startsWith("#") && !str.trim().equalsIgnoreCase("")) {
            this.runCommand(str);
          }
        } catch (IOException e) {
          throw new IllegalStateException(e.getMessage());
        }
      }
    }
  }

  /**
   * Returns the nth substring of a given command as a String separated by spaces.
   *
   * @param s the command as a String
   * @param n the number substring to return
   * @return the nth substring
   */
  public String getCommandSubstring(String s, int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Position n of substring "
              + "must be greater than or equal to 0");
    }
    try {
      String[] arr = s.split(" ");
      return arr[n];
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Position n of substring does not exist");
    }
  }

  /**
   * Runs a command, given it and its arguments together as a String.
   *
   * @param command the command and its arguments as a String
   */
  public void runCommand(String command) {
    try {
      switch (this.getCommandSubstring(command, 0)) {
        case "load":
          this.model.load(this.getCommandSubstring(command, 2),
                  this.getCommandSubstring(command, 1));
          break;
        case "brighten":
          this.model.brighten(this.getCommandSubstring(command, 2),
                  this.getCommandSubstring(command, 3),
                  Integer.parseInt(this.getCommandSubstring(command, 1)));
          break;
        case "darken":
          this.model.darken(this.getCommandSubstring(command, 2),
                  this.getCommandSubstring(command, 3),
                  Integer.parseInt(this.getCommandSubstring(command, 1)));
          break;
        case "vertical-flip":
          this.model.flipVert(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2));
          break;
        case "horizontal-flip":
          this.model.flipHoriz(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2));
          break;
        case "value-component":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  PixelComponent.Value);
          break;
        case "intensity-component":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  PixelComponent.Intensity);
          break;
        case "luma-component":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  PixelComponent.Luma);
          break;
        case "red-component":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  PixelComponent.Red);
          break;
        case "green-component":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  PixelComponent.Green);
          break;
        case "blue-component":
          this.model.greyscale(this.getCommandSubstring(command, 1),
                  this.getCommandSubstring(command, 2),
                  PixelComponent.Blue);
          break;
        case "save":
          this.model.save(this.getCommandSubstring(command, 2),
                  this.getCommandSubstring(command, 1));
          break;
        default:
          try {
            this.outputStream.append("Command does not exist or requires arguments.")
                    .append(System.lineSeparator());
          } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
          }
      }
    } catch (IllegalArgumentException e) {
      this.outputSwitchError(e.getMessage());
    }
  }

  /**
   * Appends an error message to the output stream given the internal error message
   * from the switch failing to execute correctly.
   *
   * @param message the message of the error thrown while attempting to execute
   *                commands
   */
  public void outputSwitchError(String message) {
    if (message.equals("Position n of substring does not exist")) {
      try {
        this.outputStream.append("Missing argument(s).").append(System.lineSeparator());
      } catch (IOException ex) {
        throw new IllegalStateException(message);
      }
    } else if (message.equals("Key does not exist in hashmap")) {
      try {
        this.outputStream.append("Image has not been loaded in the program.")
                .append(System.lineSeparator());
      } catch (IOException ex) {
        throw new IllegalStateException(message);
      }
    } else {
      try {
        this.outputStream.append(message).append(System.lineSeparator());
      } catch (IOException ex) {
        throw new IllegalStateException(message);
      }
    }
  }
}