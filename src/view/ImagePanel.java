package view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.IImageGuiController;
import model.IImageGuiModel;

/**
 * Represents a JPanel for the Image.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 5:17 PM Eastern Time
 */
public class ImagePanel extends JPanel implements Panel {
  private final IImageGuiModel model;

  private final Container contentPane;

  /**
   * THe following is a constructor for the ImagePanel class that takes in a model.
   *
   * @param model the constructor requires a model
   */
  public ImagePanel(IImageGuiModel model, Container contentPane) {
    this.model = model;
    this.contentPane = contentPane;

    setPreferredSize(new Dimension(960, 500));

    /*JScrollBar scrollBarX =
            new JScrollBar(JScrollBar.HORIZONTAL, 10, 10, 0, 100);
    JScrollBar scrollBarY =
            new JScrollBar(JScrollBar.VERTICAL, 10, 10, 0, 100);

    scrollBarX.setVisible(true);
    scrollBarY.setVisible(true);

    scrollBarX.setBounds(0, 465, 500, 500);
    scrollBarY.setBounds(465, 0, 500, 500);


    this.add(scrollBarX);
    this.add(scrollBarY);*/

    /*JPanel pixelGrid = new JPanel();
    GridLayout gl = new GridLayout(this.model.getImageAtCurrentKeyNum().getHeight(),
            this.model.getImageAtCurrentKeyNum().getWidth());
    pixelGrid.setLayout(gl);

    for (int i = 0; i < this.model.getImageAtCurrentKeyNum().getHeight(); i++) {
      for (int j = 0; j < this.model.getImageAtCurrentKeyNum().getWidth(); j++) {
        this.model.getImageAtCurrentKeyNum().getPixelAt(i, j);
      }
    }

    JScrollPane jsp = new JScrollPane();*/
  }

  /**
   * The following is a method to paint a component.
   *
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    /*Graphics2D g2d = (Graphics2D) g;*/

    /*ImageImpl image = this.model.getImage("bee");*/
    try {
      ScrollPanel scrollPanel = new ScrollPanel(this.model);

      JScrollPane jsp = new JScrollPane(scrollPanel,
              ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      this.contentPane.add(jsp);
    } catch (NullPointerException e) {
      // Do nothing, no image is in the model.
    }
  }

  /**
   * The following is a method to receive a select event based on an ImageGuiController.
   *
   * @param controller the GUI controller with features
   */
  @Override
  public void receiveEvent(IImageGuiController controller) {
    // Not in use anymore
  }
}
