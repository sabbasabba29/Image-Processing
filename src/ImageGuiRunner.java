import controller.IImageGuiController;
import controller.ImageGuiControllerImpl;
import model.HistogramModel;
import model.IHistogramModel;
import model.IImageGuiModel;
import model.ImageGuiModelImpl;
import view.IImageGuiView;
import view.ImageGuiViewImpl;

/**
 * Class Description.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Sunday, November 20, 2022 5:41 PM Eastern Time
 */
public class ImageGuiRunner {
  /**
   * Main method to run the marble solitaire GUI.
   *
   * @param args the array of sequence of Strings that are passed to the main function using
   *             the command line
   */
  public static void main(String[] args) {
    IImageGuiModel model = new ImageGuiModelImpl();
    IHistogramModel histogramModel = new HistogramModel();
    IImageGuiView view = new ImageGuiViewImpl(model, histogramModel);
    IImageGuiController controller = new ImageGuiControllerImpl(model, histogramModel, view);
  }
}
