package model;

/**
 * Represents an Image Processing Model for a GUI.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 6:28 PM Eastern Time
 */
public interface IImageGuiModel extends IImageModel2 {

  /**
   * Returns the Image of a given key.
   *
   * @param name the name of the key to obtain the Image of
   * @return the Image from the saved keys of this model
   */
  ImageImpl getImage(String name);

  /**
   * Returns the image at the current key number of this GUI model.
   *
   * @return the image at the current key number
   */
  ImageImpl getImageAtCurrentKeyNum();

  /**
   * Loads an image (the image of the current key) into this model given its file name,
   * which will be referred to as some integer as a string.
   *
   * @param imageFileName the file name of the image
   * @throws IllegalArgumentException if the file name cannot be found or is invalid
   */
  void load(String imageFileName);

  /**
   * Saves an image (the image of the current key) as a file with some name.
   *
   * @param fileName the name to save the image as
   * @throws IllegalArgumentException the file name cannot be found or is invalid
   * @throws IllegalArgumentException if there is an error in creating the output stream with
   *      the given file name
   * @throws IllegalStateException if the there is an error in writing
   *      to the output stream
   */
  void save(String fileName);

  /**
   * Greyscale an image (the image of the current key) to some RGB component, and saves it as
   * a new key.
   * <p></p>This method uses a switch case system in order to accommodate both a Red, Green, Blue,
   * Value, Intensity, and Luma greyscale formats.
   *
   * @param component the pixel component to use to greyscale
   * @throws IllegalArgumentException the key does not exist or if the given input is
   *      an invalid component
   */
  void greyscale(PixelComponent component);

  /**
   * Greyscale an image (the image of the current key) by color transforming with a matrix, and
   * saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  void greyscale();

  /**
   * Flips an image (the image of the current key) horizontally, and saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */

  void flipHoriz();

  /**
   * Flips an image (the image of the current key) vertically, and saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  void flipVert();

  /**
   * Brightens the image (the image of the current key) by adding a given positive integer to
   * the RGB values, and saves it as a new key.
   *
   * @param num the positive integer to brighten by
   * @throws IllegalArgumentException if the key does not exist or the inputted number
   *      is not a positive integer
   */
  void brighten(int num);

  /**
   * Darkens the image (the image of the current key) by subtracting a given positive integer
   * from the RGB values, and saves it as a new key.
   *
   * @param num the positive integer to darken by
   * @throws IllegalArgumentException if the key does not exist or the inputted number
   *      is not a positive integer
   */
  void darken(int num);

  /**
   * Conducts a Gaussian blur on an image (the image of the current key) by filtering with a
   * kernel, and saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  void blur();

  /**
   * Sharpens an image (the image of the current key) by filtering with a kernel, and
   * saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  void sharpen();

  /**
   * Sepia-tones an image (the image of the current key) by color transforming with a matrix, and
   * saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  void sepia();
}
