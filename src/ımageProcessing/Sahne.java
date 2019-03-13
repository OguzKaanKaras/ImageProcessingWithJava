package ımageProcessing;

import javax.swing.*;
import java.awt.image.BufferedImage;

class ResimSahne extends JFrame {
    ımagePanel pnl;
   public ResimSahne(String path){
       pnl=new ımagePanel(path);
       Int();
    }
    public ResimSahne(BufferedImage image){
        pnl=new ımagePanel(image);
        Int();
    }

    private void Int(){
        add (pnl);
        setSize(pnl.getImg().getWidth(),pnl.getImg().getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
