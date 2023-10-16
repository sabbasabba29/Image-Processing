package model;

/**
 * Represents a 2nd Image Processing Model Implementation.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Wednesday, November 09, 2022 6:51 PM Eastern Time
 */
public class EightBitImageModel2 extends EightBitImageModel implements IImageModel2 {

  /**
   * Returns a new image after undergoing a filter algorithm, given the original image
   * and a kernel, which is a square odd 2D array of double values.
   *
   * @param image the image to filter
   * @param kernel the kernel used to conduct the algorithm
   * @return a new filtered image
   * @throws IllegalArgumentException if the kernel has unequal or even dimensions
   */
  @Override
  public ImageImpl filter(ImageImpl image, double[][] kernel) {
    try {
      if (kernel.length != kernel[0].length) {
        throw new IllegalArgumentException("Kernel must have equal dimensions");
      } if (kernel.length % 2 != 1) {
        throw new IllegalArgumentException("Kernel must have odd dimensions");
      }
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Kernel must have odd dimensions");
    }

    Pixel[][] list = new Pixel[image.getHeight()][image.getWidth()];

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int toSubtract = kernel.length / 2;
        double sumR = 0.0;
        double sumG = 0.0;
        double sumB = 0.0;
        for (int m = 0; m < kernel.length; m++) {
          for (int n = 0; n < kernel[0].length; n++) {
            try {
              sumR += image.getPixelAt(i + m - toSubtract, j + n - toSubtract).getR()
                      * kernel[m][n];
              sumG += image.getPixelAt(i + m - toSubtract, j + n - toSubtract).getG()
                      * kernel[m][n];
              sumB += image.getPixelAt(i + m - toSubtract, j + n - toSubtract).getB()
                      * kernel[m][n];
            } catch (IllegalArgumentException e) {
              // Do nothing
            }
          }
        }

        if (sumR < 0.0) {
          sumR = 0;
        } else if (sumR > 255.0) {
          sumR = 255.0;
        } if (sumG < 0.0) {
          sumG = 0;
        } else if (sumG > 255.0) {
          sumG = 255.0;
        } if (sumB < 0.0) {
          sumB = 0;
        } else if (sumB > 255.0) {
          sumB = 255.0;
        }

        list[i][j] = new Pixel((int) sumR, (int) sumG, (int) sumB);
      }
    }
    return new ImageImpl(list);
  }

  /**
   * Returns a new image after undergoing a color transfer, given the original image
   * and a 3 by 3 matrix as a 2D array of double values.
   *
   * @param image the image to transform
   * @param matrix the matrix used for color transforming
   * @return a new transformed image
   * @throws IllegalArgumentException if the matrix is not of size 3 by 3
   */
  @Override
  public ImageImpl colorTransform(ImageImpl image, double[][] matrix) {
    try {
      if (matrix.length != 3 || matrix[0].length != 3) {
        throw new IllegalArgumentException("Matrix must have 3 by 3 dimensions");
      }
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Matrix must have 3 by 3 dimensions");
    }

    Pixel[][] list = new Pixel[image.getHeight()][image.getWidth()];

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        double newR = matrix[0][0] * image.getPixelAt(i, j).getR()
                + matrix[0][1] * image.getPixelAt(i, j).getG()
                + matrix[0][2] * image.getPixelAt(i, j).getB();
        double newG = matrix[1][0] * image.getPixelAt(i, j).getR()
                + matrix[1][1] * image.getPixelAt(i, j).getG()
                + matrix[1][2] * image.getPixelAt(i, j).getB();
        double newB = matrix[2][0] * image.getPixelAt(i, j).getR()
                + matrix[2][1] * image.getPixelAt(i, j).getG()
                + matrix[2][2] * image.getPixelAt(i, j).getB();

        if (newR < 0.0) {
          newR = 0.0;
        } else if (newR > 255.0) {
          newR = 255.0;
        } if (newG < 0.0) {
          newG = 0.0;
        } else if (newG > 255.0) {
          newG = 255.0;
        } if (newB < 0.0) {
          newB = 0.0;
        } else if (newB > 255.0) {
          newB = 255.0;
        }

        list[i][j] = new Pixel((int) newR, (int) newG, (int) newB);
      }
    }

    return new ImageImpl(list);
  }


  /**
   * Conducts a Gaussian blur on an image (given the key) by filtering with a kernel, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the blurred image as
   * @throws IllegalArgumentException if the key does not exist
   */
  @Override
  public void blur(String key, String name) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    double[][] kernel = new double[3][3];
    kernel[0][0] = 1.0 / 16.0;
    kernel[0][1] = 1.0 / 8.0;
    kernel[0][2] = 1.0 / 16.0;
    kernel[1][0] = 1.0 / 8.0;
    kernel[1][1] = 1.0 / 4.0;
    kernel[1][2] = 1.0 / 8.0;
    kernel[2][0] = 1.0 / 16.0;
    kernel[2][1] = 1.0 / 8.0;
    kernel[2][2] = 1.0 / 16.0;

    this.savedKeys.put(name, this.filter(image, kernel));
  }

  /**
   * Sharpens an image (given the key) by filtering with a kernel, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the sharpened image as
   * @throws IllegalArgumentException if the key does not exist
   */
  @Override
  public void sharpen(String key, String name) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    double[][] kernel = new double[5][5];
    kernel[0][0] = -1.0 / 8.0;
    kernel[0][1] = -1.0 / 8.0;
    kernel[0][2] = -1.0 / 8.0;
    kernel[0][3] = -1.0 / 8.0;
    kernel[0][4] = -1.0 / 8.0;
    kernel[1][0] = -1.0 / 8.0;
    kernel[1][1] = 1.0 / 4.0;
    kernel[1][2] = 1.0 / 4.0;
    kernel[1][3] = 1.0 / 4.0;
    kernel[1][4] = -1.0 / 8.0;
    kernel[2][0] = -1.0 / 8.0;
    kernel[2][1] = 1.0 / 4.0;
    kernel[2][2] = 1.0;
    kernel[2][3] = 1.0 / 4.0;
    kernel[2][4] = -1.0 / 8.0;
    kernel[3][0] = -1.0 / 8.0;
    kernel[3][1] = 1.0 / 4.0;
    kernel[3][2] = 1.0 / 4.0;
    kernel[3][3] = 1.0 / 4.0;
    kernel[3][4] = -1.0 / 8.0;
    kernel[4][0] = -1.0 / 8.0;
    kernel[4][1] = -1.0 / 8.0;
    kernel[4][2] = -1.0 / 8.0;
    kernel[4][3] = -1.0 / 8.0;
    kernel[4][4] = -1.0 / 8.0;

    this.savedKeys.put(name, this.filter(image, kernel));
  }

  /**
   * Greyscale an image (given the key) by color transforming with a matrix, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @throws IllegalArgumentException if the key does not exist
   */
  @Override
  public void greyscale(String key, String name) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    double[][] matrix = new double[3][3];
    matrix[0][0] = 0.2126;
    matrix[0][1] = 0.7152;
    matrix[0][2] = 0.0722;
    matrix[1][0] = 0.2126;
    matrix[1][1] = 0.7152;
    matrix[1][2] = 0.0722;
    matrix[2][0] = 0.2126;
    matrix[2][1] = 0.7152;
    matrix[2][2] = 0.0722;

    this.savedKeys.put(name, this.colorTransform(image, matrix));
  }

  /**
   * Sepia-tones an image (given the key) by color transforming with a matrix, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the sepia-toned image as
   * @throws IllegalArgumentException if the key does not exist
   */
  @Override
  public void sepia(String key, String name) {
    ImageImpl image = this.savedKeys.get(key);
    if (!this.savedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Key does not exist in hashmap");
    }

    double[][] matrix = new double[3][3];
    matrix[0][0] = 0.393;
    matrix[0][1] = 0.769;
    matrix[0][2] = 0.189;
    matrix[1][0] = 0.349;
    matrix[1][1] = 0.686;
    matrix[1][2] = 0.168;
    matrix[2][0] = 0.272;
    matrix[2][1] = 0.534;
    matrix[2][2] = 0.131;

    this.savedKeys.put(name, this.colorTransform(image, matrix));
  }
}
