package ımageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        int[][] dizi = new int[img.getWidth()][img.getHeight()];
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                dizi[i][j] = img.getRGB(i, j);

         /*       int a = (dizi[i][j]>>24) & 0xff;

                //get red
                int r = (dizi[i][j]>>16) & 0xff;
                r=r+75;
                if(r>255)
                    r=255;
                //get green
                int g = (dizi[i][j]>>8) & 0xff;
                g=g+75;
                if(g>255)
                    g=255;
                //get blue
                int b = dizi[i][j] & 0xff;
                b=b+75;
                if(b>255)
                    b=255;
                int p=(a<<24) | (r<<16) | (g<<8) | b;
                System.out.println("a="+a);
                System.out.println("r="+r);
                System.out.println("g="+g);
                System.out.println("b="+b);
                int d=dizi[i][j]+rgb;
                img.setRGB(i,j,p);
                System.out.println(dizi[i][j]);*/
            }
        }
        return dizi;

    }

    public static void yazdir(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                System.out.println(dizi[i][j]);
            }
        }
    }

    public static void negativeOfImage(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                int a = (dizi[i][j] >> 24) & 0xff;

                //get red
                int r = (dizi[i][j] >> 16) & 0xff;
                r = 255 - r;
                if (r < 0)
                    r = 0;
                //get green
                int g = (dizi[i][j] >> 8) & 0xff;
                g = 255 - g;
                if (g < 0)
                    g = 0;
                //get blue
                int b = dizi[i][j] & 0xff;
                b = 255 - b;
                if (b < 0)
                    b = 0;
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(i, j, p);

            }
        }
    }

    public static void ImageTranslation(int[][] dizi) {
        int[][] newDizi = new int[dizi.length + 50][dizi[0].length + 50];
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                newDizi[i + 50][j + 50] = dizi[i][j];
                image.setRGB(i, j, newDizi[i][j]);
            }
        }
    }


}
