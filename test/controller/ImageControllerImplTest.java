package controller;

import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import model.EightBitImageModel3;
import model.IImageModel3;
import model.MockImageModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the methods of ImageControllerImpl.
 */
public class ImageControllerImplTest {

  protected IImageModel3 modelNull;
  protected Readable readNull;
  protected IImageModel3 modelGood;
  protected Readable readGood;
  protected ImageControllerImpl controller1;

  @Before
  public void setUp() {
    this.modelNull = null;
    this.readNull = null;
    this.modelGood = new EightBitImageModel3();
    this.readGood = new StringReader("");
    this.controller1 = new ImageControllerImpl(this.modelGood, this.readGood, System.out);
  }

  /**
   * The following tests the constructor of the controller.
   */
  @Test
  public void testControllerConstructor() {
    try {
      new ImageControllerImpl(this.modelNull, this.readGood, System.out);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Model is null", e.getMessage());
    }

    try {
      new ImageControllerImpl(this.modelGood, this.readNull, System.out);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Input stream is null", e.getMessage());
    }

    try {
      new ImageControllerImpl(this.modelGood, this.readGood, null);
      fail();
    } catch (Exception e) {
      assertEquals("Output stream is null", e.getMessage());
    }

    try {
      new ImageControllerImpl(this.modelGood, this.readGood, System.out);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * To test that obtaining an argument at some valid integer works correctly.
   */
  @Test
  public void testCommSubStrValid() {
    ImageControllerImpl controller = new ImageControllerImpl(this.modelGood, this.readGood,
            System.out);
    assertEquals("10", controller.getCommandSubstring("brighten 10 koala "
                    + "koala-brighter", 1));
    assertEquals("koala",
            controller.getCommandSubstring("brighten 10 koala koala-brighter", 2));
    assertEquals("koala-brighter",
            controller.getCommandSubstring("brighten 10 koala koala-brighter", 3));
  }

  /**
   * To test that trying to obtain an argument at some non-positive integer position that is
   * non-existent and is out-of-bounds throws an exception.
   */
  @Test
  public void testCommSubStrNegativeN() {
    try {
      this.controller1.getCommandSubstring("horizontal-flip koala-vertical "
                      + "koala-vertical-horizontal",
              -1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Position n of substring must be greater than or equal to 0",
              e.getMessage());
    }
  }

  /**
   * To test that trying to obtain an argument at some integer position that is
   * non-existent and is out-of-bounds throws an exception.
   */
  @Test
  public void testCommSubStrOutOfBounds() {
    try {
      this.controller1.getCommandSubstring("value-component koala koala-greyscale", 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Position n of substring does not exist", e.getMessage());
    }
  }

  /**
   * Tests the controller using the set of instructions in the readme file of this project.
   * <p></p>Tests the start method and indirectly tests the run command method.
   */
  @Test
  public void testStart1() {
    Readable r = new StringReader("#load exampleimage1.ppm and call it 'example'"
            + System.lineSeparator() + "load test/res/exampleimage1.ppm example"
            + System.lineSeparator() + "#brighten example by adding 10"
            + System.lineSeparator() + "brighten 10 example example-brighter"
            + System.lineSeparator() + "    "
            + System.lineSeparator() + "#flip example vertically"
            + System.lineSeparator() + "vertical-flip example example-vertical"
            + System.lineSeparator() + "#flip the vertically flipped example horizontally"
            + System.lineSeparator() + "horizontal-flip example-vertical example-"
            + "vertical-horizontal"
            + System.lineSeparator() + "#create a greyscale using only the value component, as "
            + "an image example-greyscale"
            + System.lineSeparator() + "value-component example example-greyscale"
            + System.lineSeparator() + "#save example-brighter"
            + System.lineSeparator() + "save test/res/example-brighter.ppm example-brighter"
            + System.lineSeparator() + "#save example-greyscale"
            + System.lineSeparator() + "save test/res/example-greyscale.ppm example-greyscale"
            + System.lineSeparator() + "#overwrite exampleimage with another file"
            + System.lineSeparator() + "load test/res/example-greyscale example"
            + System.lineSeparator() + "#quit"
            + System.lineSeparator() + "q");
    Appendable a = new StringBuilder();
    MockImageModel m = new MockImageModel(a);
    ImageControllerImpl c = new ImageControllerImpl3(m, r, a);

    c.start();

    assertEquals("Welcome to the Image Processor."
                    + System.lineSeparator() + "Please enter commands below."
                    + System.lineSeparator() + "load test/res/exampleimage1.ppm example"
                    + System.lineSeparator() + "brighten 10 example example-brighter"
                    + System.lineSeparator() + "vertical-flip example example-vertical"
                    + System.lineSeparator() + "horizontal-flip example-vertical "
                    + "example-vertical-horizontal"
                    + System.lineSeparator() + "value-component example example-greyscale"
                    + System.lineSeparator() + "save test/res/example-brighter.ppm example-"
                    + "brighter"
                    + System.lineSeparator() + "save test/res/example-greyscale.ppm "
                    + "example-greyscale"
                    + System.lineSeparator() + "load test/res/example-greyscale example"
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
                    + a.toString().split(System.lineSeparator())[7]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[8]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[9]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[10]);
  }

  /**
   * Tests the controller with operations not tested in the previous test-start method.
   * <p></p>Tests the start method and indirectly tests the run command method.
   */
  @Test
  public void testStart2() {
    Readable r = new StringReader("#load exampleimage1.ppm and call it 'example'"
            + System.lineSeparator() + "load test/res/exampleimage1.ppm example"
            + System.lineSeparator() + "#darken example by adding 10"
            + System.lineSeparator() + "darken 10 example example-darker"
            + System.lineSeparator() + "    "
            + System.lineSeparator() + "#create a greyscale using only the green component, as "
            + "an image example-c1"
            + System.lineSeparator() + "green-component example example-c1"
            + System.lineSeparator() + "#create a greyscale using only the red component, as "
            + "an image example-c2"
            + System.lineSeparator() + "red-component example example-c2"
            + System.lineSeparator() + "#create a greyscale using only the luma component, as "
            + "an image example-c3"
            + System.lineSeparator() + "luma-component example example-c3"
            + System.lineSeparator() + "#create a greyscale using only the intensity component, as "
            + "an image example-c4"
            + System.lineSeparator() + "intensity-component example example-c4"
            + System.lineSeparator() + "#create a greyscale using only the blue component, as"
            + " an image example-c5"
            + System.lineSeparator() + "blue-component example example-c5"
            + System.lineSeparator() + "#save a non-existent image - should not work"
            + System.lineSeparator() + "save test/res/example-greyscale9 example9"
            // No error is displayed because we are using a mock model.
            + System.lineSeparator() + "#quit"
            + System.lineSeparator() + "q");
    Appendable a = new StringBuilder();
    MockImageModel m = new MockImageModel(a);
    ImageControllerImpl c = new ImageControllerImpl2(m, r, a);

    c.start();

    assertEquals("Welcome to the Image Processor."
                    + System.lineSeparator() + "Please enter commands below."
                    + System.lineSeparator() + "load test/res/exampleimage1.ppm example"
                    + System.lineSeparator() + "darken 10 example example-darker"
                    + System.lineSeparator() + "green-component example example-c1"
                    + System.lineSeparator() + "red-component example example-c2"
                    + System.lineSeparator() + "luma-component example example-c3"
                    + System.lineSeparator() + "intensity-component example example-c4"
                    + System.lineSeparator() + "blue-component example example-c5"
                    + System.lineSeparator() + "save test/res/example-greyscale9 example9"
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
                    + a.toString().split(System.lineSeparator())[7]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[8]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[9]
                    + System.lineSeparator()
                    + a.toString().split(System.lineSeparator())[10]);
  }
}
