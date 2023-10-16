package view;

import controller.IImageGuiController;

/**
 * To represent a panel with a JFrame.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 5:15 PM Eastern Time
 */
public interface Panel {
  /**
   * Receives a GUI controller containing operations for when a mouse event occurs.
   *
   * @param controller the GUI controller with features
   */
  void receiveEvent(IImageGuiController controller);
}
