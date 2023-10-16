package model;

import java.util.HashMap;
import java.util.Map;

import util.ImageUtil;

/**
 * Represents an Image Processing Model Implementation.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 5:14 PM Eastern Time
 */
public class EightBitImageModel implements IImageModel {

  protected final Map<String, ImageImpl> savedKeys;

  /**
   * To create a new eight-but image model.
   */
  public EightBitImageModel() {
    this.savedKeys = new HashMap<>();
  }

  /**
   * Loads an image into this model given its file name, which will be referred to as some given
   * name.
   *
   * @param name the name that this model will refer the image to
   * @param imageFileName the file name of the image
   * @throws IllegalArgumentException if the file name cannot be found or is invalid
   */
  @Override
  public void load(String name, String imageFileName) throws IllegalArgumentException {
    try {
      ImageImpl image = ImageUtil.readPPM(imageFileName);
      savedKeys.put(name, image);
    } catch (IllegalArgumentException | IllegalStateException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * Saves an image as a file given the image key and the file name.
   *
   * @param key the key used to obtain the image
   * @param fileName the name to save the image as
   * @throws IllegalArgumentException the file name cannot be found or is invalid
   * @throws IllegalArgumentException if there is an error in creating the output stream with
   *      the given file name
   * @throws IllegalStateException if the there is an error in writing
   *      to the output stream
   */
  @Override
  public void save(String key, String fileName) throws IllegalArgumentException {
    try {
      if (savedKeys.get(key) == null) {
        throw new IllegalArgumentException("Key does not exist in hashmap");
      }
      ImageUtil.savePPM(savedKeys.get(key), fileName);
    } catch (IllegalStateException | IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * Greyscale an image (given the key) to some RGB component, and saves it as some name.
   * <p></p>This method uses a switch case system in order to accommodate both a Red, Green, Blue,
   * Value, Intensity, and Luma greyscale formats.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @param component the pixel component to use to greyscale
   * @throws IllegalArgumentException the key does not exist or if the given input is
   *      an invalid component
   */
  @Override
  public void greyscale(String key, String name, PixelComponent component) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }
    Pixel[][] toSave = new Pixel[image.getHeight()][image.getWidth()];
    switch (component) {
      case Red:
        for (int i = 0; i < image.getHeight(); i++) {
          for (int j = 0; j < image.getWidth(); j++) {
            toSave[i][j] = new Pixel(image.getPixelAt(i, j).getR(),
                    image.getPixelAt(i, j).getR(),
                    image.getPixelAt(i, j).getR());
          }
        }
        break;
      case Green:
        for (int i = 0; i < image.getHeight(); i++) {
          for (int j = 0; j < image.getWidth(); j++) {
            toSave[i][j] = new Pixel(image.getPixelAt(i, j).getG(),
                    image.getPixelAt(i, j).getG(),
                    image.getPixelAt(i, j).getG());
          }
        }
        break;
      case Blue:
        for (int i = 0; i < image.getHeight(); i++) {
          for (int j = 0; j < image.getWidth(); j++) {
            toSave[i][j] = new Pixel(image.getPixelAt(i, j).getB(),
                    image.getPixelAt(i, j).getB(),
                    image.getPixelAt(i, j).getB());
          }
        }
        break;
      case Value:
        for (int i = 0; i < image.getHeight(); i++) {
          for (int j = 0; j < image.getWidth(); j++) {
            toSave[i][j] = new Pixel(image.getPixelAt(i, j).getValue(),
                    image.getPixelAt(i, j).getValue(),
                    image.getPixelAt(i, j).getValue());
          }
        }
        break;
      case Intensity:
        for (int i = 0; i < image.getHeight(); i++) {
          for (int j = 0; j < image.getWidth(); j++) {
            toSave[i][j] = new Pixel(image.getPixelAt(i, j).getIntensity(),
                    image.getPixelAt(i, j).getIntensity(),
                    image.getPixelAt(i, j).getIntensity());
          }
        }
        break;
      case Luma:
        for (int i = 0; i < image.getHeight(); i++) {
          for (int j = 0; j < image.getWidth(); j++) {
            toSave[i][j] = new Pixel(image.getPixelAt(i, j).getLuma(),
                    image.getPixelAt(i, j).getLuma(),
                    image.getPixelAt(i, j).getLuma());
          }
        }
        break;
      default:
        throw new IllegalArgumentException("Component is invalid");
    }

    this.savedKeys.put(name, new ImageImpl(toSave));
  }

  /**
   * Flips an image (given the key) horizontally, and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the flipped image as
   * @throws IllegalArgumentException if the key does not exist
   */
  @Override
  public void flipHoriz(String key, String name) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    Pixel[][] toSave = new Pixel[image.getHeight()][image.getWidth()];
    int x = 1;
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        toSave[i][image.getWidth() - x] = image.getPixelAt(i, j);
        x++;
      }
      x = 1;
    }
    this.savedKeys.put(name, new ImageImpl(toSave));
  }

  /**
   * Flips an image (given the key) vertically, and saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @throws IllegalArgumentException if the key does not exist
   */
  @Override
  public void flipVert(String key, String name) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    Pixel[][] toSave = new Pixel[image.getHeight()][image.getWidth()];
    int x = 1;
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        toSave[image.getHeight() - x][j] = image.getPixelAt(i, j);
      }
      x++;
    }

    this.savedKeys.put(name, new ImageImpl(toSave));
  }

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
  @Override
  public void brighten(String key, String name, int num) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    if (num <= 0) {
      throw new IllegalArgumentException("Number must be a positive integer");
    }

    Pixel[][] toSave = new Pixel[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int o = image.getPixelAt(i, j).getR() + num;
        int p = image.getPixelAt(i, j).getG() + num;
        int q = image.getPixelAt(i, j).getB() + num;

        if (o > 255) {
          o = 255;
        } if (p > 255) {
          p = 255;
        } if (q > 255) {
          q = 255;
        }

        toSave[i][j] = new Pixel(o, p, q);
      }
    }

    this.savedKeys.put(name, new ImageImpl(toSave));
  }

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
  @Override
  public void darken(String key, String name, int num) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    if (num <= 0) {
      throw new IllegalArgumentException("Number must be a positive integer.");
    }

    Pixel[][] toSave = new Pixel[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int o = image.getPixelAt(i, j).getR() - num;
        int p = image.getPixelAt(i, j).getG() - num;
        int q = image.getPixelAt(i, j).getB() - num;

        if (o < 0) {
          o = 0;
        } if (p < 0) {
          p = 0;
        } if (q < 0) {
          q = 0;
        }

        toSave[i][j] = new Pixel(o, p, q);
      }
    }

    this.savedKeys.put(name, new ImageImpl(toSave));
  }
}
