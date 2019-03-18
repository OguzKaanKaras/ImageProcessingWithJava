package ımageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {


        //ImageOperations.print(arr);
        /************* with zoom photo**************/
        //   BufferedImage img = ImageOperations.readFromFile("src\\Image\\background.jpg");/*****background******/
        // BufferedImage photo = ImageIO.read(new File("src\\Image\\gm.jpg"));/*****photo that needs to get zoom***/
        //int[][] arr = ImageOperations.ımageToInt(img);
        //ImageOperations.zoomPhoto(arr,photo);
        /*********************************************/

        /************* negativeOfImage, translationOfImage, mirroringOfImage, brightnessOfImage, contrastOfImage**************/
        //  BufferedImage img = ImageOperations.readFromFile("src\\Image\\gm.jpg");
        // int[][] arr = ImageOperations.ımageToInt(img);
        // ImageOperations.negativeOfImage(arr);
        //  ImageOperations.translationOfImage(arr);
        //  ImageOperations.mirroringOfImage(arr);
        // ImageOperations.brightnesOfImage(arr);
        // ImageOperations.contrastOfImage(arr);
        /*********************************************/

        /************* imageTresholding, stretchingPhoto, creatingHistogram, histogramSynchronization**************/
        BufferedImage img = ImageOperations.readFromFile("src\\Image\\grey.jpg");
        int[][] arr = ImageOperations.ımageToInt(img);
        // ImageOperations.imageTresholding(arr);
        // ImageOperations.stretchingPhoto(arr);
        // ImageOperations.creatingHistogram(arr);
        // ImageOperations.histogramSynchronization(arr);/*******on histogram table */
        /*********************************************/


        ResimSahne rs = new ResimSahne(img);
    }
}



