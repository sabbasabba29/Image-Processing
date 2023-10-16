package controller;

import org.junit.Test;

import java.io.StringReader;

import model.MockImageModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the methods of ImageControllerImpl2.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Thursday, November 10, 2022 7:54 PM Eastern Time
 */
public class ImageControllerImpl2Test extends ImageControllerImplTest {
  /**
   * Tests the constructor of the 2nd controller.
   */
  @Test
  public void testControllerConstructor2() {
    try {
      new ImageControllerImpl2(this.modelNull, this.readGood, System.out);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Model is null", e.getMessage());
    }

    try {
      new ImageControllerImpl2(this.modelGood, this.readNull, System.out);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Input stream is null", e.getMessage());
    }

    try {
      new ImageControllerImpl2(this.modelGood, this.readGood, null);
      fail();
    } catch (Exception e) {
      assertEquals("Output stream is null", e.getMessage());
    }

    try {
      new ImageControllerImpl2(this.modelGood, this.readGood, System.out);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Tests the controller with operations not tested in the ImageControllerImplTest class.
   */
  @Test
  public void testStartX() {
    Readable r = new StringReader("#load exampleimage1.ppm and call it 'example'"
            + System.lineSeparator() + "load test/res/exampleimage1.ppm example"
            + System.lineSeparator() + "#sharpen example"
            + System.lineSeparator() + "sharpen example ex-sharp"
            + System.lineSeparator() + "    "
            + System.lineSeparator() + "#blur example"
            + System.lineSeparator() + "blur example ex-blur"
            + System.lineSeparator() + "#greyscale example using a color transform"
            + System.lineSeparator() + "greyscale example ex-grey"
            + System.lineSeparator() + "#sepia-tone example"
            + System.lineSeparator() + "sepia example ex-sepia"
            + System.lineSeparator() + "#quit"
            + System.lineSeparator() + "q");
    Appendable a = new StringBuilder();
    MockImageModel m = new MockImageModel(a);
    ImageControllerImpl c = new ImageControllerImpl2(m, r, a);

    c.start();

    assertEquals("Welcome to the Image Processor."
                    + System.lineSeparator() + "Please enter commands below."
                    + System.lineSeparator() + "load test/res/exampleimage1.ppm example"
                    + System.lineSeparator() + "sharpen example ex-sharp"
                    + System.lineSeparator() + "blur example ex-blur"
                    + System.lineSeparator() + "greyscale example ex-grey"
                    + System.lineSeparator() + "sepia example ex-sepia"
                    + System.lineSeparator() + "Program quit!",
            a.toString().split(System.lineSeparator())[0]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[1]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[2]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[3]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[4]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[5]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[6]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[7]);
  }
}