
package controller;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

    public class Image_Panel_class extends JPanel{ // Class không / chưa được sử dụng tới 
        private final Image img;
        public Image_Panel_class(String img) throws IOException{
            this.img = ImageIO.read(new File(img));
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(this.img, 0, 0, this);
        }
    }