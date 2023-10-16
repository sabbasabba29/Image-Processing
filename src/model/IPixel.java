package model;

/**
 * Represents an RGB pixel.
 * @author Tyler Chung, Anthony Sabbatini
 */

public interface IPixel {

  /**
   * The following integer gets the value of the R component in the pixel.
   *
   * @return it will return the value of the r component
   */
  int getR();

  /**
   * The following integer gets the value of the G component in the pixel.
   *
   * @return it will return the value of the g component
   */
  int getG();

  /**
   * The following integer gets the value of the B component in the pixel.
   *
   * @return it will return the value of the B component
   */
  int getB();

  /**
   * The following integer will return the average of the RGB components, which is called intensity,
   * <p></p> rounded down to an integer.
   *
   * @return the average of the three components for each pixel as an integer
   */
  int getIntensity();

  /**
   * The following integer will return the highest of the RGB components, which is called value.
   *
   * @return the maximum value of the three components for each pixel
   */
  int getValue();

  /**
   * The following integer will return the luma rounded down to an integer.
   *
   * @return the luma uses the formula (0.2126r + 0.7152g + 0.0722b), and results as an integer
   */
  int getLuma();
}
