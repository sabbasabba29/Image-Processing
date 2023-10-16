package model;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.Objects;

/**
 * The class is used for extra credit components to our program.
 */
public class EightBitImageModel3 extends EightBitImageModel2 implements IImageModel3 {

  public Pixel[][] result;
  /**
   * The following method is designed to downsize an image based on an inputted height and width.
   *
   * @param width  the width is an integer that will determine the new width of the image
   * @param height the height is an integer that will determine the new height of the image
   * @throws IllegalArgumentException both values must be greater than or equal to 1, or an
   *                                  exception will be thrown
   */
  @Override
  public void resize(String key, String name, int width, int height)
          throws IllegalArgumentException {
    Objects.requireNonNull(key);
    Objects.requireNonNull(name);
    Objects.requireNonNull(width);
    Objects.requireNonNull(height);


    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    // Will throw exception if the dimension is not positive
    if (width < 1 || height < 1) {
      throw new IllegalArgumentException("dimensions must be positive");
    }

    ImageImpl image = this.savedKeys.get(key);
    ImageImpl imageNew = image.createResizedImage(image, width, height);

    savedKeys.put(name, imageNew);
    }

}
