package model;

/**
 * Represents a 2nd Image Processing Model.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Wednesday, November 09, 2022 7:50 PM Eastern Time
 */
public interface IImageModel2 extends IImageModel {

  /**
   * Returns a new image after undergoing a filter algorithm, given the original image
   * and a kernel, which is a square odd 2D array of double values.
   *
   * @param image the image to filter
   * @param kernel the kernel used to conduct the algorithm
   * @return a new filtered image
   * @throws IllegalArgumentException if the kernel has unequal or even dimensions
   */
  ImageImpl filter(ImageImpl image, double[][] kernel) throws IllegalArgumentException;

  /**
   * Returns a new image after undergoing a color transfer, given the original image
   * and a 3 by 3 matrix as a 2D array of double values.
   *
   * @param image the image to transform
   * @param matrix the matrix used for color transforming
   * @return a new transformed image
   * @throws IllegalArgumentException if the matrix is not of size 3 by 3
   */
  ImageImpl colorTransform(ImageImpl image, double[][] matrix) throws IllegalArgumentException;

  /**
   * Conducts a Gaussian blur on an image (given the key) by filtering with a kernel, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the blurred image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void blur(String key, String name) throws IllegalArgumentException;

  /**
   * Sharpens an image (given the key) by filtering with a kernel, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the sharpened image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void sharpen(String key, String name) throws IllegalArgumentException;

  /**
   * Greyscale an image (given the key) by color transforming with a matrix, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the greyscale image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void greyscale(String key, String name) throws IllegalArgumentException;

  /**
   * Sepia-tones an image (given the key) by color transforming with a matrix, and
   * saves it as some name.
   *
   * @param key the key used to obtain the image
   * @param name the name to save the sepia-toned image as
   * @throws IllegalArgumentException if the key does not exist
   */
  void sepia(String key, String name) throws IllegalArgumentException;
}
