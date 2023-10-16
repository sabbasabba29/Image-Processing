package model;

/**
 * Represents an Image Processing Model.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 4:50 PM Eastern Time
 */
public interface IImageModel {

  /**
   * Loads an image into this model given its file name, which will be referred to as some given
   * name.
   *
   * @param name the name that this model will refer the image to
   * @param imageFileName the file name of the image
   * @throws IllegalArgumentException if the file name cannot be found or is invalid
   */
  void load(String name, String imageFileName) throws IllegalArgumentException;

  /**
   * Saves an image as a file given the image key and the file name.
   *
   * @param key the key used to obtain the image
   * @param fileName the name to save the image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void save(String key, String fileName) throws  IllegalArgumentException;

  /**
   * Greyscale an image (given the key) to some RGB component, and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param component the pixel component to use to greyscale
   * @throws IllegalArgumentException if the key does not exist or the given input is
   *      an invalid component
   */
  void greyscale(String key, String name, PixelComponent component)
          throws IllegalArgumentException;

  /**
   * Flips an image (given the key) horizontally, and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the flipped image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void flipHoriz(String key, String name) throws IllegalArgumentException;

  /**
   * Flips an image (given the key) vertically, and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void flipVert(String key, String name) throws IllegalArgumentException;

  /**
   * Brightens the image (given the key) by adding a given positive integer to the RGB values,
   * and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param num the positive integer to brighten by
   * @throws IllegalArgumentException if the key does not exist or the inputted number
   *      is not a positive integer
   */
  void brighten(String key, String name, int num) throws IllegalArgumentException;

  /**
   * Darkens the image (given the key) by subtracting a given positive integer from the
   * RGB values, and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param num the positive integer to darken by
   * @throws IllegalArgumentException if the key does not exist or the inputted number
   *      is not a positive integer
   */
  void darken(String key, String name, int num) throws IllegalArgumentException;
}
