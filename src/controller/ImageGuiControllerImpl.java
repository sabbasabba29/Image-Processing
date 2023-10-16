package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.IHistogramModel;
import model.IImage;
import model.IImageGuiModel;
import model.PixelComponent;
import view.IImageGuiView;

/**
 * The following class is designed as a new controller to accommodate the GUI system.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 5:04 PM Eastern Time
 */
public class ImageGuiControllerImpl implements IImageGuiController, ActionListener {
  private final IHistogramModel histo;
  IImageGuiModel model;
  IImageGuiView view;

  /**
   * The following constructor takes in a model ana view as parameters to accommodate the GUI.
   *
   * @param model            this constructor requires a model as a parameter to
   *                         construct the controller
   * @param histo   this constructor requires a histogram model as a parameter to
   *                         construct the controller
   * @param view             this constructor requires a view as a parameter to
   *                         construct the controller
   */
  public ImageGuiControllerImpl(IImageGuiModel model,
                                IHistogramModel histo,
                                IImageGuiView view) {
    this.model = model;
    this.histo = histo;
    this.view = view;
  }

  /**
   * The following method is designed to perform a change to an image and a histogram and represent
   * <p></p> it in the GUI.
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    if (action.equals("load")) {
      // Somehow get the path of the file, already created as a public string in view
    } else {
      if (this.model != null) {
        switch (action) {
          case "vertical-flip" :
            this.model.flipVert();
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "horizontal-flip" :
            this.model.flipHoriz();
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "red-component" :
            this.model.greyscale(PixelComponent.Red);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "green-component" :
            this.model.greyscale(PixelComponent.Green);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "blue-component" :
            this.model.greyscale(PixelComponent.Blue);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "value-component" :
            this.model.greyscale(PixelComponent.Value);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "intensity-component" :
            this.model.greyscale(PixelComponent.Intensity);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "luma-component" :
            this.model.greyscale(PixelComponent.Luma);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "brighten" :
            this.model.brighten(10);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "darken" :
            this.model.darken(10);
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "blur" :
            this.model.blur();
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "sepia" :
            this.model.sepia();
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "sharpen" :
            this.model.sharpen();
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "greyscale" :
            this.model.greyscale();
            this.histo.update((IImage) this.model);
            this.view.updateModel(this.model);
            this.view.updateHistogram(this.histo);
            this.view.refresh();
            break;
          case "save" :
            //this.model.save();
            break;
          default:
            throw new IllegalStateException("No actions should cause this exception");
        }
      }
    }
    if (this.model != null) {
      this.view.refresh();
    }
  }
}
