package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the EightBitImageModel2 class.
 * <p></p>ImageProcessing Project.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Thursday, November 10, 2022 7:55 PM Eastern Time
 */
public class EightBitImageModel2Test extends EightBitImageModelTest {
  /**
   * Tests for filtering an image with a kernel.
   */
  @Test
  public void testFilter() {
    Pixel[][] p = new Pixel[2][2];
    p[0][0] = new Pixel(12, 134, 125);
    p[0][1] = new Pixel(144, 15, 223);
    p[1][0] = new Pixel(251, 32, 224);
    p[1][1] = new Pixel(124, 135, 96);
    ImageImpl i = new ImageImpl(p);

    double[][] k = new double[3][3];
    k[0][0] = -0.5;
    k[0][1] = 2.0;
    k[0][2] = -0.5;
    k[1][0] = 2.0;
    k[1][1] = 1.0;
    k[1][2] = 2.0;
    k[2][0] = -0.5;
    k[2][1] = 2.0;
    k[2][2] = -0.5;

    Pixel[][] x = new Pixel[2][2];
    x[0][0] = new Pixel(255, 160, 255);
    x[0][1] = new Pixel(255, 255, 255);
    x[1][0] = new Pixel(255, 255, 255);
    x[1][1] = new Pixel(255, 162, 255);
    ImageImpl r = new ImageImpl(x);

    ImageImpl l = this.model.filter(i, k);

    assertEquals(r, l);
  }

  /**
   * Tests for color transforming an image with a given matrix.
   */
  @Test
  public void testColorTransform() {
    Pixel[][] p = new Pixel[2][2];
    p[0][0] = new Pixel(12, 134, 125);
    p[0][1] = new Pixel(144, 15, 223);
    p[1][0] = new Pixel(251, 32, 224);
    p[1][1] = new Pixel(124, 135, 96);
    ImageImpl i = new ImageImpl(p);

    double[][] m = new double[3][3];
    m[0][0] = 0.5;
    m[0][1] = 0.02;
    m[0][2] = 0.5;
    m[1][0] = 0.02;
    m[1][1] = 0.11;
    m[1][2] = 0.02;
    m[2][0] = 0.5;
    m[2][1] = 0.02;
    m[2][2] = 0.5;

    Pixel[][] x = new Pixel[2][2];
    x[0][0] = new Pixel(71, 17, 71);
    x[0][1] = new Pixel(183, 8, 183);
    x[1][0] = new Pixel(238, 13, 238);
    x[1][1] = new Pixel(112, 19, 112);
    ImageImpl r = new ImageImpl(x);

    ImageImpl l = this.model.colorTransform(i, m);

    assertEquals(r, l);
  }

  /**
   * Tests for blurring a picture.
   */
  @Test
  public void testBlur() {
    this.model.load("test-blur-load", this.testStr);
    this.model.blur("test-blur-load",
            "test-blur");
    ImageImpl i1 = this.model.getImage("test-blur");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(3, 40, 113);
    array[0][1] = new Pixel(7, 59, 156);
    array[0][2] = new Pixel(12, 65, 161);
    array[0][3] = new Pixel(10, 50, 122);
    array[1][0] = new Pixel(8, 61, 158);
    array[1][1] = new Pixel(16, 88, 217);
    array[1][2] = new Pixel(23, 97, 225);
    array[1][3] = new Pixel(19, 75, 171);
    array[2][0] = new Pixel(8, 50, 122);
    array[2][1] = new Pixel(16, 73, 169);
    array[2][2] = new Pixel(21, 79, 175);
    array[2][3] = new Pixel(17, 62, 133);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for sharpening a picture.
   */
  @Test
  public void testSharpen() {
    this.model.load("test-sharpen-load", this.testStr);
    this.model.sharpen("test-sharpen-load",
            "test-sharpen");
    ImageImpl i1 = this.model.getImage("test-sharpen");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(0, 62, 209);
    array[0][1] = new Pixel(5, 102, 255);
    array[0][2] = new Pixel(22, 125, 255);
    array[0][3] = new Pixel(16, 94, 238);
    array[1][0] = new Pixel(15, 146, 255);
    array[1][1] = new Pixel(40, 229, 255);
    array[1][2] = new Pixel(66, 255, 255);
    array[1][3] = new Pixel(51, 193, 255);
    array[2][0] = new Pixel(15, 103, 247);
    array[2][1] = new Pixel(36, 154, 255);
    array[2][2] = new Pixel(58, 181, 255);
    array[2][3] = new Pixel(46, 140, 255);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }

  /**
   * Tests for a greyscale on a picture using a color transform.
   */
  @Test
  public void testGreyScaleCT() {
    this.model.load("test-gsct-load", this.testStr);
    this.model.greyscale("test-gsct-load",
            "test-gsct");
    ImageImpl i1 = this.model.getImage("test-gsct");
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
   * Tests for sepia-toning a picture.
   */
  @Test
  public void testSepia() {
    this.model.load("test-sepia-load", this.testStr);
    this.model.sepia("test-sepia-load",
            "test-sepia");
    ImageImpl i1 = this.model.getImage("test-sepia");
    Pixel[][] array = new Pixel[3][4];

    array[0][0] = new Pixel(83, 74, 58);
    array[0][1] = new Pixel(98, 87, 68);
    array[0][2] = new Pixel(108, 96, 74);
    array[0][3] = new Pixel(111, 98, 77);
    array[1][0] = new Pixel(103, 92, 72);
    array[1][1] = new Pixel(119, 106, 83);
    array[1][2] = new Pixel(131, 116, 91);
    array[1][3] = new Pixel(133, 119, 92);
    array[2][0] = new Pixel(114, 101, 79);
    array[2][1] = new Pixel(130, 116, 90);
    array[2][2] = new Pixel(144, 128, 100);
    array[2][3] = new Pixel(148, 132, 102);

    ImageImpl i2 = new ImageImpl(array);
    assertEquals(i2, i1);
  }
}