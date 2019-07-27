package ımageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.*;

public class ImageOperations {
    private static BufferedImage image;

    public static BufferedImage getImage() {
        return image;
    }

    public static void setImage(BufferedImage image) {
        ImageOperations.image = image;
    }

    public static BufferedImage readFromFile(String path) {

        File file = new File(path);
        try {
            image = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return image;
    }

    public static int[][] ımageToInt(BufferedImage img) {
        int[][] arr = new int[img.getHeight()][img.getWidth()];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                arr[i][j] = img.getRGB(j, i);
            }
        }
        return arr;

    }


    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void negativeOfImage(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int a = (arr[i][j] >> 24) & 0xff;

                //get red
                int r = (arr[i][j] >> 16) & 0xff;
                r = 255 - r;
                if (r < 0)
                    r = 0;
                //get green
                int g = (arr[i][j] >> 8) & 0xff;
                g = 255 - g;
                if (g < 0)
                    g = 0;
                //get blue
                int b = arr[i][j] & 0xff;
                b = 255 - b;
                if (b < 0)
                    b = 0;
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(j, i, p);

            }
        }
    }

    public static void translationOfImage(int[][] arr) {
        int[][] newArr = new int[arr.length + 50][arr[0].length + 50];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[i + 50][j + 50] = arr[i][j];
                image.setRGB(j, i, newArr[i][j]);
            }
        }
    }


    public static void mirroringOfImage(int[][] arr) {
        int i, j;
        int[][] newArr = new int[arr.length][arr[0].length];
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[0].length; j++) {
                newArr[i][j] = arr[i][arr[0].length - 1 - j];
            }
        }
        for (i = 0; i < newArr.length; i++) {
            for (j = 0; j < newArr[0].length; j++) {
                image.setRGB(j, i, newArr[i][j]);
            }
        }
    }

    public static void brightnesOfImage(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int a = (arr[i][j] >> 24) & 0xff;

                //get red
                int r = (arr[i][j] >> 16) & 0xff;
                r = r + 80;
                if (r > 255)
                    r = 255;
                //get green
                int g = (arr[i][j] >> 8) & 0xff;
                g = g + 80;
                if (g > 255)
                    g = 255;
                //get blue
                int b = arr[i][j] & 0xff;
                b = b + 80;
                if (b > 255)
                    b = 255;
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(j, i, p);
            }
        }
    }

    public static void contrastOfImage(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int a = (arr[i][j] >> 24) & 0xff;
                //get red
                int r = (arr[i][j] >> 16) & 0xff;
                r = r * 2;
                if (r > 255)
                    r = 255;
                //get green
                int g = (arr[i][j] >> 8) & 0xff;
                g = g * 2;
                if (g > 255)
                    g = 255;
                //get blue
                int b = arr[i][j] & 0xff;
                b = b * 2;
                if (b > 255)
                    b = 255;
                int p = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(j, i, p);
            }
        }
    }

    public static void imageTresholding(int[][] arr) {

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                if (arr[i][j] > -7000000)
                    arr[i][j] = 16777215;
                if (arr[i][j] < -700000)
                    arr[i][j] = 0;
                image.setRGB(j, i, arr[i][j]);
            }
        }

    }

    

    public static void stretchingPhoto(int[][] arr) {
        int a, r, g, b, i, j, p, ort, x;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[0].length; j++) {
                a = (arr[i][j] >> 24) & 0xff;

                r = (arr[i][j] >> 16) & 0xff;

                g = (arr[i][j] >> 8) & 0xff;


                b = arr[i][j] & 0xff;
                ort = (r + g + b) / 3;
                x = (155) * (ort - 0) / (255 - 0) + 0;


                p = (a << 24) | (x << 16) | (x << 8) | x;
                arr[i][j] = p;
                image.setRGB(j, i, arr[i][j]);
            }
        }
    }

    public static void creatingHistogram(int[][] arr) {
        int[] newArr = new int[256];
        int r, i, j;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[0].length; j++) {
                r = (arr[i][j] >> 16) & 0xff;
                newArr[r]++;
            }
        }
        for (i = 0; i < newArr.length; i++) {
            if (newArr[i] != 0)
                System.out.println("RGB:"+  i+ " --> " + newArr[i] );
        }
    }

    public static void histogramSynchronization(int[][] arr) {

        double[] kümHis = new double[256];
        int[] newArr = new int[256];
        int top = arr.length*arr[0].length;
        int a, r, i, j;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[0].length; j++) {
                r = (arr[i][j] >> 16) & 0xff;
                newArr[r]++;
            }
        }
        kümHis[0] = newArr[0];
        for (i = 1; i < newArr.length; i++) {
            kümHis[i] = (newArr[i] + kümHis[i - 1]);

        }
        for (i = 0; i < kümHis.length; i++) {
            kümHis[i] = Math.ceil(kümHis[i] / top * 255);
            System.out.println(kümHis[i]);
        }


    }

}
