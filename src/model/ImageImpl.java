package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * To represent an image implementation.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Wednesday, November 02, 2022 6:42 PM Eastern Time
 */
public class ImageImpl implements IImage {
  private final int width;
  private final int height;
  private final int maxValue;
  private final Pixel[][] pixels;


  /**
   * Hold an image's data given its image representation as a 2 dimensional array of Pixels.
   * <p></p> All integer parameters must be a positive integer, and the max value can't exceed 255.
   *
   * @param width the image width
   * @param height the image height
   * @param maxVal the max value in which the highest color value is
   * @param imageList a 2D array of pixels representing the image
   * @throws IllegalArgumentException if the max value is not between 0 and 255,
   *      if the pixel list width and height are not positive integers, or if
   *      the pixel list width and heights do not match with the inputted ones
   */
  public ImageImpl(int width, int height, int maxVal, Pixel[][] imageList)
          throws IllegalArgumentException {
    if (maxVal <= 0) {
      throw new IllegalArgumentException("Max value must be a positive integer");
    } if (maxVal > 255) {
      throw new IllegalArgumentException("Max value must be below 256");
    } if (imageList.length == 0) {
      throw new IllegalArgumentException("Pixel list height must be a positive integer");
    } if (imageList[0].length == 0) {
      throw new IllegalArgumentException("Pixel list width must be a positive integer");
    } if (imageList.length != height) {
      throw new IllegalArgumentException("Pixel list height and given height do not match");
    } if (imageList[0].length != width) {
      throw new IllegalArgumentException("Pixel list width and given width do not match");
    }

    // THE LAST TWO IF STATEMENTS CHECK THAT AN EXCEPTION IS THROWN WHEN
    // WIDTH OR HEIGHT ARE <= 0.

    int other = 0;
    this.width = width;
    this.height = height;
    this.maxValue = maxVal;
    this.pixels = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = imageList[i][j].getR();
        int g = imageList[i][j].getG();
        int b = imageList[i][j].getB();
        this.pixels[i][j] = new Pixel(r, g, b);
        other = Math.max(Math.max(other, r), Math.max(g, b));
      }
    }

    if (maxVal != other) {
      throw new IllegalArgumentException("Pixel list max value and given max value do not match");
    }
  }

  /**
   * Hold an image's data given its image representation as a 2 dimensional array of Pixels.
   *
   * @param imageList a 2D array of pixels representing the image
   * @throws IllegalArgumentException if the pixel list width or height is not a positive integer
   */
  public ImageImpl(Pixel[][] imageList) throws IllegalArgumentException {
    if (imageList.length == 0) {
      throw new IllegalArgumentException("Pixel list height must be a positive integer");
    } if (imageList[0].length == 0) {
      throw new IllegalArgumentException("Pixel list width must be a positive integer");
    }

    this.width = imageList[0].length;
    this.height = imageList.length;
    int m = 0;
    this.pixels = new Pixel[this.height][this.width];

    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        int r = imageList[i][j].getR();
        int g = imageList[i][j].getG();
        int b = imageList[i][j].getB();
        this.pixels[i][j] = new Pixel(r, g, b);
        m = Math.max(Math.max(m, r), Math.max(g, b));
      }
    }

    this.maxValue = m;
  }

  /**
   * Returns the width of an image.
   *
   * @return the width of the image as an integer
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Returns the height of an image.
   *
   * @return the height of the image as an integer
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Returns the max value of an image.
   *
   * @return the max value as an integer
   */
  public int getMaxValue() {
    return this.maxValue;
  }

  /**
   * Determines a pixel at a specified x and y coordinate.
   *
   * @param x the integer of the x coordinate of the pixel that they want to get
   * @param y the integer of the y coordinate of the pixel that they want to get
   * @return the pixel at that point
   */
  public Pixel getPixelAt(int x, int y) {
    try {
      int r = this.pixels[x][y].getR();
      int g = this.pixels[x][y].getG();
      int b = this.pixels[x][y].getB();
      return new Pixel(r, g, b);
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Could not find pixel at given position");
    }
  }

  /**
   * Returns true if this Image and a given object are equal, false otherwise.
   *
   * @param o the other object
   * @return true if this Image and the given object are equal
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof ImageImpl) {
      ImageImpl i = (ImageImpl) o;
      try {
        for (int x = 0; x < i.getHeight(); x++) {
          for (int y = 0; y < i.getWidth(); y++) {
            try {
              if (!this.getPixelAt(x, y).equals(i.getPixelAt(x, y))) {
                return false;
              }
            } catch (IllegalArgumentException exc) {
              return false;
            }
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }
      return this.getWidth() == i.getWidth()
              && this.getHeight() == i.getHeight()
              && this.getMaxValue() == i.getMaxValue();
    } else {
      return false;
    }
  }

  /**
   * Converts one of our image representations to a buffered image to be displayed.
   *
   * @return the buffered image created from our image representation
   */
  @Override
  public BufferedImage createBufferedImage() {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Pixel pixel = this.pixels[i][j];
        Color color = new Color(pixel.getR(), pixel.getG(), pixel.getB());
        image.setRGB(j, i, color.getRGB());
      }
    }
    return image;
  }

  /**
   * THe following is designed to output a new buffered image based off of a new scaling parameter.
   *
   * @param newWidth  the following integer width will determine the width of the downsized image
   * @param newHeight the following integer height will determine the height of the downsized image
   * @return the following will return a downsized BufferedImage
   */
  @Override
  public ImageImpl createResizedImage(ImageImpl image, int newWidth, int newHeight) {
    //BufferedImage resizeImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

    float widthMath = (float) newWidth / width;
    float heightMath = (float) newHeight / height;

    for (int i = 0; i < newHeight; i++) {
      for (int j = 0; j < newWidth; j++) {

        float pX = widthMath * i;
        float pY = heightMath * j;

        int pXFloor = (int) Math.floor(pX);
        int pYFloor = (int) Math.floor(pY);
        int pXCeiling = (int) Math.ceil(pX);
        int pYCeiling = (int) Math.ceil(pY);

        int iFloor = (int) Math.floor(i);
        int jFloor = (int) Math.floor(j);
        int iCeiling = (int) Math.ceil(i);
        int jCeiling = (int) Math.ceil(j);

        Pixel pixelA = this.pixels[pXFloor][pYFloor];
        Pixel pixelB = this.pixels[pXCeiling][pYFloor];
        Pixel pixelC = this.pixels[pXFloor][pYCeiling];
        Pixel pixelD = this.pixels[pXCeiling][pYCeiling];

        int redM = (int) (pixelB.getR() * (pX - pXFloor) + pixelA.getR() * (pXCeiling - pX));
        int redN = (int) (pixelD.getR() * (pX - pXFloor) + pixelC.getR() * (pXCeiling - pX));
        int redC = (int) (redN * (pY - pYFloor) + redM * (pYCeiling - pY));

        int greenM = (int) (pixelB.getG() * (pX - pXFloor) + pixelA.getG() * (pXCeiling - pX));
        int greenN = (int) (pixelD.getG() * (pX - pXFloor) + pixelC.getG() * (pXCeiling - pX));
        int greenC = (int) (greenN * (pY - pYFloor) + greenM * (pYCeiling - pY));

        int blueM = (int) (pixelB.getB() * (pX - pXFloor) + pixelA.getB() * (pXCeiling - pX));
        int blueN = (int) (pixelD.getB() * (pX - pXFloor) + pixelC.getB() * (pXCeiling - pX));
        int blueC = (int) (blueN * (pY - pYFloor) + blueM * (pYCeiling - pY));

        for (int row = 0; row < this.height; row++) {
          for (int col = 0; col < this.width; col++) {

              this.pixels[i][j] = new Pixel(redC, greenC, blueC);

          }
        }

      }
    }
    return image;
  }

  /**
   * Returns a hash code for this image.
   *
   * @return the hash code for this image
   */
  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        hashCode += this.pixels[i][j].hashCode();
      }
    }
    return hashCode;
  }
}
