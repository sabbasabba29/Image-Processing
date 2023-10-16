package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The following is an interface for an Image Histogram.
 */
public interface IHistogramModel {

  /**
   * The following will update the model with each updated model that occurs.
   *
   * @param model updating the histogram will use this model
   */
  IHistogramModel update(IImage model);

  /**
   * The following is an arrayList designed to get data that is contained in the histogram.
   *
   * @return the following is an arraylist and will return integers in that list
   */
  ArrayList<int[]> getDataHistogram();

  /**
   * The following will make a bar chart that will represent a histogram.
   *
   * @return the following will return an image that represents a histogram
   */
  BufferedImage renderHistogram();

}
