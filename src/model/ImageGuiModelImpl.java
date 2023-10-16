package model;

/**
 * Represents an Image Processing model implementation for a GUI.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 6:31 PM Eastern Time
 */
public class ImageGuiModelImpl extends EightBitImageModel2 implements IImageGuiModel {

  private int currentKeyNum;

  /**
   * Creates an image GUI model, keeping track of the current key of the image to be displayed.
   */
  public ImageGuiModelImpl() {
    super();
    this.currentKeyNum = -1;
  }

  /**
   * Returns the Image of a given key.
   *
   * @param name the name of the key to obtain the Image of
   * @return the Image from the saved keys of this model
   */
  @Override
  public ImageImpl getImage(String name) {
    ImageImpl image = this.savedKeys.get(name);
    Pixel[][] list = new Pixel[image.getHeight()][image.getWidth()];

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        list[i][j] = image.getPixelAt(i, j);
      }
    }

    return new ImageImpl(list);
  }

  /**
   * Returns the image at the current key number of this GUI model.
   *
   * @return the image at the current key number
   */
  public ImageImpl getImageAtCurrentKeyNum() {
    return this.getImage(Integer.toString(this.currentKeyNum));
  }

  /**
   * Loads an image (the image of the current key) into this model given its file name,
   * which will be referred to as some integer as a string.
   *
   * @param imageFileName the file name of the image
   * @throws IllegalArgumentException if the file name cannot be found or is invalid
   */
  public void load(String imageFileName) throws IllegalArgumentException {
    this.currentKeyNum++;
    this.load(Integer.toString(this.currentKeyNum), imageFileName);
  }

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
  public void save(String fileName) throws IllegalArgumentException {
    this.save(Integer.toString(this.currentKeyNum), fileName);
  }

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
  public void greyscale(PixelComponent component) {
    this.currentKeyNum++;
    this.greyscale(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum),
            component);
  }

  /**
   * Greyscale an image (the image of the current key) by color transforming with a matrix, and
   * saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  public void greyscale() {
    this.currentKeyNum++;
    this.greyscale(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum));
  }

  /**
   * Flips an image (the image of the current key) horizontally, and saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */

  public void flipHoriz() {
    this.currentKeyNum++;
    this.flipHoriz(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum));
  }

  /**
   * Flips an image (the image of the current key) vertically, and saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  public void flipVert() {
    this.currentKeyNum++;
    this.flipVert(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum));
  }

  /**
   * Brightens the image (the image of the current key) by adding a given positive integer to
   * the RGB values, and saves it as a new key.
   *
   * @param num the positive integer to brighten by
   * @throws IllegalArgumentException if the key does not exist or the inputted number
   *      is not a positive integer
   */
  public void brighten(int num) {
    this.currentKeyNum++;
    this.brighten(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum),
            num);
  }

  /**
   * Darkens the image (the image of the current key) by subtracting a given positive integer
   * from the RGB values, and saves it as a new key.
   *
   * @param num the positive integer to darken by
   * @throws IllegalArgumentException if the key does not exist or the inputted number
   *      is not a positive integer
   */
  public void darken(int num) {
    this.currentKeyNum++;
    this.darken(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum),
            num);
  }

  /**
   * Conducts a Gaussian blur on an image (the image of the current key) by filtering with a
   * kernel, and saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  public void blur() {
    this.currentKeyNum++;
    this.blur(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum));
  }

  /**
   * Sharpens an image (the image of the current key) by filtering with a kernel, and
   * saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  public void sharpen() {
    this.currentKeyNum++;
    this.sharpen(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum));
  }

  /**
   * Sepia-tones an image (the image of the current key) by color transforming with a matrix, and
   * saves it as a new key.
   *
   * @throws IllegalArgumentException if the key does not exist
   */
  public void sepia() {
    this.currentKeyNum++;
    this.sepia(Integer.toString(this.currentKeyNum - 1),
            Integer.toString(this.currentKeyNum));
  }
}
