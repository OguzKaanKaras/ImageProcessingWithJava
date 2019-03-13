package ımageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BufferedImage img = ImageOperations.readFromFile("src\\Image\\adam.jpg");
        int[][]dizi =ImageOperations.ımageToInt(img);
        ResimSahne rs = new ResimSahne(img);
   /*    Color myWhite = new Color(0, 0, 0); // Color white
        int rgb = myWhite.getRGB();

        try {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("src\\Image\\profile.jpg"));
            }
            catch (IOException e) {
            }

            for (int i = 0; i < ; i++) {
                for (int j = 0; j < 255; j++) {
                    img.setRGB(i, j, rgb);
                }
            }

            // retrieve image
            File outputfile = new File("saved2.png");
            ImageIO.write(img, "png", outputfile);
        }
        catch (IOException e) {
        }
    }*/





            }
        }



