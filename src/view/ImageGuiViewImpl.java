package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.IHistogramModel;
import model.IImage;
import model.IImageGuiModel;

/**
 * This class is designed to implement out interface for gui view, and initialize our board.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 5:37 PM Eastern Time
 */
public class ImageGuiViewImpl extends JFrame implements IImageGuiView {

  private final JPanel imageWindow;
  private final JPanel histogramArea;
  private final JScrollPane imageDisplay;

  private IHistogramModel histogram;
  private IImageGuiModel model;


  /**
   * The following is a constructor for the ImageGuiViewImpl that takes in a model.
   *
   * @param model the constructor requires a ImageGUIModel.
   */
  public ImageGuiViewImpl(IImageGuiModel model, IHistogramModel histogram) {
    super();

    this.histogram = histogram;
    this.model = model;

    this.imageDisplay = new JScrollPane();

    this.model.load("test/res/doggo.jpg");
    JFileChooser loadButtonChoose = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Allowed Image Formats", "jpg", "jpeg", "png", "ppm","bmp");
    loadButtonChoose.setFileFilter(filter);

    JButton loadButton = new JButton("Load");
    loadButton.setActionCommand("load");

    JButton flipVertButton = new JButton("Vertical Flip");
    flipVertButton.setActionCommand("vertical-flip");

    JButton flipHorizButton = new JButton("Horizontal Flip");
    flipHorizButton.setActionCommand("horizontal-flip");

    JButton redComponentButton = new JButton("Red Component Greyscale");
    redComponentButton.setActionCommand("red-component");

    JButton blueComponentButton = new JButton("Blue Component Greyscale");
    blueComponentButton.setActionCommand("blue-component");

    JButton greenComponentButton = new JButton("Green Component Greyscale");
    greenComponentButton.setActionCommand("green-component");

    JButton intensityComponentButton = new JButton("Intensity Component Greyscale");
    intensityComponentButton.setActionCommand("intensity-component");

    JButton lumaComponentButton = new JButton("Luma Component Greyscale");
    lumaComponentButton.setActionCommand("luma-component");

    JButton valueComponentButton = new JButton("Value Component GreyScale");
    valueComponentButton.setActionCommand("value-component");

    JButton brightButton = new JButton("brighten");
    brightButton.setActionCommand("brighten");

    JButton darkButton = new JButton("Darken");
    darkButton.setActionCommand("darken");

    JButton blurButton = new JButton("Blur");
    blurButton.setActionCommand("blur");

    JButton sharpenButton = new JButton("Sharpen");
    sharpenButton.setActionCommand("sharpen");

    JButton sepiaButton = new JButton("Sepia");
    sepiaButton.setActionCommand("sepia");

    JButton greyscaleButton = new JButton("Greyscale");
    greyscaleButton.setActionCommand("greyscale");

    JButton saveButton = new JButton("Save File");
    saveButton.setActionCommand("save");

    JFrame newFrame = new JFrame("Image Processing");
    newFrame.setVisible(true);
    newFrame.setPreferredSize(new Dimension(1920, 1028));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newFrame.setResizable(false);
    newFrame.pack();

    // create Image Window
    imageWindow = new JPanel();
    imageWindow.setBorder(BorderFactory.createTitledBorder("Image"));
    imageWindow.setPreferredSize(new Dimension(960, 500));
    newFrame.add(imageWindow, BorderLayout.WEST);

    // creating histogram Window
    histogramArea = new JPanel();
    histogramArea.setBorder(BorderFactory.createTitledBorder("Histogram"));
    histogramArea.setPreferredSize(new Dimension(300, 300));
    newFrame.add(histogramArea, BorderLayout.SOUTH);

    // Button construction
    JPanel buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(500, 300));
    buttonPanel.add(loadButtonChoose);
    buttonPanel.add(loadButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(brightButton);
    buttonPanel.add(darkButton);
    buttonPanel.add(blurButton);
    buttonPanel.add(sharpenButton);
    buttonPanel.add(sepiaButton);
    buttonPanel.add(greyscaleButton);
    buttonPanel.add(flipHorizButton);
    buttonPanel.add(flipVertButton);
    buttonPanel.add(redComponentButton);
    buttonPanel.add(greenComponentButton);
    buttonPanel.add(blueComponentButton);
    buttonPanel.add(valueComponentButton);
    buttonPanel.add(intensityComponentButton);
    buttonPanel.add(lumaComponentButton);

    newFrame.add(buttonPanel, BorderLayout.EAST);

    //this.model.load("bee", loadButtonChoose.getSelectedFile().getPath());


  }



  @Override
  public void refresh() {
    this.repaint();
    IImage currentModel = (IImage) this.model;
    IHistogramModel currentHisto = this.histogram;
    ImageIcon picture = new ImageIcon(currentModel.createBufferedImage());
    ImageIcon histogram = new ImageIcon(currentHisto.renderHistogram());
    JLabel histoLabel = new JLabel(histogram);
    JLabel label = new JLabel(picture);
    if (currentModel != null) {
      this.imageWindow.add(label);
      this.imageWindow.updateUI();
      if (this.imageWindow.getComponentCount() >= 2) {
        imageDisplay.remove(0);
      }
    } else {

    }
    if (currentHisto != null) {
      this.histogramArea.add(histoLabel);
      this.histogramArea.updateUI();
      if (this.histogramArea.getComponentCount() >= 2) {
        histogramArea.remove(0);
      }
    } else {

    }
  }

  /**
   * Updates the histogram in the view.
   *
   * @param histogram the histogram to be displayed
   */
  @Override
  public void updateHistogram(IHistogramModel histogram) {
    this.histogram = histogram;
  }

  /**
   * Updates the view model to the image model currently being manipulated by the user.
   *
   * @param model the new image model
   */
  @Override
  public void updateModel(IImageGuiModel model) {
    this.model = model;
  }
}
