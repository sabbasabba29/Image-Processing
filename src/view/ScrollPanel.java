package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

import model.IImageGuiModel;
import model.ImageImpl;

/**
 * Class Description.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Wednesday, November 23, 2022 6:14 PM Eastern Time
 */
public class ScrollPanel extends JPanel {
  private final IImageGuiModel model;

  public ScrollPanel(IImageGuiModel model) {
    this.model = model;
    setPreferredSize(new Dimension(960, 500));
  }

  @Override
  protected void paintComponent(Graphics g) {
    ImageImpl image = this.model.getImageAtCurrentKeyNum();
    for (int i = 0; i < this.model.getImageAtCurrentKeyNum().getHeight(); i++) {
      for (int j = 0; j < this.model.getImageAtCurrentKeyNum().getWidth(); j++) {
        g.drawRect(i, j, 1, 1);
        g.fillRect(i, j, 1, 1);
        g.setColor(new Color(image.getPixelAt(i, j).getR(),
                image.getPixelAt(i, j).getG(),
                image.getPixelAt(i, j).getB()));
      }
    }
  }
}
