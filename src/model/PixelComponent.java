package model;

/**
 * Represents the components of a pixel.
 * <p></p>We included each the R, G, and B values, as well as the calculated values of Luma,
 * intensity, and value.
 * <p></p>ImageProcessing.
 * The following enum was created in order to represent the different states that a pixel can be in.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung, Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 5:05 PM Eastern Time
 */
public enum PixelComponent {
  Red, Green, Blue, Luma, Intensity, Value
}