package controller;

/**
 * Represents an Image Processing Controller.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 4:51 PM Eastern Time
 */
public interface IImageController {
  /**
   * Starts the image program.
   *
   * @throws IllegalStateException if the Controller is unable to successfully read
   *      input or transmit output
   */
  void start() throws IllegalArgumentException;
}
