package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * To test the Image class.
 * <p></p>ImageProcessing.
 * <p></p>CS 3500 02 - Object-Oriented Design | CS 3501 03 - Lab for CS 3500.
 *
 * @author Tyler Chung
 * @version %I%, Thursday, November 03, 2022 11:08 PM Eastern Time
 */
public class ImageImplTest {
  Pixel[][] list = new Pixel[6][9];
  ImageImpl image;

  /**
   * To set up this test class before tests are conducted.
   */
  @Before
  public void setUp() {
    int r = 4;
    int g = 9;
    int b = 113;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        this.list[i][j] = new Pixel(r, g, b);
        r++;
      }
      b += 3;
    }

    this.image = new ImageImpl(9, 6, 128, this.list);
  }

  /**
   * To test the constructor.
   */
  @Test
  public void testConstructor() {
    Pixel[][] list2 = new Pixel[6][9];

    int r = 4;
    int g = 9;
    int b = 113;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        list2[i][j] = new Pixel(r, g, b);
        r++;
      }
      b += 3;
    }

    assertEquals(this.image, new ImageImpl(9, 6, 128, list2));

    try {
      new ImageImpl(9, 6, -1, list2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Max value must be a positive integer", e.getMessage());
    } try {
      new ImageImpl(9, 6, 256, list2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Max value must be below 256", e.getMessage());
    } try {
      new ImageImpl(9, 6, 128, new Pixel[0][9]);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Pixel list height must be a positive integer", e.getMessage());
    } try {
      new ImageImpl(9, 6, 128, new Pixel[6][0]);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Pixel list width must be a positive integer", e.getMessage());
    } try {
      new ImageImpl(10, 6, 128, list2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Pixel list width and given width do not match", e.getMessage());
    } try {
      new ImageImpl(9, 5, 128, list2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Pixel list height and given height do not match", e.getMessage());
    }
  }

  /**
   * To test the get width method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(9, this.image.getWidth());
  }

  /**
   * To test the get width method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(6, this.image.getHeight());
  }

  /**
   * To test the get max value method.
   */
  @Test
  public void testGetMaxValue() {
    assertEquals(128, this.image.getMaxValue());
  }

  /**
   * To test the get pixel at method.
   */
  @Test
  public void testGetPixelAt() {
    assertEquals(new Pixel(36, 9, 122), this.image.getPixelAt(3,5));
  }

  /**
   * To test the get pixel at method where an exception is thrown if the position is invalid.
   */
  @Test
  public void testGetPixelAtInvalid() {
    try {
      this.image.getPixelAt(6, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Could not find pixel at given position", e.getMessage());
    } try {
      this.image.getPixelAt(1, 10);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Could not find pixel at given position", e.getMessage());
    } try {
      this.image.getPixelAt(-4, 5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Could not find pixel at given position", e.getMessage());
    } try {
      this.image.getPixelAt(5, -2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Could not find pixel at given position", e.getMessage());
    }
  }

  /**
   * To test the equals method where it returns true and the hash code method.
   */
  @Test
  public void testEqualsTrueHashCode() {
    Pixel[][] list2 = new Pixel[6][9];
    ImageImpl image2;

    int r = 4;
    int g = 9;
    int b = 113;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        list2[i][j] = new Pixel(r, g, b);
        r++;
      }
      b += 3;
    }

    image2 = new ImageImpl(9, 6, 128, list2);

    assertEquals(this.image, image2);
    assertEquals(1647492507, image2.hashCode());
    assertEquals(this.image.hashCode(), image2.hashCode());
  }

  /**
   * To test the equals method where it returns true and the hash code method.
   */
  @Test
  public void testEqualsFalseHashCode() {
    assertNotEquals("x", this.image);

    Pixel[][] list2 = new Pixel[5][9];
    ImageImpl image2;

    int r2 = 4;
    int g2 = 9;
    int b2 = 113;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 9; j++) {
        list2[i][j] = new Pixel(r2, g2, b2);
        r2++;
      }
      b2 += 3;
    }

    image2 = new ImageImpl(9, 5, 125, list2);

    assertNotEquals(this.image, image2);
    assertEquals(1170410355, image2.hashCode());
    if (this.image.hashCode() == image2.hashCode()) {
      fail();
    }

    Pixel[][] list3 = new Pixel[6][10];
    ImageImpl image3;

    int r3 = 4;
    int g3 = 9;
    int b3 = 113;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 10; j++) {
        list3[i][j] = new Pixel(r3, g3, b3);
        r3++;
      }
      b3 += 3;
    }

    image3 = new ImageImpl(10, 6, 128, list3);

    assertNotEquals(this.image, image3);
    assertEquals(2010547230, image3.hashCode());
    if (this.image.hashCode() == image3.hashCode()) {
      fail();
    }

    Pixel[][] list4 = new Pixel[6][9];
    ImageImpl image4;

    int r4 = 4;
    int g4 = 9;
    int b4 = 113;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        list4[i][j] = new Pixel(r4, g4, b4);
        r4++;
        if (i == 5 && j == 8) {
          list4[i][j] = new Pixel(r4, g4, 245);
        }
      }
      b4 += 3;
    }

    image4 = new ImageImpl(9, 6, 245, list4);

    assertNotEquals(this.image, image4);
    assertEquals(1648492624, image4.hashCode());
    if (this.image.hashCode() == image4.hashCode()) {
      fail();
    }

    Pixel[][] list5 = new Pixel[6][9];
    ImageImpl image5;

    int r5 = 4;
    int g5 = 9;
    int b5 = 113;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        list5[i][j] = new Pixel(r5, g5, b5);
        r5++;
      }
      b5 += 2;
    }

    image5 = new ImageImpl(9, 6, 123, list5);

    assertNotEquals(this.image, image5);
    assertEquals(1647492372, image5.hashCode());
    if (this.image.hashCode() == image5.hashCode()) {
      fail();
    }
  }
}