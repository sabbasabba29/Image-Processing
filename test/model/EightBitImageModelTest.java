package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the methods of the EightBitImageModel class.
 */
public class EightBitImageModelTest {
  protected final String testStr = "test/res/example-darker.ppm";
  protected final EightBitImageModelTestHelper model = new EightBitImageModelTestHelper();

  /**
   * This class extends from the eight-bit image model class to obtain an Image
   * given a name, solely used to test the eight-bit image model class methods.
   */
  public static class EightBitImageModelTestHelper extends EightBitImageModel2 {
    /**
     * Returns the Image, given the name as a String in the model, solely for the purposes of
     * testing.
     * <p></p>In the actual model, the actual image would not be obtainable outside
     * the class, as it is never needed outside the model.
     *
     * @param str the Image name
     * @return the Image
     */
    public ImageImpl getImage(String str) {
      ImageImpl image = this.savedKeys.get(str);
      int width = image.getWidth();
      int height = image.getHeight();
      int maxValue = image.getMaxValue();
      Pixel[][] list = new Pixel[height][width];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int r = image.getPixelAt(i, j).getR();
          int g = image.getPixelAt(i, j).getG();
          int b = image.getPixelAt(i, j).getB();
          list[i][j] = new Pixel(r, g, b);
        }
      }
      return new ImageImpl(list);
    }
  }

  /**
   * Testing that a model can be successfully created using the model default constructor.
   */
  @Test
  public void testConstructor() {
    try {
      new EightBitImageModelTest();
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Tests for converting a picture to greyscale by value component.
   */
  @Test
  public void testGreyscaleValue() {
    this.model.load("test-greyscale-val-load", this.testStr);
    this.model.greyscale("test-greyscale-val-load",
            "test-greyscale-val",
            PixelComponent.Value);
    ImageImpl i1 = this.model.getImage("test-greyscale-val");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(192, 192, 192);
    array[0][1] = new Pixel(204, 204, 204);
    array[0][2] = new Pixel(211, 211, 211);
    array[0][3] = new Pixel(213, 213, 213);
    array[1][0] = new Pixel(209, 209, 209);
    array[1][1] = new Pixel(221, 221, 221);
    array[1][2] = new Pixel(229, 229, 229);
    array[1][3] = new Pixel(231, 231, 231);
    array[2][0] = new Pixel(217, 217, 217);
    array[2][1] = new Pixel(229, 229, 229);
    array[2][2] = new Pixel(239, 239, 239);
    array[2][3] = new Pixel(242, 242, 242);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for converting a picture to greyscale by intensity component.
   */
  @Test
  public void testGreyscaleIntensity() {
    this.model.load("test-greyscale-int-load", this.testStr);
    this.model.greyscale("test-greyscale-int-load",
            "test-greyscale-int",
            PixelComponent.Intensity);
    ImageImpl i1 = this.model.getImage("test-greyscale-int");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(84, 84, 84);
    array[0][1] = new Pixel(95, 95, 95);
    array[0][2] = new Pixel(102, 102, 102);
    array[0][3] = new Pixel(104, 104, 104);
    array[1][0] = new Pixel(99, 99, 99);
    array[1][1] = new Pixel(110, 110, 110);
    array[1][2] = new Pixel(118, 118, 118);
    array[1][3] = new Pixel(120, 120, 120);
    array[2][0] = new Pixel(106, 106, 106);
    array[2][1] = new Pixel(118, 118, 118);
    array[2][2] = new Pixel(128, 128, 128);
    array[2][3] = new Pixel(130, 130, 130);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for converting a picture to greyscale by luma component.
   */
  @Test
  public void testGreyscaleLuma() {
    this.model.load("test-greyscale-luma-load", this.testStr);
    this.model.greyscale("test-greyscale-luma-load",
            "test-greyscale-luma",
            PixelComponent.Luma);
    ImageImpl i1 = this.model.getImage("test-greyscale-luma");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(58, 58, 58);
    array[0][1] = new Pixel(69, 69, 69);
    array[0][2] = new Pixel(76, 76, 76);
    array[0][3] = new Pixel(79, 79, 79);
    array[1][0] = new Pixel(73, 73, 73);
    array[1][1] = new Pixel(85, 85, 85);
    array[1][2] = new Pixel(94, 94, 94);
    array[1][3] = new Pixel(96, 96, 96);
    array[2][0] = new Pixel(81, 81, 81);
    array[2][1] = new Pixel(93, 93, 93);
    array[2][2] = new Pixel(104, 104, 104);
    array[2][3] = new Pixel(107, 107, 107);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for converting a picture to greyscale by red component.
   */
  @Test
  public void testGreyscaleRed() {
    this.model.load("test-greyscale-red-load", this.testStr);
    this.model.greyscale("test-greyscale-red-load",
            "test-greyscale-red",
            PixelComponent.Red);
    ImageImpl i1 = this.model.getImage("test-greyscale-red");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(0, 0, 0);
    array[0][1] = new Pixel(7, 7, 7);
    array[0][2] = new Pixel(13, 13, 13);
    array[0][3] = new Pixel(14, 14, 14);
    array[1][0] = new Pixel(9, 9, 9);
    array[1][1] = new Pixel(19, 19, 19);
    array[1][2] = new Pixel(26, 26, 26);
    array[1][3] = new Pixel(28, 28, 28);
    array[2][0] = new Pixel(12, 12, 12);
    array[2][1] = new Pixel(24, 24, 24);
    array[2][2] = new Pixel(33, 33, 33);
    array[2][3] = new Pixel(34, 34, 34);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for converting a picture to greyscale by green component.
   */
  @Test
  public void testGreyscaleGreen() {
    this.model.load("test-greyscale-green-load", this.testStr);
    this.model.greyscale("test-greyscale-green-load",
            "test-greyscale-green",
            PixelComponent.Green);
    ImageImpl i1 = this.model.getImage("test-greyscale-green");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(62, 62, 62);
    array[0][1] = new Pixel(74, 74, 74);
    array[0][2] = new Pixel(82, 82, 82);
    array[0][3] = new Pixel(85, 85, 85);
    array[1][0] = new Pixel(79, 79, 79);
    array[1][1] = new Pixel(92, 92, 92);
    array[1][2] = new Pixel(101, 101, 101);
    array[1][3] = new Pixel(103, 103, 103);
    array[2][0] = new Pixel(89, 89, 89);
    array[2][1] = new Pixel(101, 101, 101);
    array[2][2] = new Pixel(112, 112, 112);
    array[2][3] = new Pixel(116, 116, 116);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for converting a picture to greyscale by blue value.
   */
  @Test
  public void testGreyscaleBlue() {
    this.model.load("test-greyscale-blue-load", this.testStr);
    this.model.greyscale("test-greyscale-blue-load",
            "test-greyscale-blue",
            PixelComponent.Blue);
    ImageImpl i1 = this.model.getImage("test-greyscale-blue");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(192, 192, 192);
    array[0][1] = new Pixel(204, 204, 204);
    array[0][2] = new Pixel(211, 211, 211);
    array[0][3] = new Pixel(213, 213, 213);
    array[1][0] = new Pixel(209, 209, 209);
    array[1][1] = new Pixel(221, 221, 221);
    array[1][2] = new Pixel(229, 229, 229);
    array[1][3] = new Pixel(231, 231, 231);
    array[2][0] = new Pixel(217, 217, 217);
    array[2][1] = new Pixel(229, 229, 229);
    array[2][2] = new Pixel(239, 239, 239);
    array[2][3] = new Pixel(242, 242, 242);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for flipping a picture horizontally.
   */
  @Test
  public void testFlipHoriz() {
    this.model.load("test-flip-horiz-load", this.testStr);
    this.model.flipHoriz("test-flip-horiz-load",
            "test-flip-horiz");
    ImageImpl i1 = this.model.getImage("test-flip-horiz");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(14, 85, 213);
    array[0][1] = new Pixel(13, 82, 211);
    array[0][2] = new Pixel(7, 74, 204);
    array[0][3] = new Pixel(0, 62, 192);
    array[1][0] = new Pixel(28, 103, 231);
    array[1][1] = new Pixel(26, 101, 229);
    array[1][2] = new Pixel(19, 92, 221);
    array[1][3] = new Pixel(9, 79, 209);
    array[2][0] = new Pixel(34, 116, 242);
    array[2][1] = new Pixel(33, 112, 239);
    array[2][2] = new Pixel(24, 101, 229);
    array[2][3] = new Pixel(12, 89, 217);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for flipping a picture vertically.
   */
  @Test
  public void testFlipVert() {
    this.model.load("test-flip-vert-load", this.testStr);
    this.model.flipVert("test-flip-vert-load",
            "test-flip-vert");
    ImageImpl i1 = this.model.getImage("test-flip-vert");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(12, 89, 217);
    array[0][1] = new Pixel(24, 101, 229);
    array[0][2] = new Pixel(33, 112, 239);
    array[0][3] = new Pixel(34, 116, 242);
    array[1][0] = new Pixel(9, 79, 209);
    array[1][1] = new Pixel(19, 92, 221);
    array[1][2] = new Pixel(26, 101, 229);
    array[1][3] = new Pixel(28, 103, 231);
    array[2][0] = new Pixel(0, 62, 192);
    array[2][1] = new Pixel(7, 74, 204);
    array[2][2] = new Pixel(13, 82, 211);
    array[2][3] = new Pixel(14, 85, 213);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for brightening a picture.
   */
  @Test
  public void testBrighten() {
    this.model.load("test-bright-10-load", this.testStr);
    this.model.brighten("test-bright-10-load",
            "test-bright-10", 10);
    ImageImpl i1 = this.model.getImage("test-bright-10");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(10, 72, 202);
    array[0][1] = new Pixel(17, 84, 214);
    array[0][2] = new Pixel(23, 92, 221);
    array[0][3] = new Pixel(24, 95, 223);
    array[1][0] = new Pixel(19, 89, 219);
    array[1][1] = new Pixel(29, 102, 231);
    array[1][2] = new Pixel(36, 111, 239);
    array[1][3] = new Pixel(38, 113, 241);
    array[2][0] = new Pixel(22, 99, 227);
    array[2][1] = new Pixel(34, 111, 239);
    array[2][2] = new Pixel(43, 122, 249);
    array[2][3] = new Pixel(44, 126, 252);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for darkening a picture.
   */
  @Test
  public void testDarken() {
    this.model.load("test-darken-10-load", this.testStr);
    this.model.darken("test-darken-10-load",
            "test-darken-10", 10);
    ImageImpl i1 = this.model.getImage("test-darken-10");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(0, 52, 182);
    array[0][1] = new Pixel(0, 64, 194);
    array[0][2] = new Pixel(3, 72, 201);
    array[0][3] = new Pixel(4, 75, 203);
    array[1][0] = new Pixel(0, 69, 199);
    array[1][1] = new Pixel(9, 82, 211);
    array[1][2] = new Pixel(16, 91, 219);
    array[1][3] = new Pixel(18, 93, 221);
    array[2][0] = new Pixel(2, 79, 207);
    array[2][1] = new Pixel(14, 91, 219);
    array[2][2] = new Pixel(23, 102, 229);
    array[2][3] = new Pixel(24, 106, 232);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Test that loading the image and immediately saving saves the same image before
   * and after doing so (testing that load and save work correctly).
   */
  @Test
  public void testLoadSave() {
    this.model.load("test-load-save-load", this.testStr);

    ImageImpl i1 = this.model.getImage("test-load-save-load");


    this.model.save("test-load-save-load",
            this.testStr);

    this.model.load("test-load-save-load",
            this.testStr);
    ImageImpl i2 = this.model.getImage("test-load-save-load");

    assertEquals(i2, i1);
  }
}