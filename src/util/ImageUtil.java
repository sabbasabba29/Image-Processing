package util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;

import model.ImageImpl;
import model.Pixel;

/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * <p></p> Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and return the file as an Image object.
   *
   * @param filename the path of the file
   * @throws IllegalArgumentException if the file cannot be found or is invalid
   */
  public static ImageImpl readPPM(String filename) throws IllegalArgumentException {
    Scanner sc;
    String typeOfFile = "";

    for (int i = 0; i < filename.length(); i++) {
      if (filename.charAt(i) == '.') {
        typeOfFile = filename.substring(i + 1);
      }
    }

    switch (typeOfFile) {
      case "ppm":

        try {
          sc = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
          throw new IllegalArgumentException("File " + filename + " not found!");
        }
        StringBuilder builder = new StringBuilder();
        //read the file line by line, and populate a string. This will throw away any comment lines
        while (sc.hasNextLine()) {
          String s = sc.nextLine();
          if (s.charAt(0) != '#') {
            builder.append(s).append(System.lineSeparator());
          }
        }

        //now set up the scanner to read from the string we just built
        sc = new Scanner(builder.toString());

        String token;

        token = sc.next();
        if (!token.equals("P3")) {
          //System.out.println("Invalid PPM file: plain RAW file should begin with P3");
          throw new
                  IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
        }
        int width = sc.nextInt();
        //System.out.println("Width of image: " + width);
        int height = sc.nextInt();
        //System.out.println("Height of image: " + height);
        sc.nextInt();
        //System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

        Pixel[][] pixelList = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            pixelList[i][j] = new Pixel(r, g, b);
            //System.out.println("" + j + " " + i + " " + r + " " + g + " " + b);
          }
        }
        return new ImageImpl(pixelList);
      case "jpeg":
      case "png":
      case "bmp":
      case "jpg":
        try {
          BufferedImage image = ImageIO.read(new File(filename));
          Pixel[][] pixelList1 = new Pixel[image.getWidth()][image.getHeight()];
          for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
              java.awt.Color color = new Color(image.getRGB(i, j));
              pixelList1[i][j] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
            }
          }
          return new ImageImpl(pixelList1);
        } catch (IOException e) {
          throw new IllegalStateException("Could not read file");
        }
      default:
        throw new IllegalArgumentException("Incorrect file type");
    }
  }

  /**
   * Save a given Image as a file with a given name.
   *
   * @param image the Image representation object
   * @param s the String to name the file as
   * @throws IllegalStateException if the there is an error in writing
   *      to the output stream
   * @throws IllegalArgumentException if there is an error in creating the output stream with
   *      the given file name
   */
  public static void savePPM(ImageImpl image, String s) {
    String typeOfFile = "";

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '.') {
        typeOfFile = s.substring(i + 1);
      }
    }

    switch (typeOfFile) {
      case "ppm":
        try {
          PrintWriter printWriter = new PrintWriter(new FileOutputStream(s));
          try {
            printWriter.println("P3");
            printWriter.println(image.getWidth());
            printWriter.println(image.getHeight());
            printWriter.println(image.getMaxValue());
            for (int i = 0; i < image.getHeight(); i++) {
              for (int j = 0; j < image.getWidth(); j++) {
                printWriter.println(image.getPixelAt(i, j).getR());
                printWriter.println(image.getPixelAt(i, j).getG());
                printWriter.println(image.getPixelAt(i, j).getB());
              }
            }
            printWriter.close();
          } catch (Exception ex) {
            throw new IllegalStateException(ex.getMessage());
          }
        } catch (FileNotFoundException e) {
          throw new IllegalArgumentException(e.getMessage());
        }
        break;
      case "png":
      case "jpeg":
      case "jpg":
      case "bmp":
        BufferedImage imageSave =
                new BufferedImage(image.getHeight(), image.getWidth(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imageSave.getWidth(); i++) {
          for (int j = 0; j < imageSave.getHeight(); j++) {
            int pixelR = image.getPixelAt(i, j).getR();
            int pixelG = image.getPixelAt(i, j).getG();
            int pixelB = image.getPixelAt(i, j).getB();
            java.awt.Color color = new Color(pixelR, pixelG, pixelB);
            imageSave.setRGB(i, j, color.getRGB());
          }
        }
        try {
          ImageIO.write(imageSave, typeOfFile, new File(s));
        } catch (IOException e) {
          throw new IllegalStateException("Could not read file");
        }
        break;
      default:
        throw new IllegalArgumentException("Incorrect file type");
    }

  }
}