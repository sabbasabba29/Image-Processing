package view;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

/**
 * The following is a class represents a Histogram Graphic Panel, and extends a JPanel.
 */
public class HistogramGraphic extends JPanel {

  private final Map<Color, int[]> colorMap = new HashMap<>();

  /**
   * The following is a method that is designed to add bars to the histogram.
   *
   * @param color the method takes in a Color as a parameter
   * @param value the method also takes in a int[] called value as a parameter
   */
  public void barAdd(Color color, int[] value) {
    colorMap.put(color, value);
    repaint();
  }

  /**
   * The following is a method that paints the histogram.
   *
   * @param g  the <code>Graphics</code> context in which to paint
   */
  @Override
  public void paint(Graphics g) {
    Graphics2D graphics2D = (Graphics2D) g;
    int w = 0;
    int h = 0;
    graphics2D.setColor(Color.WHITE);
    graphics2D.fillRect(0, 0, w, h);

    for (Color color : colorMap.keySet()) {
      int[] v = colorMap.get(color);
      graphics2D.setColor(color);
      int max = 0;
      int min = 0;
      graphics2D.drawLine(w, h, w + 255, h);
      for (Integer map : v) {
        w += 1;
        max = Math.max((int)(0.05 * map), max);
        min = Math.min((int)(0.05 * map), 140);
        graphics2D.fillRect(w, h, 1, min);
        graphics2D.rotate(Math.PI);
      }
      w = 0;
      h += Math.min(max, 140);
    }
  }
}
