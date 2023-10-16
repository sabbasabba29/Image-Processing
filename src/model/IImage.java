package model;

import java.awt.image.BufferedImage;

/**
 * To represent an image.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Wednesday, November 02, 2022 6:41 PM Eastern Time
 */
public interface IImage {
  /**
   * Returns the width of an image.
   *
   * @return the width of the image as an integer
   */
  int getWidth();

  /**
   * Returns the height of an image.
   *
   * @return the height of the image as an integer
   */
  int getHeight();

  /**
   * Returns the max value of an image.
   *
   * @return the max value as an integer
   */
  int getMaxValue();

  /**
   * Determines a pixel at a specified x and y coordinate.
   *
   * @param x the integer of the x coordinate of the pixel that they want to get
   * @param y the integer of the y coordinate of the pixel that they want to get
   * @return the pixel at that point
   */
  Pixel getPixelAt(int x, int y);

  /**
   * The following method will create a buffered image.
   *
   * @return It will return a buffered image.
   */
  BufferedImage createBufferedImage();

  /**
   * The following method will create a resized image based off of parameters.
   *
   * @param width  the following integer width will determine the width of the downsized image
   * @param height the following integer height will determine the height of the downsized image
   * @return the following will return a Buffered Image that is downscaled
   */
  ImageImpl createResizedImage(ImageImpl image, int width, int height);
}
