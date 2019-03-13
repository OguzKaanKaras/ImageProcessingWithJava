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
    public static  int[][] ımageToInt(BufferedImage img){
        int[][] dizi=new int[img.getWidth()+50][img.getHeight()+50];
        for(int i=0;i<img.getWidth();i++){
            for (int j=0;j<img.getHeight();j++){
                dizi[i][j]=img.getRGB(i,j);

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
    public static void yazdir(int[][] dizi){
        for(int i=0;i<dizi.length;i++){
            for (int j=0;j<dizi[0].length;j++){
                System.out.println(dizi[i][j]);
            }
        }
    }
 /*   public static void dosya(double[][] dizi){
        //double[][] dizi1=new double[dizi.length][dizi[0].length];
        BufferedImage img = null;
        for(int i=0;i<dizi.length;i++){
            for (int j=0;j<dizi[0].length;j++){
               img.setRGB(i,j,dizi[i][j]);
            }
        }
    }*/
}
