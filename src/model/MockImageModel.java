package model;

import java.io.IOException;

/**
 * Mock image model for testing the image controller.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Friday, November 04, 2022 12:23 PM Eastern Time
 */
public class MockImageModel implements IImageModel3 {
  private final Appendable app;

  /**
   * Creates a mock image model.
   *
   * @param app an appendable to feed the info of the method calls to.
   * @throws IllegalArgumentException if appendable is null
   */
  public MockImageModel(Appendable app) {
    if (app == null) {
      throw new IllegalArgumentException("Appendable is null");
    }

    this.app = app;
  }

  /**
   * Loads an image into this model given its file name, which will be referred to as some given
   * name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param name the name that this model will refer the image to
   * @param imageFileName the file name of the image
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void load(String name, String imageFileName) throws IllegalStateException {
    try {
      this.app.append("load ").append(imageFileName).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Saves an image as a file given the image key and the file name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param fileName the name to save the image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void save(String key, String fileName) throws IllegalArgumentException {
    try {
      this.app.append("save ").append(fileName).append(" ").append(key)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Greyscale an image (given the key) by color transforming with a matrix, and
   * saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void greyscale(String key, String name) {
    try {
      this.app.append("greyscale ").append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Greyscale an image (given the key) to some RGB component, and saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param component the pixel component to use to greyscale
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void greyscale(String key, String name, PixelComponent component)
          throws IllegalArgumentException {
    try {
      this.app.append(component.toString().toLowerCase()).append("-component ")
              .append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Flips an image (given the key) horizontally, and saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the flipped image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void flipHoriz(String key, String name) throws IllegalArgumentException {
    try {
      this.app.append("horizontal-flip ").append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Flips an image (given the key) vertically, and saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void flipVert(String key, String name) throws IllegalArgumentException {
    try {
      this.app.append("vertical-flip ").append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Brightens the image (given the key) by adding a given positive integer to the RGB values,
   * and saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param num the positive integer to brighten by
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void brighten(String key, String name, int num) throws IllegalArgumentException {
    try {
      this.app.append("brighten ").append(String.valueOf(num)).append(" ").append(key)
              .append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Darkens the image (given the key) by subtracting a given positive integer from the
   * RGB values, and saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param num the positive integer to darken by
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void darken(String key, String name, int num) throws IllegalArgumentException {
    try {
      this.app.append("darken ").append(String.valueOf(num)).append(" ").append(key)
              .append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Returns a new image after undergoing a filter algorithm, given the original image
   * and a kernel, which is a square odd 2D array of double values.
   * <p></p>For the mock model, this method does nothing but return null.
   *
   * @param image the image to filter
   * @param kernel the kernel used to conduct the algorithm
   * @return a new filtered image
   */
  @Override
  public ImageImpl filter(ImageImpl image, double[][] kernel) {
    return null;
  }

  /**
   * Returns a new image after undergoing a color transfer, given the original image
   * and a 3 by 3 matrix as a 2D array of double values.
   * <p></p>For the mock model, this method does nothing but return null.
   *
   * @param image the image to transform
   * @param matrix the matrix used for color transforming
   * @return a new transformed image
   */
  @Override
  public ImageImpl colorTransform(ImageImpl image, double[][] matrix) {
    return null;
  }

  /**
   * Conducts a Gaussian blur on an image (given the key) by filtering with a kernel, and
   * saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the blurred image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void blur(String key, String name) {
    try {
      this.app.append("blur ").append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Sharpens an image (given the key) by filtering with a kernel, and
   * saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the sharpened image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void sharpen(String key, String name) {
    try {
      this.app.append("sharpen ").append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  /**
   * Sepia-tones an image (given the key) by color transforming with a matrix, and
   * saves it as some name.
   * <p></p>For the mock model, this instead feeds into the appendable.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the sepia-toned image as
   * @throws IllegalStateException if the appendable fails
   */
  @Override
  public void sepia(String key, String name) {
    try {
      this.app.append("sepia ").append(key).append(" ").append(name)
              .append(System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException("Appendable failed");
    }
  }

  @Override
  public void resize(String key, String name, int width, int height)
          throws IllegalArgumentException {
  }
}
