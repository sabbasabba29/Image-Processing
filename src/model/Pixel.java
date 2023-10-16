package model;

/**
 * Represents an RGB pixel implementation.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 5:01 PM Eastern Time
 */
public class Pixel implements IPixel {
  private final int r;
  private final int g;
  private final int b;

  /**
   * Creates a pixel with RGB.
   *
   * @param r the red value
   * @param g the green value
   * @param b the blue value
   */
  public Pixel(int r, int g, int b) {
    if (r < 0) {
      throw new IllegalArgumentException("R must be greater than or equal to 0");
    } else if (r > 255) {
      throw new IllegalArgumentException("R must be below 256");
    } else if (g < 0) {
      throw new IllegalArgumentException("G must be greater than or equal to 0");
    } else if (g > 255) {
      throw new IllegalArgumentException("G must be below 256");
    } else if (b < 0) {
      throw new IllegalArgumentException("B must be greater than or equal to 0");
    } else if (b > 255) {
      throw new IllegalArgumentException("B must be below 256");
    }

    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Returns the R value of this pixel.
   *
   * @return the red value
   */
  public int getR() {
    return this.r;
  }

  /**
   * Returns the G value of this pixel.
   *
   * @return the green value
   */
  public int getG() {
    return this.g;
  }

  /**
   * Returns the B value of this pixel.
   *
   * @return the blue value
   */
  public int getB() {
    return this.b;
  }

  /**
   * Return the intensity of this pixel, rounded down to an integer.
   *
   * @return the average of the three components for each pixel as an integer
   */
  public int getIntensity() {
    return (this.r + this.g + this.b) / 3;
  }

  /**
   * Return the value of this pixel.
   *
   * @return the maximum value of the three components for each pixel
   */
  public int getValue() {
    int max = this.r;
    if (this.g > this.r && this.g > this.b) {
      max = this.g;
    } else if (this.b > this.r && this.b > this.g) {
      max = this.b;
    }
    return max;
  }

  /**
   * Return the luma of this pixel rounded down to an integer.
   *
   * @return the luma as an integer.
   */
  public int getLuma() {
    return (int) (0.2126 * this.r + 0.7152 * this.g + 0.0722 * this.b);
  }

  /**
   * Returns true if this Pixel and a given object are equal, false otherwise.
   *
   * @param o the other object
   * @return true if this Pixel and the given object are equal
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Pixel) {
      Pixel p = (Pixel) o;
      return (this.r == p.r && this.g == p.g && this.b == p.b);
    } else {
      return false;
    }
  }

  /**
   * Returns a hash code for this Pixel.
   *
   * @return the hash code for this pixel
   */
  @Override
  public int hashCode() {
    return this.r * 1000000 + this.g * 1000 + this.b;
  }
}
