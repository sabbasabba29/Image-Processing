package model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * The following class is created to test the Pixel class and its methods.
 */
public class PixelTest {

  private IPixel pixel;
  private IPixel pixelLarger;

  /**
   * To set up this test class before tests are conducted.
   */
  @Before
  public void setUp() {
    pixel = new Pixel(1, 1, 1);
    pixelLarger = new Pixel(120, 240, 250);
  }

  // Constructor Tests

  /**
   * The following test checks that the workings of the Pixel class work properly.
   */
  @Test
  public void testPixel() {
    assertEquals(1, pixel.getR());
    assertEquals(1, pixel.getG());
    assertEquals(1, pixel.getB());
    assertEquals(1, pixel.getIntensity());
    assertEquals(1, pixel.getValue());
    assertEquals(1, pixel.getLuma());
    assertEquals(120, pixelLarger.getR());
    assertEquals(240, pixelLarger.getG());
    assertEquals(250, pixelLarger.getB());
    assertEquals(203, pixelLarger.getIntensity());
    assertEquals(250, pixelLarger.getValue());
    assertEquals(215, pixelLarger.getLuma());

    try {
      IPixel pixelLess = new Pixel(-1, 0, 0);
      pixelLess.getR();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("R must be greater than or equal to 0", e.getMessage());
    }

    try {
      IPixel pixelLess = new Pixel(0, -1, 0);
      pixelLess.getG();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("G must be greater than or equal to 0", e.getMessage());
    }

    try {
      IPixel pixelLess = new Pixel(0, 0, -1);
      pixelLess.getB();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("B must be greater than or equal to 0", e.getMessage());
    }

    try {
      IPixel pixelLess = new Pixel(256, 0, 0);
      pixelLess.getR();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("R must be below 256", e.getMessage());
    }

    try {
      IPixel pixelLess = new Pixel(0, 256, 0);
      pixelLess.getG();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("G must be below 256", e.getMessage());
    }

    try {
      IPixel pixelLess = new Pixel(0, 0, 256);
      pixelLess.getB();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("B must be below 256", e.getMessage());
    }
  }

  /**
   * To test that the equals and hash code methods work correctly.
   */
  @Test
  public void testEqualsHashCode() {
    Pixel a = new Pixel(16, 125, 232);
    Pixel b = new Pixel(16, 125, 232);
    Pixel c = new Pixel(15, 125, 232);
    Pixel d = new Pixel(16, 126, 232);
    Pixel e = new Pixel(16, 125, 220);

    assertEquals(a, a);
    assertEquals(16125232, a.hashCode());
    assertEquals(a, b);
    assertEquals(16125232, b.hashCode());
    assertEquals(a.hashCode(), b.hashCode());
    assertNotEquals(a, c);
    assertEquals(15125232, c.hashCode());
    assertNotEquals(a, d);
    assertEquals(16126232, d.hashCode());
    assertNotEquals(a, e);
    assertEquals(16125220, e.hashCode());
    assertNotEquals(a, new HashMap<>());
  }
}
