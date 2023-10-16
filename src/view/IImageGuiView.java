package view;

import model.IHistogramModel;
import model.IImageGuiModel;

/**
 * Represents an Image Processing View.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung and Anthony Sabbatini
 * @version %I%, Sunday, October 30, 2022 4:50 PM Eastern Time
 */
public interface IImageGuiView {
  /**
   * The following method will refresh the gui as methods change the image.
   */
  void refresh();

  /**
   * The following will update the histogram in the view.
   *
   * @param histogram this is the histogram that is to be displayed
   */
  void updateHistogram(IHistogramModel histogram);

  /**
   * The following is a method that will update the model in the view.
   *
   * @param model this is the model that will be updated.
   */
  void updateModel(IImageGuiModel model);
}
