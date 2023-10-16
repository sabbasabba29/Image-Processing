package model;

/**
 * The following interface is designed for extra credit additions to our program.
 */
public interface IImageModel3 extends IImageModel2 {

  /**
   * The following is designed to resize an image.
   *
   * @param width  the width is an integer that will determine the new width of the image
   * @param height the height is an integer that will determine the new height of the image
   * @return returns an ImageImpl
   * @throws IllegalArgumentException both values must be greater than or equal to 1, or an
   *                                  exception will be thrown
   */
  void resize(String key, String name, int width, int height) throws IllegalArgumentException;
}
