package ımageProcessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ımagePanel extends JPanel {
    private BufferedImage img;
    public ımagePanel(String path) {
        try{
            img= ImageIO.read(new File(path));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public ımagePanel(BufferedImage img) {
        this.img=img;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
   @Override
   public void paintComponent(Graphics g){
        g.drawImage(this.img,0,0,null);
        repaint();
    }
}
