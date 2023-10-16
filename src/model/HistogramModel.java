package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JLabel;

import view.HistogramGraphic;

/**
 * The following class represents an implementation for an Image Histogram.
 */
public class HistogramModel implements IHistogramModel {

  private int[] histR;
  private int[] histG;
  private int[] histB;
  private int[] histI;

  /**
   * The following is a constructor for a Histogram Model.
   */
  public HistogramModel() {
    this.histR = new int[256];
    this.histG = new int[256];
    this.histB = new int[256];
    this.histI = new int[256];
  }

  @Override
  public IHistogramModel update(IImage model) {
    this.histR = new int[256];
    this.histG = new int[256];
    this.histB = new int[256];
    this.histI = new int[256];

    for (int i = 0; i < model.getWidth(); i++) {
      for (int j = 0; j < model.getHeight(); j++) {
        Pixel current = model.getPixelAt(i, j);
        this.histR[Math.min(current.getR(), 254)] += 1;
        this.histG[Math.min(current.getG(), 254)] += 1;
        this.histB[Math.min(current.getB(), 254)] += 1;
        this.histI[Math.min(current.getIntensity(), 254)] += 1;
      }
    }
    return this;
  }

  @Override
  public ArrayList<int[]> getDataHistogram() {
    ArrayList<int[]> information = new ArrayList<>();
    information.add(histR);
    information.add(histG);
    information.add(histB);
    information.add(histI);
    return information;
  }

  @Override
  public BufferedImage renderHistogram() {
    HistogramGraphic graphic = new HistogramGraphic();
    graphic.barAdd(Color.red, this.getDataHistogram().get(0));
    graphic.barAdd(Color.green, this.getDataHistogram().get(1));
    graphic.barAdd(Color.blue, this.getDataHistogram().get(2));
    graphic.barAdd(Color.white, this.getDataHistogram().get(3));
    BufferedImage newImage = new BufferedImage(
            graphic.getPreferredSize().width,
            graphic.getPreferredSize().height,
            BufferedImage.TYPE_INT_RGB);
    Graphics2D g = newImage.createGraphics();
    graphic.paint(g);
    g.drawImage(newImage, newImage.getWidth(new JLabel()),
            newImage.getHeight(new JLabel()), new JLabel());
    g.dispose();
    return newImage;
  }
}
